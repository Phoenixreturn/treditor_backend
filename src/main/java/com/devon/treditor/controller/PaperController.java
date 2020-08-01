package com.devon.treditor.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devon.treditor.entity.whiteboard.Paper;
import com.devon.treditor.entity.whiteboard.shapes.Primitive;
import com.devon.treditor.repository.PaperRepository;
import com.devon.treditor.repository.PrimitiveRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/paper")
public class PaperController {

	@Autowired
	PaperRepository paperRepository;
	
	@Autowired
	PrimitiveRepository primitveRepository;

	@GetMapping("/create_random")
	public Paper createRandomDocument() {
		Random random = new Random();
		Paper paper = new Paper("Paper" + random.nextInt(1000));
		Primitive primitve = new Primitive(random.nextInt(1000), random.nextInt(1000));
		primitveRepository.save(primitve);
		paper.addPrimitive(primitve);
		paperRepository.save(paper);

		return paper;
	}

	@GetMapping("/all")
	public List<Paper> getAllPapers() {
		return paperRepository.findAll();
	}

}
