package com.devon.treditor.entity.whiteboard;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.devon.treditor.entity.whiteboard.shapes.Primitive;

@Document(collection = "documents")
public class Paper {

	@Id
	private String id;

	@NotBlank
	@Size(max = 20)
	private String documentName;

	@DBRef
	private List<Primitive> primitives = new ArrayList<>();

	public Paper() {}

	public Paper(String documentName) {
		this.documentName = documentName;
	}

	public void addPrimitive(Primitive primitive) {
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

	public List<Primitive> getPrimitives() {
		return primitives;
	}

	public void setPrimitives(List<Primitive> primitives) {
		this.primitives = primitives;
	}
}