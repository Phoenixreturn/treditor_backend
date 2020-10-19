package com.devon.treditor.entity.whiteboard;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.devon.treditor.entity.whiteboard.shapes.Shape;

@Document(collection = "projects")
public class Project {

	@Id
	private String id;

	@NotBlank
	@Size(max = 20)
	private String name;

	@DBRef
	private List<Shape> shapes = new ArrayList<>();

	public void addShape(Shape shape) {
		shapes.add(shape);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}