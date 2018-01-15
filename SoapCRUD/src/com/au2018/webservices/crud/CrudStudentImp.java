package com.au2018.webservices.crud;

import java.util.HashMap;

import javax.jws.WebService;

@WebService(endpointInterface="com.au2018.webservices.crud.CrudStudent")
public class CrudStudentImp implements CrudStudent {
	
	HashMap<Integer, String> hm = new HashMap<Integer, String>();
	
	@Override
	public void addStudent(Integer key, String value) {
		hm.put(key, value);
	}
	
	@Override
	public String displayStudent(Integer key) {
		if (hm.containsKey(key)) {
			return hm.get(key).toString();
	    } 
		else {
	       return "Element not found";
	    }
	}
	
	@Override
	public void updateStudent(Integer key, String value) {
		hm.put(key, value);
	}
	
	@Override
	public void deleteStudent(Integer key) {
		hm.remove(key);
	}
	
}
