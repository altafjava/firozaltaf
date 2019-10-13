package com.firozaltaf.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.firozaltaf.mc.SourceFile;
import com.firozaltaf.mc.TargetFile;

@Document
public class ConversionOutput {

	@Id
	private String id;
	private int sourceFileId;
	private String key;
	private String status;
	private boolean sandbox;
	private String created_at;
	private String finished_at;
	private SourceFile source_file;
	private List<TargetFile> target_files;
	private String target_format;
	private int credit_cost;
	private Date createdDate;
	private Date updatedDate;
	private String conversionInputUrl;
	private String conversionInputFileName;
	private Date conversionInputCreatedDate;
	private Date conversionInputUpdatedDate;

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isSandbox() {
		return sandbox;
	}

	public void setSandbox(boolean sandbox) {
		this.sandbox = sandbox;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getFinished_at() {
		return finished_at;
	}

	public void setFinished_at(String finished_at) {
		this.finished_at = finished_at;
	}

	public SourceFile getSource_file() {
		return source_file;
	}

	public void setSource_file(SourceFile source_file) {
		this.source_file = source_file;
	}

	public List<TargetFile> getTarget_files() {
		return target_files;
	}

	public void setTarget_files(List<TargetFile> target_files) {
		this.target_files = target_files;
	}

	public String getTarget_format() {
		return target_format;
	}

	public void setTarget_format(String target_format) {
		this.target_format = target_format;
	}

	public int getCredit_cost() {
		return credit_cost;
	}

	public void setCredit_cost(int credit_cost) {
		this.credit_cost = credit_cost;
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

	public String getConversionInputUrl() {
		return conversionInputUrl;
	}

	public void setConversionInputUrl(String conversionInputUrl) {
		this.conversionInputUrl = conversionInputUrl;
	}

	public String getConversionInputFileName() {
		return conversionInputFileName;
	}

	public void setConversionInputFileName(String conversionInputFileName) {
		this.conversionInputFileName = conversionInputFileName;
	}

	public Date getConversionInputCreatedDate() {
		return conversionInputCreatedDate;
	}

	public void setConversionInputCreatedDate(Date conversionInputCreatedDate) {
		this.conversionInputCreatedDate = conversionInputCreatedDate;
	}

	public Date getConversionInputUpdatedDate() {
		return conversionInputUpdatedDate;
	}

	public void setConversionInputUpdatedDate(Date conversionInputUpdatedDate) {
		this.conversionInputUpdatedDate = conversionInputUpdatedDate;
	}

	@Override
	public String toString() {
		return "ConversionOutput [id=" + id + ", key=" + key + ", status=" + status + ", sandbox=" + sandbox + ", created_at=" + created_at + ", finished_at=" + finished_at
				+ ", source_file=" + source_file + ", target_files=" + target_files + ", target_format=" + target_format + ", credit_cost=" + credit_cost + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", conversionInputUrl=" + conversionInputUrl + ", conversionInputFileName=" + conversionInputFileName
				+ ", conversionInputCreatedDate=" + conversionInputCreatedDate + ", conversionInputUpdatedDate=" + conversionInputUpdatedDate + "]";
	}

}
