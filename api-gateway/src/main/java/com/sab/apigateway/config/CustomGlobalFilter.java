//package com.sab.apigateway.config;
//
//import com.sab.security.config.JwtAuthenticationFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Component
//@Order(1) // Ensure correct order of filters if needed
//public class CustomGlobalFilter implements GlobalFilter {
//
//    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    public CustomGlobalFilter(JwtAuthenticationFilter jwtAuthenticationFilter) {
//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//    }
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        // Adapt your filter logic here
//        return Mono.fromRunnable(() -> {
//            HttpServletRequest request = (HttpServletRequest) exchange.getRequest();
//            HttpServletResponse response = (HttpServletResponse) exchange.getResponse();
//            try {
//                jwtAuthenticationFilter.doFilter(request, response, (req, res) -> {
//                    // Continue with the filter chain
//                    chain.filter(exchange);
//                });
//            } catch (Exception e) {
//                // Handle exception
//            }
//        });
//    }
//}