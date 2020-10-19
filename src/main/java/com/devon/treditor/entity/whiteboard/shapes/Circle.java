package com.devon.treditor.entity.whiteboard.shapes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shapes")
@Getter
@Setter
public class Circle extends Shape {
    private float radius;
}
