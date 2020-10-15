package com.devon.treditor.entity.whiteboard;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.devon.treditor.entity.whiteboard.shapes.Shape;

@Document(collection = "documents")
public class Project {

	@Id
	private String id;

	@NotBlank
	@Size(max = 20)
	private String documentName;

	@DBRef
	private List<Shape> primitives = new ArrayList<>();

	public Project() {}

	public Project(String documentName) {
		this.documentName = documentName;
	}

	public void addPrimitive(Shape primitive) {
		primitives.add(primitive);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentName() {
		return documentName;
	}

	public List<Shape> getPrimitives() {
		return primitives;
	}

	public void setPrimitives(List<Shape> primitives) {
		this.primitives = primitives;
	}
}