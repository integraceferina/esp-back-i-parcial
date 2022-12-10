package com.dh.catalogService.repository;

import com.dh.catalogService.models.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog, String> {

    /* ====================== Methods ====================== */
    List<Catalog> findAllByGenre (String genre);
    Optional<Catalog> findByGenre (String genre);

}
