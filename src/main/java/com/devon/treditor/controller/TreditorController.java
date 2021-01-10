package com.devon.treditor.controller;

import com.devon.treditor.entity.whiteboard.Project;
import com.devon.treditor.payload.ProjectInfo;
import com.devon.treditor.payload.ProjectMap;
import com.devon.treditor.repository.ProjectRepository;
import com.devon.treditor.repository.ShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class TreditorController implements TreditorApi {
    private ProjectRepository projectRepository;
    private ShapeRepository shapeRepository;

    @Autowired
    TreditorController(ProjectRepository projectRepository, ShapeRepository shapeRepository) {
        this.projectRepository = projectRepository;
        this.shapeRepository = shapeRepository;
    }

    @Override
    public ResponseEntity<Project> createProject(String projectName) {
        Project newProject = new Project(projectName);
        projectRepository.save(newProject);

        return ResponseEntity.ok(newProject);
    }

    @Override
    public ResponseEntity<ProjectMap> getProjects() {
        List<Project> projects = projectRepository.findAll();
        ProjectMap values = new ProjectMap();
        projects.forEach(project -> {
            values.put(project.getName(), project.getId());
        });
        return new ResponseEntity<>(values, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Project> getProject(String projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        return new ResponseEntity<>(project.isPresent() ? project.get() : null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Project> updateProject(String projectId, ProjectInfo body) {
        Optional<Project> project = projectRepository.findById(projectId);
        if (project.isPresent()) {
            Project prj = project.get();
            prj.getShapes().clear();
            body.getShapes().forEach(shape -> {
                shapeRepository.save(shape);
                prj.addShape(shape);
            });
            projectRepository.save(prj);
            return new ResponseEntity<>(prj, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}