package com.dh.serieservice.repository;

import com.dh.serieservice.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SerieRepository extends MongoRepository<Serie, Long> {

    List<Serie> findAllByGenre(String genre);


}
