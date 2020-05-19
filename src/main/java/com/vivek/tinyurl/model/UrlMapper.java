package com.vivek.tinyurl.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UrlMapper {

	/**
	 * this is new url to be given;
	 */
	
	@Id
	String _id;
	
	@NotBlank
	String recievedUrl;

	String newSequentialUrl;
	
	public String get_id() {
		return _id;
	}

	public String getRecievedUrl() {
		return recievedUrl;
	}

	public void setRecievedUrl(String recievedUrl) {
		this.recievedUrl = recievedUrl;
	}

	public String getNewSequentialUrl() {
		return newSequentialUrl;
	}

	public void setNewSequentialUrl(String newSequentialUrl) {
		this.newSequentialUrl = newSequentialUrl;
	}

	
	
}
