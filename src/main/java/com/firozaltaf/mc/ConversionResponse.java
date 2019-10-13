package com.firozaltaf.mc;

import java.util.List;

public class ConversionResponse {

	private int id;
	private String key;
	private String status;
	private boolean sandbox;
	private String created_at;
	private String finished_at;
	private SourceFile source_file;
	private List<TargetFile> target_files;
	private String target_format;
	private int credit_cost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "ConversionOutput [id=" + id + ", key=" + key + ", status=" + status + ", sandbox=" + sandbox + ", created_at=" + created_at + ", finished_at=" + finished_at
				+ ", source_file=" + source_file + ", target_files=" + target_files + ", target_format=" + target_format + ", credit_cost=" + credit_cost + "]";
	}

}
