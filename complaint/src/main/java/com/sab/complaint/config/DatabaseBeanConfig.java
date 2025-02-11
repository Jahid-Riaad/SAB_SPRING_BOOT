package com.sab.complaint.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.sab.complaint.model"})
@EnableJpaRepositories(basePackages = { "com.sab.complaint.repository"})
public class DatabaseBeanConfig {
    // Other database-related configurations if needed
}