package com.firozaltaf.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.firozaltaf.model.ConversionStatusOutput;

@Repository
public interface ConversionStatusOutputRepository extends MongoRepository<ConversionStatusOutput, String> {

}
