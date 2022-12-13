package com.dh.catalogservice.service;

import java.util.Optional;

public interface IEntityService <T> {

    Optional<T> getById(String id);
    T getByGenre(String genre);
    T upsert(T entity);

}