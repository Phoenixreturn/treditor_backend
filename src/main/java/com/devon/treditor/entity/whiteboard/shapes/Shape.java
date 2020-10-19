package com.devon.treditor.entity.whiteboard.shapes;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "type")
@JsonSubTypes({
		@Type(value = Circle.class, name = "vCircle"),
		@Type(value = Rectangle.class, name = "vRect")
})
@Document(collection = "shapes")
@Getter
@Setter
abstract public class Shape {
	@Id
	private String id;
	@NotBlank
	private String name;
	private int rotation;
	private String fill;
	private boolean draggable;
	private float scaleX;
	private float scaleY;
	private float x;
	private float y;
}