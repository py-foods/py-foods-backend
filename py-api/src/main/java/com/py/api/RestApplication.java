package com.py.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.py.service.ServiceConfig;

@PropertySource("classpath:database.properties")
@SpringBootApplication(scanBasePackageClasses = { ServiceConfig.class, RestConfig.class })
public class RestApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
}
