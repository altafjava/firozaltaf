package com.firozaltaf.util;

import java.io.File;
import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

public class MultipartToFileConvertor {

	private MultipartToFileConvertor() {
	}

	public static File convert(MultipartFile multipartFile) {
		File file = new File(multipartFile.getOriginalFilename());
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(multipartFile.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}
}
