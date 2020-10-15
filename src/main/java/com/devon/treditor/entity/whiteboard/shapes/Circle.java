package com.devon.treditor.entity.whiteboard.shapes;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shapes")
public class Circle extends Shape {
    private float radius;

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
