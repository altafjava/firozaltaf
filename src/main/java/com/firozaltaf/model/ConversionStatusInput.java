package com.firozaltaf.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ConversionStatusInput {

	@Id
	private String id;
	private int sourceFileId;
	private String url;
	private Date createdDate;
	private Date updatedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSourceFileId() {
		return sourceFileId;
	}

	public void setSourceFileId(int sourceFileId) {
		this.sourceFileId = sourceFileId;
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
		return "ConversionStatusInput [id=" + id + ", sourceFileId=" + sourceFileId + ", url=" + url + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
