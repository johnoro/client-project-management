package com.johnoro.cpm.service;

import com.johnoro.cpm.repository.BaseRepository;

import java.util.List;

// TODO: figure out if this annotation works here or should be moved to the implementing classes

abstract class BaseServiceImpl<T> implements BaseService<T> {
    private BaseRepository<T> repository;

    public BaseServiceImpl(BaseRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public T findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
