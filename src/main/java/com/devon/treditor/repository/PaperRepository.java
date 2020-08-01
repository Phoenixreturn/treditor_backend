package com.devon.treditor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devon.treditor.entity.whiteboard.Paper;

public interface PaperRepository extends MongoRepository<Paper, String> {

}
