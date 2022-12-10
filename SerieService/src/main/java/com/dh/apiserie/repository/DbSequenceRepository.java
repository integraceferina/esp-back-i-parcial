package com.dh.apiserie.repository;

import com.dh.apiserie.models.DbSequence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbSequenceRepository extends MongoRepository<DbSequence, String> {
}
