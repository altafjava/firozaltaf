package com.firozaltaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.firozaltaf.service.DwgToJpgConvertorService;

@RestController
public class DwgToJpgConvertorController {

	@Autowired
	private DwgToJpgConvertorService dwgToJpgConvertorService;

	@PostMapping("/convert/dwg-jpg")
	public ResponseEntity<String> convertDwgToJpg(@RequestParam MultipartFile file) {
		return dwgToJpgConvertorService.convertDwgToJpg(file);
	}

	@PostMapping("/converts/dwg-jpg")
	public void convertDwgToJpg(@RequestParam MultipartFile[] files) {

	}
}
