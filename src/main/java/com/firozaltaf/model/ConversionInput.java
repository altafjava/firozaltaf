package com.firozaltaf.model;

import java.io.File;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ConversionInput {

	@Id
	private String id;
	private String url;
	private String fileName;
	private File sourceFile;
	private String targetFormat;
	private Date createdDate;
	private Date updatedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public File getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	public String getTargetFormat() {
		return targetFormat;
	}

	public void setTargetFormat(String targetFormat) {
		this.targetFormat = targetFormat;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "ConversionInput [id=" + id + ", url=" + url + ", fileName=" + fileName + ", sourceFile=" + sourceFile + ", targetFormat=" + targetFormat + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
