package com.firozaltaf.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.firozaltaf.model.ConversionOutput;

@Repository
public interface ConversionOutputRepository extends MongoRepository<ConversionOutput, String> {

}
