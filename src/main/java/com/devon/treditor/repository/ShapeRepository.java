package com.devon.treditor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devon.treditor.entity.whiteboard.shapes.Shape;

public interface ShapeRepository extends MongoRepository<Shape, String> {
}

