package com.sab.apigateway.security;

import com.sab.apigateway.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

import static org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers.pathMatchers;

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) {
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)  // Disable CSRF for API Gateway
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("api/public/**").permitAll()
                        .pathMatchers("/user/auth/**").permitAll()
                        .pathMatchers("api/**").authenticated()
                        .anyExchange().authenticated()
                )
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)  // Disable default basic auth
                .formLogin(ServerHttpSecurity.FormLoginSpec::disable)  // Disable form-based login
                .addFilterAt(jwtAuthenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION)  // Add JWT filter
                .build();
    }
    @Bean
    public ReactiveAuthenticationManager reactiveAuthenticationManager() {
        // Custom AuthenticationManager to prevent default password generation
        return authentication -> Mono.just(new UsernamePasswordAuthenticationToken(null, null, null));
    }
}