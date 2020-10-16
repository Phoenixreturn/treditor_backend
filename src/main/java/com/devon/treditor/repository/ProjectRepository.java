package com.devon.treditor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devon.treditor.entity.whiteboard.Project;

public interface ProjectRepository extends MongoRepository<Project, String> {

}
