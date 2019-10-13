package com.firozaltaf.model;

import java.util.Arrays;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DownloadFileOutput {

	@Id
	private String id;
	private int targetFileId;
	private String url;
	private String fileType;
	private String fileName;
	private int fileSize;
	private byte[] bytes;
	private Date createdDate;
	private Date updatedDate;
	private Date downloadFileInputCreatedDate;
	private Date downloadFileInputUpdatedDate;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
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

	public Date getDownloadFileInputCreatedDate() {
		return downloadFileInputCreatedDate;
	}

	public void setDownloadFileInputCreatedDate(Date downloadFileInputCreatedDate) {
		this.downloadFileInputCreatedDate = downloadFileInputCreatedDate;
	}

	public Date getDownloadFileInputUpdatedDate() {
		return downloadFileInputUpdatedDate;
	}

	public void setDownloadFileInputUpdatedDate(Date downloadFileInputUpdatedDate) {
		this.downloadFileInputUpdatedDate = downloadFileInputUpdatedDate;
	}

	@Override
	public String toString() {
		return "DownloadFileOutput [id=" + id + ", targetFileId=" + targetFileId + ", url=" + url + ", fileType=" + fileType + ", fileName=" + fileName + ", fileSize=" + fileSize
				+ ", bytes=" + Arrays.toString(bytes) + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", downloadFileInputCreatedDate="
				+ downloadFileInputCreatedDate + ", downloadFileInputUpdatedDate=" + downloadFileInputUpdatedDate + "]";
	}

}
