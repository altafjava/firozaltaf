package com.firozaltaf.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DownloadFileInput {

	@Id
	private String id;
	private int targetFileId;
	private String url;
	private Date createdDate;
	private Date updatedDate;

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
		return "DownloadFileInput [id=" + id + ", targetFileId=" + targetFileId + ", url=" + url + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
