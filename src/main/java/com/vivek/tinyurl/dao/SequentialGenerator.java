package com.vivek.tinyurl.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	private List<Character> list;
	
	
	private List<Character> populateList() {
		ArrayList<Character> arr=new ArrayList<Character>();
		
		int i=33;
		while(i<=126) {
			if(i!=34 && i!=92)//skipping " character for mongodb
				arr.add(Character.valueOf((char)i));
			i++;
		}
		return arr;
	}
	
	/**
	 * If parameter value is 1, means characterized(including numbers) url will be served
	 * else Number_Only url will be served
	 */
	public String generate(int whichGenerator) {
		
		String key=null;
		
		List<SequentialGeneratorModel> list=sgr.findAll();
		
		SequentialGeneratorModel sg;
		
		if(list.size()>0) {
			sg=list.get(0);
			
			if(whichGenerator==1)
				key=getNextStringOnly(sg.getLastGeneratedUrl());
			else key=getNext(sg.getLastGeneratedUrl());
			
			sg.setLastGeneratedUrl(key);
			sgr.save(sg);
		}
		else {
			
			if(whichGenerator==1)
				key=getNextStringOnly();
			else key=getNext();

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
	
	/**
	 * return 7 digit string, capable of making more than 5000 billion unique strings.
	 */
	private String getNextStringOnly() {
		return "!!!!!!}";
	}
	
	private String getNextStringOnly(String old) {
		 if(list==null)list=populateList();
		 char[] ch=old.toCharArray();
		 char[] result=new char[7];
		 
		 int j=6;
		 while(j>=0) {
			 if(ch[j]==list.get(list.size()-1)) {
				 result[j]=list.get(0);
			 }
			 else {
				 result[j]=list.get(list.indexOf(ch[j])+1);
				 j--;
				 break;
			 }
			 j--;
		 }
		 while(j>=0) {
			 result[j]=ch[j];
			 j--;
		 }
		 return String.valueOf(result);
		 
	}
	
}

