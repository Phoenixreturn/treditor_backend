package com.devon.treditor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devon.treditor.entity.shapes.Primitive;

public interface PrimitiveRepository extends MongoRepository<Primitive, Long> {
}

