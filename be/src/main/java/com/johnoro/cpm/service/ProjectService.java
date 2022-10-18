package com.johnoro.cpm.service;

import com.johnoro.cpm.model.Project;
import com.johnoro.cpm.repository.ProjectRepository;

public class ProjectService extends BaseServiceImpl<Project> {
    public ProjectService(ProjectRepository repository) {
        super(repository);
    }
}
