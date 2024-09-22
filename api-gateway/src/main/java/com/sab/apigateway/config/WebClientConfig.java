package com.sab.apigateway.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * File: WebClientConfig
 * Author: Koushik Chandra Sarker
 * Date: 9/22/24 (DD/MM/YYYY)
 * Description: .
 * History:
 * - 9/22/24: Koushik Chandra Sarker - Initial version
 * - [Date]: [Author's Name] - [Modification description]
 */
@Configuration
public class WebClientConfig {
    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

}
