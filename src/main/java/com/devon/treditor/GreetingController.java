package com.devon.treditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devon.treditor.mongo.Student;
import com.devon.treditor.mongo.StudentRepository;

@RestController
public class GreetingController {

	@Autowired
	private StudentRepository repository;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "1") String name) {
		repository.insert(new Student("john", 15));
		return "Greeting page!!!";
	}

	@RequestMapping("/search")
	public Student handle(@RequestParam(value = "name", defaultValue = "1") String name) {
		return repository.findAll().get(0);
	}
}
