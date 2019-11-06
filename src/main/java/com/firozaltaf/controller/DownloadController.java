package com.firozaltaf.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.firozaltaf.model.DownloadFileOutput;
import com.firozaltaf.repository.AltafRepo;
import com.firozaltaf.repository.DownloadFileOutputRepository;
import com.firozaltaf.util.MultipartToFileConvertor;

@RestController
public class DownloadController {

	@Autowired
	private DownloadFileOutputRepository downloadFileOutputRepository;
	@Autowired
	private AltafRepo altafRepo;

	@GetMapping("/download")
	public ResponseEntity<Resource> download() throws IOException, SQLException {
		List<DownloadFileOutput> downloadFileOutputList = downloadFileOutputRepository.findAll();
		DownloadFileOutput downloadFileOutput = downloadFileOutputList.get(0);
		byte[] b = downloadFileOutput.getBytes();
		String classpath = "src/main/resources/";
		String path = "static/downloads/" + downloadFileOutput.getFileName();
		File f = new File(classpath + path);
		f.createNewFile();
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(b);
		fos.close();
		Resource resource = new ClassPathResource(path);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
	}

	@GetMapping("/jpg")
	public ResponseEntity<Resource> jpg(@RequestParam MultipartFile multipartFile) throws IOException, SQLException {
		File file = MultipartToFileConvertor.convert(multipartFile);
		byte[] bytes = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytes);
		fis.close();
		Altaf altaf = new Altaf();
		altaf.setBytes(bytes);
		altaf.setName("myname");
		altaf.setType("jpg");
		Altaf alt = altafRepo.save(altaf);
		String path = "static/downloads/" + file.getName();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Resource resource = new ClassPathResource(path);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
	}

	@GetMapping("/pdf")
	public ResponseEntity<Resource> pdf(@RequestParam MultipartFile multipartFile) throws IOException, SQLException {
		File file = MultipartToFileConvertor.convert(multipartFile);
		System.err.println("file.exists()=" + file.exists());
		byte[] bytes = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytes);
		fis.close();
		Altaf altaf = new Altaf();
		altaf.setBytes(bytes);
		altaf.setName("myname");
		altaf.setType("pdf");
		String path = "static/downloads/" + file.getName();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Resource resource = new ClassPathResource(path);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(resource);
	}
}
