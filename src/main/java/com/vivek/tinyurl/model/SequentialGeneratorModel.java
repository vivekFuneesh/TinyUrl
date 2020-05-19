package com.vivek.tinyurl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SequentialGeneratorModel {

	@Id
	String _id;
	
	String lastGeneratedUrl;

	public String getLastGeneratedUrl() {
		return lastGeneratedUrl;
	}

	public void setLastGeneratedUrl(String lastGeneratedUrl) {
		this.lastGeneratedUrl = lastGeneratedUrl;
	}
	
	
}
