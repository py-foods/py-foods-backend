package com.py.service;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.py.entity")
@EnableJpaRepositories(basePackages = "com.py.repository")
public class ServiceConfig {

}
