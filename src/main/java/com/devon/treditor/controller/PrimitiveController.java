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

    ShapeRepository shapeRepository;

	@Autowired
	public PrimitiveController(ShapeRepository shapeRepository) {
		this.shapeRepository = shapeRepository;
	}

	@GetMapping("/primitives")
	public List<Shape> getAllShapes() {
		return shapeRepository.findAll();
	}
}