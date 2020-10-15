package com.devon.treditor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devon.treditor.entity.whiteboard.Project;

public interface PaperRepository extends MongoRepository<Project, String> {

}
