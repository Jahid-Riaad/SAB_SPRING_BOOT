package com.sab.apigateway.config;

import com.sab.security.filter.JwtAuthenticationFilter;
import com.sab.security.config.SecurityConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.sab.security",
        excludeFilters =
        @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                value = {SecurityConfig.class, JwtAuthenticationFilter.class}
        )
)
public class SecurityBeanConfig {

}
