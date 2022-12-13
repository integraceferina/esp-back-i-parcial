package com.dh.serieservice.service;

import java.util.List;

public interface IEntityService <T> {

    List<T> getAll();
    T getById(Long id);
    T upsert(T entity);
    void delete(Long id);

}