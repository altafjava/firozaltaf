package com.firozaltaf.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DownloadFileInput {

	@Id
	private String id;
	private int targetFileId;
	private String fileName;
	private String fileType;
	private int fileSize;
	private String url;
	private Date createdDate;
	private Date updatedDate;

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTargetFileId() {
		return targetFileId;
	}

	public void setTargetFileId(int targetFileId) {
		this.targetFileId = targetFileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		return "DownloadFileInput [id=" + id + ", targetFileId=" + targetFileId + ", fileName=" + fileName + ", fileType=" + fileType + ", fileSize=" + fileSize + ", url=" + url
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
