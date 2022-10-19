package com.johnoro.cpm.service;

import com.johnoro.cpm.model.Project;
import com.johnoro.cpm.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService extends BaseServiceImpl<Project> {
    @Autowired
    private ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        super(repository);
    }

    public List<Project> findAllByClientId(Long clientId) {
        return repository.findAllByClientId(clientId);
    }
}
