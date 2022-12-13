package com.dh.serieservice.repository;

import com.dh.serieservice.model.DbSequence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbSequenceRepository extends MongoRepository<DbSequence, String> {
}
