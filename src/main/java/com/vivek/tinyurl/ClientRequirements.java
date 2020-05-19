package com.vivek.tinyurl;

import com.vivek.tinyurl.model.UrlMapper;

public interface ClientRequirements {

	public UrlMapper getFromOriginalUrl(String originalUrl);
	
	public UrlMapper getFromSequentialUrl(String sequentialUrl);
	
	public UrlMapper getFromAutomaticUrl(String autoUrl);

	/**
	 * Assuming every time originalUrl will be pushed only once and
	 * will be unique from this API's caller side.
	 */
	public UrlMapper generateAndSaveFromOriginalUrl(UrlMapper um);
	
}

