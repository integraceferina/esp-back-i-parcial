package com.dh.movieservice.service;


import java.util.List;

public interface IEntityService<T>{

    List<T> getAll();
    T getById(Long id);
    T save(T entity);
    void delete(Long id);

}