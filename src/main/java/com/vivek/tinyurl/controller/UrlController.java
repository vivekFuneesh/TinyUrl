package com.vivek.tinyurl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.tinyurl.dao.UrlGenerator;
import com.vivek.tinyurl.model.UrlMapper;

@RestController
public class UrlController{

	@Autowired
	UrlGenerator ug;
	
	
	@RequestMapping(value="/generateUrl", method=RequestMethod.POST)
	public UrlMapper saveOriginalUrl(@Valid UrlMapper url, Errors error) {
		if(error.hasErrors())return null;
		return ug.generateAndSaveFromOriginalUrl(url);
	}

	
	@RequestMapping(value="/findByOriginalUrl", method=RequestMethod.POST)
	public UrlMapper getFromOriginalUrl(String originalUrl) {
		return ug.getFromOriginalUrl(originalUrl);
	
	}

	@RequestMapping(value="/findBySeqUrl", method=RequestMethod.POST)
	public UrlMapper getFromSequentialUrl(String sequentialUrl) {
		return ug.getFromSequentialUrl(sequentialUrl);
	}

	@RequestMapping(value="/findByAutoUrl", method=RequestMethod.POST)
	public UrlMapper getFromAutomaticUrl(String autoUrl) {
		return ug.getFromAutomaticUrl(autoUrl);
	}


	
}
