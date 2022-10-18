package com.johnoro.cpm.controller;

import com.johnoro.cpm.model.Project;
import com.johnoro.cpm.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService service;

    @GetMapping
    public List<Project> findAll() {
        return service.findAll();
    }

    @GetMapping("/client/{clientId}")
    public List<Project> findAllByClientId(@PathVariable Long clientId) {
        return service.findAllByClientId(clientId);
    }

    @GetMapping("/{id}")
    public Project findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Project save(@RequestBody Project project) {
        return service.save(project);
    }

    @PutMapping
    public Project update(@RequestBody Project project) {
        return service.update(project);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
