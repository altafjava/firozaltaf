package com.firozaltaf.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.firozaltaf.dao.ConversionDAO;
import com.firozaltaf.mc.ConversionResponse;
import com.firozaltaf.mc.ConversionStatusResponse;
import com.firozaltaf.mc.TargetFile;
import com.firozaltaf.model.ConversionInput;
import com.firozaltaf.model.ConversionStatusInput;
import com.firozaltaf.model.DownloadFileInput;
import com.firozaltaf.model.DownloadFileOutput;
import com.firozaltaf.repository.DownloadFileOutputRepository;

@Service
public class DwgToJpgConvertorService {

	private static final Logger LOGGER = LogManager.getLogger(DwgToJpgConvertorService.class);

	private static final String CONVERSION_URL = "https://sandbox.zamzar.com/v1/jobs";
	private static final String DOWNLOAD_FILE_URL = "https://sandbox.zamzar.com/v1/files/{TARGET_FILE_ID}/content";
	private static final String JPG_TARGET_FORMAT = "jpg";
//	private static final String PNG_TARGET_FORMAT = "png";
//	private static final String PDF_TARGET_FORMAT = "pdf";

	@Autowired
	private CloseableHttpClient httpClient;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ConversionDAO conversionDAO;
	@Autowired
	private DownloadFileOutputRepository downloadFileOutputRepository;

	public ResponseEntity<?> convertDwgToJpg(MultipartFile multipartFile) {
		String originaFileName = multipartFile.getOriginalFilename();
		String fileName = originaFileName.replace(".dwg", ".jpg");
		// First check the file is available in DB or not. If it is not available then Hit the Zamzar API. Else goto DB and get the data and return JPG
		DownloadFileOutput downloadFileOutput = downloadFileOutputRepository.findFirstByFileName(fileName);

		if (downloadFileOutput == null) {
			LOGGER.info("\nCONVERSION_URL=" + CONVERSION_URL + "\n");
			String targetFormat = JPG_TARGET_FORMAT;
			ConversionInput conversionInput = conversionDAO.saveConversionInput(multipartFile, CONVERSION_URL, targetFormat);
			HttpEntity requestContent = MultipartEntityBuilder.create().addPart("source_file", new FileBody(conversionInput.getSourceFile()))
					.addPart("target_format", new StringBody(targetFormat, ContentType.TEXT_PLAIN)).build();
			HttpPost request = new HttpPost(CONVERSION_URL);
			request.setEntity(requestContent);
			try {
//				CloseableHttpResponse response = httpClient.execute(request);
//				HttpEntity responseContent = response.getEntity();
//				String result = EntityUtils.toString(responseContent, "UTF-8");
				String result = "{\"id\":8342355,\"key\":\"9e41b975ff0ebf4b10c11576fdbd8cd70529c7d7\",\"status\":\"initialising\",\"sandbox\":true,\"created_at\":\"2019-11-06T16:13:18Z\",\"finished_at\":null,\"source_file\":{\"id\":60115720,\"name\":\"77-4 TEST LEADS.dwg\",\"size\":31000},\"target_files\":[],\"target_format\":\"jpg\",\"credit_cost\":2}";
				LOGGER.info("\nconversion result=\n" + result);
				ConversionResponse conversionResponse = objectMapper.readValue(result, ConversionResponse.class);
				LOGGER.info("\nconversionResponse=\n" + conversionResponse);
				conversionDAO.saveConversionOutput(conversionInput, conversionResponse);
				int count = 0;
				ConversionStatusResponse conversionStatusResponse = checkConversionStatus(conversionResponse.getId(), count);
				while (!(conversionStatusResponse.isSandbox() && conversionStatusResponse.getStatus().equalsIgnoreCase("successful"))) {
					conversionStatusResponse = checkConversionStatus(conversionResponse.getId(), ++count);
				}
				conversionStatusResponse = checkConversionStatus(conversionResponse.getId(), 0);
				List<TargetFile> targetFiles = conversionStatusResponse.getTarget_files();
//				for (TargetFile targetFile : targetFiles) {
//					String path=downloadFileFromZamzar(targetFile, conversionStatusResponse.getTarget_format());
//				}
				String targetFileName = downloadFileFromZamzar(targetFiles.get(0), conversionStatusResponse.getTarget_format());
				Resource resource = new ClassPathResource("static/downloads/" + targetFileName);
				return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error(e);
			}
		} else {
			byte[] b = downloadFileOutput.getBytes();
			String classpath = "src/main/resources/";
			String path = "static/downloads/" + downloadFileOutput.getFileName();
			File f = new File(classpath + path);
			try {
				f.createNewFile();
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(b);
				fos.close();
				Resource resource = new ClassPathResource(path);
				return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>("conversion failed", HttpStatus.BAD_REQUEST);
	}

	private ConversionStatusResponse checkConversionStatus(int id, int count) {
//		id = 7896942;
		String conversionStatusUrl = CONVERSION_URL + "/" + id;
		if (count == 0)
			LOGGER.info("\nCONVERSION_STATUS_URL=" + conversionStatusUrl + "\n");
		ConversionStatusInput conversionStatusInput = conversionDAO.saveConversionStatusInput(id, conversionStatusUrl);
		HttpGet request = new HttpGet(conversionStatusUrl);
		ConversionStatusResponse conversionStatusResponse = new ConversionStatusResponse();
		try (CloseableHttpResponse response = httpClient.execute(request)) {
			HttpEntity responseContent = response.getEntity();
			String result = EntityUtils.toString(responseContent, "UTF-8");
			if (count == 0)
				LOGGER.info("\nconversion status result=\n" + result);
			conversionStatusResponse = objectMapper.readValue(result, ConversionStatusResponse.class);
			if (count == 0) {
				LOGGER.info("\nconversionStatusResponse=\n" + conversionStatusResponse);
				conversionDAO.saveConversionStatusOutput(conversionStatusInput, conversionStatusResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e);
			return conversionStatusResponse;
		}
		return conversionStatusResponse;
	}

	private String downloadFileFromZamzar(TargetFile targetFile, String fileType) {
		String path = "src/main/resources/static/downloads/" + targetFile.getName();
		int targetFileId = targetFile.getId();
		String downloadFileUrl = DOWNLOAD_FILE_URL.replace("{TARGET_FILE_ID}", targetFileId + "");
		LOGGER.info("\nDOWNLOAD_FILE_URL=" + downloadFileUrl);
		DownloadFileInput downloadFileInput = conversionDAO.saveDownloadFileInput(targetFile, downloadFileUrl, fileType);
		HttpGet request = new HttpGet(downloadFileUrl);
		try (CloseableHttpResponse response = httpClient.execute(request)) {
			HttpEntity httpEntity = response.getEntity();
			try (BufferedInputStream bis = new BufferedInputStream(httpEntity.getContent());
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path))) {
				int inByte;
				while ((inByte = bis.read()) != -1) {
					bos.write(inByte);
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
				LOGGER.error(e);
			}
			LOGGER.info("\nFile downloaded=\n" + targetFile);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e);
		}
		FileInputStream fis = null;
		byte[] bytes = {};
		try {
			fis = new FileInputStream(path);
			bytes = new byte[fis.available()];
			fis.read(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		conversionDAO.saveDownloadFileOutput(downloadFileInput, bytes);
		return targetFile.getName();
	}

}
