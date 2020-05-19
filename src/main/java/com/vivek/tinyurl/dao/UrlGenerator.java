package com.vivek.tinyurl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.MongoException;
import com.vivek.tinyurl.ClientRequirements;
import com.vivek.tinyurl.model.UrlMapper;
import com.vivek.tinyurl.repository.UrlMapperRepository;

@Service
public class UrlGenerator implements ClientRequirements{

	@Autowired
	UrlMapperRepository umr;

	@Autowired 
	LockObject  lock;
	
	@Autowired
	SequentialGenerator sg;
	
	/**
	 * Assuming every time originalUrl will be pushed only once and
	 * will be unique from this API's caller side.
	 */
	@Override
	public UrlMapper generateAndSaveFromOriginalUrl(UrlMapper um) {
		String seqUrl=null;
		
		if(umr.getByOriginalUrl(um.getRecievedUrl())!=null) {
			throw new MongoException("Duplicate ORIGINAL URL Recieved"); 
		}
		
		synchronized(lock) {
			seqUrl=sg.generate(1);
		}
		um.setNewSequentialUrl(seqUrl);
		return umr.save(um);
	}
	
	@Override
	public UrlMapper getFromOriginalUrl(String originalUrl) {
		
		return umr.getByOriginalUrl(originalUrl);
	}

	@Override
	public UrlMapper getFromSequentialUrl(String sequentialUrl) {

		return umr.urlBySequentialUrl(sequentialUrl);
	}

	@Override
	public UrlMapper getFromAutomaticUrl(String autoUrl) {
		return umr.urlByautomaticUrl(autoUrl);
	}


}
