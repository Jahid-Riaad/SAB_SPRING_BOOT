package com.sab.apigateway.filter;

import com.sab.security.util.JwtTokenProvider;
import com.sab.security.util.UserDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class JwtAuthenticationFilter implements WebFilter {
    private final JwtTokenProvider jwtTokenProvider;
    private final WebClient.Builder webClientBuilder;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, WebClient.Builder webClientBuilder) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String token = extractToken(exchange);

        if (token == null) {
            return chain.filter(exchange);
        }

        // Use WebClient for reactive non-blocking call to auth-service
        return webClientBuilder.build()
                .post()
                .uri("http://user-service/auth/validate-token")
                .bodyValue(token)
                .retrieve()
                .bodyToMono(UserDTO.class)
                .flatMap(userDTO -> {
                    if (userDTO != null) {
                        // Create an Authentication token using user details
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                userDTO.getUsername(), null, getGrantedAuthorities(userDTO.getAuthorities()));

                        // Set authentication in ReactiveSecurityContextHolder and proceed
                        SecurityContext securityContext = new SecurityContextImpl(authToken);
                        return chain.filter(exchange)
                                .contextWrite(ReactiveSecurityContextHolder.withSecurityContext(Mono.just(securityContext)));
                    } else {
                        return onError(exchange); // If no valid userDTO is received
                    }
                })
                .onErrorResume(e -> onError(exchange));  // Handle error case
    }

    private String extractToken(ServerWebExchange exchange) {
        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);  // Extract the JWT token from the header
        }
        return null;
    }

    private Mono<Void> onError(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
