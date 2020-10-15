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
import com.devon.treditor.repository.PaperRepository;
import com.devon.treditor.repository.PrimitiveRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("whiteboard")
public class ProjectController {

	@Autowired
	PaperRepository paperRepository;
	
	@Autowired
	PrimitiveRepository primitveRepository;

	@GetMapping("/create_random")
	public Project createRandomDocument() {
		Random random = new Random();
		Project paper = new Project("Paper" + random.nextInt(1000));
		int width = random.nextInt(1000);
		int height = random.nextInt(1000);
		Shape shape1 = new Circle();
		Shape shape2 = new Rectangle();

		primitveRepository.save(shape1);
		paper.addPrimitive(shape1);
		primitveRepository.save(shape2);
		paper.addPrimitive(shape2);
		paperRepository.save(paper);

		return paper;
	}

	@GetMapping("/projects")
	public List<Project> getAllPapers() {
		return paperRepository.findAll();
	}
}