package com.sab.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * File: BeanConfig
 * Author: Koushik Chandra Sarker
 * Date: 9/18/24 (DD/MM/YYYY)
 * Description: .
 * History:
 * - 9/18/24: Koushik Chandra Sarker - Initial version
 * - [Date]: [Author's Name] - [Modification description]
 */
@Configuration
public class BeanConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
