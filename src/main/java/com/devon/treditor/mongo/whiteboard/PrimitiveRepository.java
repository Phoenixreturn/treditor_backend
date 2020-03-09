package com.devon.treditor.mongo.whiteboard;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrimitiveRepository extends MongoRepository<Primitive, Long> {

}
