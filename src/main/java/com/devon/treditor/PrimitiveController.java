package com.devon.treditor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devon.treditor.mongo.whiteboard.Primitive;
import com.devon.treditor.mongo.whiteboard.PrimitiveRepository;

@CrossOrigin
@RestController
public class PrimitiveController {

	@Autowired
	PrimitiveRepository primitiveRepository;

	public PrimitiveController(PrimitiveRepository primitiveRepository) {
		this.primitiveRepository = primitiveRepository;
		primitiveRepository.insert(new Primitive(100, 200));
		primitiveRepository.insert(new Primitive(200, 300));
		primitiveRepository.insert(new Primitive(300, 400));
		primitiveRepository.insert(new Primitive(400, 500));
	}

	@GetMapping("/primitives")
	public List<Primitive> getAllPrimitives() {
		return primitiveRepository.findAll();
	}
}