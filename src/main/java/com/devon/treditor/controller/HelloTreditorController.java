package com.devon.treditor.controller;

import com.devon.treditor.entity.whiteboard.Project;
import com.devon.treditor.payload.ProjectInfo;
import com.devon.treditor.repository.ProjectRepository;
import com.devon.treditor.repository.ShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HelloTreditorController implements TreditorApi {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ShapeRepository shapeRepository;

    @Override
    public ResponseEntity<String> makeHello() {
        return new ResponseEntity<>("hello treditor", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Project> saveProject(ProjectInfo body) {
        List<Project> projects = projectRepository.findAll();
        Project modifiedProject = projects.get(0);
        body.getShapes().forEach(shape -> {
            shapeRepository.save(shape);
            modifiedProject.addPrimitive(shape);
        });
        projectRepository.save(modifiedProject);

        return new ResponseEntity<>(modifiedProject, HttpStatus.OK);
    }
}
