package com.firozaltaf.mc;

public class SourceFile {

	private int id;
	private String name;
	private int size;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "SourceFile [id=" + id + ", name=" + name + ", size=" + size + "]";
	}

}
