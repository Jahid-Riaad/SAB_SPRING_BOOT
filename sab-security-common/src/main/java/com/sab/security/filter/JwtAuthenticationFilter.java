package com.sab.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sab.security.exception.JwtTokenExpiredException;
import com.sab.security.util.CustomUserDetails;
import com.sab.security.util.JwtTokenProvider;
import com.sab.security.util.UserDTO;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final RestTemplate restTemplate;

    // Endpoint of auth-service to fetch user details
    private final String userDetailsEndpoint = "http://localhost:8084/user/auth/user/";

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, RestTemplate restTemplate) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.restTemplate = restTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            try {
                username = jwtTokenProvider.extractUsername(jwt);
            } catch (Exception e) {
                ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.getOutputStream().write(new ObjectMapper().writeValueAsString(e.getMessage()).getBytes());
                return;
//                throw new JwtTokenExpiredException(e.getMessage());
            }
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtTokenProvider.isTokenExpired(jwt)) {
                ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.getOutputStream().write(new ObjectMapper().writeValueAsString("JWT token has expired").getBytes());
//                response.getWriter().write("JWT token has expired");
                return;
            }
            if (jwtTokenProvider.validateToken(jwt)) {
                // Call auth-service to get user details
                UserDTO userDTO = restTemplate.getForObject(userDetailsEndpoint + username, UserDTO.class);

                if (userDTO != null) {
                    // Create an Authentication token using user details
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDTO.getUsername(), null, getGrantedAuthorities(userDTO.getAuthorities()));

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    // Set authentication in the security context
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }
        chain.doFilter(request, response);
    }
    // Convert List of authority strings to GrantedAuthority objects
    private List<GrantedAuthority> getGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}