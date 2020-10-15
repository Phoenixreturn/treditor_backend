package com.devon.treditor.entity.whiteboard.shapes;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shapes")
public class Rectangle extends NonCircle {
}
