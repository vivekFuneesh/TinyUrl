package com.vivek.tinyurl.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.vivek.tinyurl.model.SequentialGeneratorModel;

import com.vivek.tinyurl.repository.SequentialGeneratorRepository;

@Service
public class SequentialGenerator {

	@Autowired
	SequentialGeneratorRepository sgr;
	
	@Autowired
	ApplicationContext ac;
	
	public String generate() {
		
		String key=null;
		
		List<SequentialGeneratorModel> list=sgr.findAll();
		
		SequentialGeneratorModel sg;
		
		if(list.size()>0) {
			sg=list.get(0);
			key=getNext(sg.getLastGeneratedUrl());
			sg.setLastGeneratedUrl(key);
			sgr.save(sg);
		}
		else {
			key=getNext();
			sg=ac.getBean(SequentialGeneratorModel.class);
			sg.setLastGeneratedUrl(key);
			sgr.save(sg);
		}
		
		return key;
	}
	
	private String getNext(String old) {
		BigDecimal bd=new BigDecimal(old);
		return bd.add(new BigDecimal(1)).toPlainString();
	}
	
	/**
	 * This method must be called only once 
	 */
	private String getNext() {
		return new BigDecimal(99999).toPlainString();
	}
	
}

