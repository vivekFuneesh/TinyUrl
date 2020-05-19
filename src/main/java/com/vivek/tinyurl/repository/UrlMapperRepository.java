package com.vivek.tinyurl.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.vivek.tinyurl.model.UrlMapper;

public interface UrlMapperRepository extends MongoRepository<UrlMapper, String> {

	@Query("{'recievedUrl' : ?0}")
	UrlMapper getByOriginalUrl(String originalU);
	
	@Query("{'_id' : ?0}")
	UrlMapper urlByautomaticUrl(String automaticId);
	
	@Query("{'newSequentialUrl' : ?0}")
	UrlMapper urlBySequentialUrl(String newSequentialUrl);
	
	

}
