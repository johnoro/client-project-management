package com.johnoro.cpm.service;

import java.util.List;

public interface BaseService<T> {
    T save(T entity);
    T update(T entity);
    void delete(Long id);
    T findById(Long id);
    List<T> findAll();
}