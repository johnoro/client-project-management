package com.johnoro.cpm.service;

import java.util.List;

interface BaseService<T> {
    T save(T entity);
    T update(T entity);
    void deleteById(Long id);
    T findById(Long id);
    List<T> findAll();
}