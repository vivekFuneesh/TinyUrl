package com.vivek.tinyurl.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vivek.tinyurl.model.SequentialGeneratorModel;

public interface SequentialGeneratorRepository extends MongoRepository<SequentialGeneratorModel, String> {

	
	
}
