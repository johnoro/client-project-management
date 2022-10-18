package com.johnoro.cpm.repository;

import com.johnoro.cpm.model.Project;

import java.util.List;

public interface ProjectRepository extends BaseRepository<Project> {
    List<Project> findAllByClientId(Long clientId);
}
