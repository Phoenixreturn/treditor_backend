package com.devon.treditor.controller;

import java.util.List;
import java.util.Random;

import com.devon.treditor.entity.whiteboard.shapes.Circle;
import com.devon.treditor.entity.whiteboard.shapes.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devon.treditor.entity.whiteboard.Project;
import com.devon.treditor.entity.whiteboard.shapes.Shape;
import com.devon.treditor.repository.ProjectRepository;
import com.devon.treditor.repository.ShapeRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("whiteboard")
public class ProjectController {
	@Autowired
    ProjectRepository projectRepository;

	@GetMapping("/create_random")
	public Project createRandomDocument() {
		Random random = new Random();
		Project project = new Project();
		project.setName("Project" + random.nextInt(1000));
		projectRepository.save(project);

		return project;
	}
}