package com.firozaltaf.dao;

import java.io.File;
import java.util.Date;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import com.firozaltaf.mc.ConversionResponse;
import com.firozaltaf.mc.ConversionStatusResponse;
import com.firozaltaf.model.ConversionInput;
import com.firozaltaf.model.ConversionOutput;
import com.firozaltaf.model.ConversionStatusInput;
import com.firozaltaf.model.ConversionStatusOutput;
import com.firozaltaf.model.DownloadFileInput;
import com.firozaltaf.model.DownloadFileOutput;
import com.firozaltaf.repository.ConversionInputRepository;
import com.firozaltaf.repository.ConversionOutputRepository;
import com.firozaltaf.repository.ConversionStatusInputRepository;
import com.firozaltaf.repository.ConversionStatusOutputRepository;
import com.firozaltaf.repository.DownloadFileInputRepository;
import com.firozaltaf.repository.DownloadFileOutputRepository;
import com.firozaltaf.util.MultipartToFileConvertor;

@Repository
public class ConversionDAO {

	@Autowired
	private ConversionInputRepository conversionInputRepository;
	@Autowired
	private ConversionOutputRepository conversionOutputRepository;
	@Autowired
	private ConversionStatusInputRepository conversionStatusInputRepository;
	@Autowired
	private ConversionStatusOutputRepository conversionStatusOutputRepository;
	@Autowired
	private DownloadFileInputRepository downloadFileInputRepository;
	@Autowired
	private DownloadFileOutputRepository downloadFileOutputRepository;

	public ConversionInput saveConversionInput(MultipartFile multipartFile, String url, String targetFormat) {
		File file = MultipartToFileConvertor.convert(multipartFile);
		ConversionInput conversionInput = new ConversionInput();
		conversionInput.setUrl(url);
		conversionInput.setFileName(multipartFile.getOriginalFilename());
		conversionInput.setSourceFile(file);
		conversionInput.setTargetFormat(targetFormat);
		Date date = new Date();
		conversionInput.setCreatedDate(date);
		conversionInput.setUpdatedDate(date);
		return conversionInputRepository.save(conversionInput);
	}

	public void saveConversionOutput(ConversionInput conversionInput, ConversionResponse conversionResponse) {
		ConversionOutput conversionOutput = new ConversionOutput();
		BeanUtils.copyProperties(conversionResponse, conversionOutput);
		conversionOutput.setConversionInputUrl(conversionInput.getUrl());
		conversionOutput.setSourceFileId(conversionResponse.getId());
		conversionOutput.setConversionInputFileName(conversionInput.getFileName());
		conversionOutput.setConversionInputCreatedDate(conversionInput.getCreatedDate());
		conversionOutput.setConversionInputUpdatedDate(conversionInput.getUpdatedDate());
		Date date = new Date();
		conversionOutput.setCreatedDate(date);
		conversionOutput.setUpdatedDate(date);
		conversionOutputRepository.save(conversionOutput);
	}

	public ConversionStatusInput saveConversionStatusInput(int sourceFileId, String conversionStatusUrl) {
		ConversionStatusInput conversionStatusInput = new ConversionStatusInput();
		conversionStatusInput.setSourceFileId(sourceFileId);
		conversionStatusInput.setUrl(conversionStatusUrl);
		Date date = new Date();
		conversionStatusInput.setCreatedDate(date);
		conversionStatusInput.setUpdatedDate(date);
		return conversionStatusInputRepository.save(conversionStatusInput);
	}

	public void saveConversionStatusOutput(ConversionStatusInput conversionStatusInput, ConversionStatusResponse conversionStatusResponse) {
		ConversionStatusOutput conversionStatusOutput = new ConversionStatusOutput();
		BeanUtils.copyProperties(conversionStatusResponse, conversionStatusOutput);
		conversionStatusInput.setUrl(conversionStatusInput.getUrl());
		conversionStatusOutput.setConversionStatusInputCreatedDate(conversionStatusInput.getCreatedDate());
		conversionStatusOutput.setConversionStatusInputUpdatedDate(conversionStatusInput.getUpdatedDate());
		Date date = new Date();
		conversionStatusOutput.setCreatedDate(date);
		conversionStatusOutput.setUpdatedDate(date);
		conversionStatusOutputRepository.save(conversionStatusOutput);
	}

	public DownloadFileInput saveDownloadFileInput(int targetFileId, String downloadFileUrl) {
		DownloadFileInput downloadFileInput = new DownloadFileInput();
		downloadFileInput.setTargetFileId(targetFileId);
		downloadFileInput.setUrl(downloadFileUrl);
		Date date = new Date();
		downloadFileInput.setCreatedDate(date);
		downloadFileInput.setUpdatedDate(date);
		return downloadFileInputRepository.save(downloadFileInput);
	}

	public void saveDownloadFileOutput(DownloadFileInput downloadFileInput, byte[] bytes) {
		DownloadFileOutput downloadFileOutput = new DownloadFileOutput();
		BeanUtils.copyProperties(downloadFileInput, downloadFileOutput, "id");
		downloadFileOutput.setBytes(bytes);
		Date date = new Date();
		downloadFileOutput.setCreatedDate(date);
		downloadFileOutput.setUpdatedDate(date);
		downloadFileOutput.setDownloadFileInputCreatedDate(downloadFileInput.getCreatedDate());
		downloadFileOutput.setDownloadFileUpdatedDate(downloadFileInput.getUpdatedDate());
		downloadFileOutputRepository.save(downloadFileOutput);
	}

}
