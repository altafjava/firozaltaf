package com.firozaltaf.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test")
	public String test() throws IOException {
//		File file = new ClassPathResource("static/srk.jpg").getFile();
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//		String line = null;
//		StringBuilder stringBuilder = new StringBuilder();
//		while ((line = br.readLine()) != null) {
//			stringBuilder.append(line);
//		}
//		System.out.println("sb=" + stringBuilder);
//		return stringBuilder.toString();
		return "Test Successful";
	}
}
