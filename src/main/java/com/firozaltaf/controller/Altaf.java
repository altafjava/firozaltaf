package com.firozaltaf.controller;

import java.util.Arrays;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Altaf {
	@Id
	private String id;
	private String name;
	private String type;
	private byte[] bytes;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	@Override
	public String toString() {
		return "Altaf [id=" + id + ", name=" + name + ", type=" + type + ", bytes=" + Arrays.toString(bytes) + "]";
	}

}
