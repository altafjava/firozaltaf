package com.firozaltaf.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.firozaltaf.model.ConversionStatusInput;

@Repository
public interface ConversionStatusInputRepository extends MongoRepository<ConversionStatusInput, String> {

}
