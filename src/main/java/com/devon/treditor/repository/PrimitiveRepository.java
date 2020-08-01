package com.devon.treditor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devon.treditor.entity.whiteboard.shapes.Primitive;

public interface PrimitiveRepository extends MongoRepository<Primitive, String> {
}

