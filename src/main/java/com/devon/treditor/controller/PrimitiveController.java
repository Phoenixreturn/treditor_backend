package com.devon.treditor.controller;

import java.util.List;

import com.devon.treditor.entity.whiteboard.shapes.Circle;
import com.devon.treditor.entity.whiteboard.shapes.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.devon.treditor.entity.whiteboard.shapes.Shape;
import com.devon.treditor.repository.ShapeRepository;

@CrossOrigin
@Controller
public class PrimitiveController {

	@Autowired
    ShapeRepository primitiveRepository;

	public PrimitiveController(ShapeRepository primitiveRepository) {
		this.primitiveRepository = primitiveRepository;
		primitiveRepository.insert(new Circle());
		primitiveRepository.insert(new Circle());
		primitiveRepository.insert(new Rectangle());
		primitiveRepository.insert(new Rectangle());
	}

	@GetMapping("/primitives")
	public List<Shape> getAllPrimitives() {
		return primitiveRepository.findAll();
	}
}