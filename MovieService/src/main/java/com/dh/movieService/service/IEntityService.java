package com.dh.movieService.service;

import java.util.List;

public interface IEntityService<T>{

    /* ================== Methods ================== */
    List<T> getAll();
    T getById(Long id);
    T save(T entity);
    void delete(Long id);

}
