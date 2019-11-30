package com.firozaltaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FirozAltafApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FirozAltafApp.class, args);
		System.out.println("i am from main class");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
		return springApplicationBuilder.sources(FirozAltafApp.class);
	}

}
