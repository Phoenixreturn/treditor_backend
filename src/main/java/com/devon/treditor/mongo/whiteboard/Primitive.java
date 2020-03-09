package com.devon.treditor.mongo.whiteboard;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "primitives")
public class Primitive {

	public Primitive(int width, int height) {
		this.width = width;
		this.height = height;
		this.name = String.valueOf(width) + ' ' + String.valueOf(height);
	}

	@Id
	private String id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	private int width;
	private int height;
}