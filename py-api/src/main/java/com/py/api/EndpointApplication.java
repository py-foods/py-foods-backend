package com.py.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.py.service.ServiceConfiguration;

@PropertySource("classpath:database.properties")
@SpringBootApplication(scanBasePackageClasses = { ServiceConfiguration.class, ApiConfiguration.class })
public class EndpointApplication {
	public static void main(String[] args) {
		SpringApplication.run(EndpointApplication.class, args);
	}

	/*
	 * @Bean public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	 * return args -> {
	 * System.out.println("Let's inspect the beans provided by Spring Boot:");
	 * String[] beanNames = ctx.getBeanDefinitionNames(); Arrays.sort(beanNames);
	 * for (String beanName : beanNames) { System.out.println(beanName); }
	 * 
	 * }; }
	 */
}
