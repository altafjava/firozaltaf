package com.firozaltaf.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.firozaltaf.model.ConversionInput;

@Repository
public interface ConversionInputRepository extends MongoRepository<ConversionInput, String> {

}
