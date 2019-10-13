package com.firozaltaf.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.firozaltaf.model.DownloadFileInput;

@Repository
public interface DownloadFileInputRepository extends MongoRepository<DownloadFileInput, String> {

}
