package com.py.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Getter
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Value("${py.picture.domain}")
	private String pictureDomain;

	@Value("${py.picture.bucket}")
	private String picturebucket;

	public String getPictureURL(String name) {
		return pictureDomain + picturebucket + "/" + name;
	}
}
