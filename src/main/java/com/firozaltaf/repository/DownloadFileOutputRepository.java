package com.firozaltaf.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.firozaltaf.model.DownloadFileOutput;

@Repository
public interface DownloadFileOutputRepository extends MongoRepository<DownloadFileOutput, String> {

}
