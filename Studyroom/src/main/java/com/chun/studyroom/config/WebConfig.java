package com.chun.studyroom.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("")
		.allowedMethods("GET","POST","DELETE","PUT") ;
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
