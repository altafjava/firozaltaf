package com.firozaltaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class GenericConfig {

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
}
