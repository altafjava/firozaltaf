package com.firozaltaf.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.firozaltaf.controller.Altaf;

@Repository
public interface AltafRepo extends MongoRepository<Altaf, String> {

}
