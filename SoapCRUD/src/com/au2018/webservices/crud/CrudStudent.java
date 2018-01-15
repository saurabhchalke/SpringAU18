package com.au2018.webservices.crud;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CrudStudent {

	@WebMethod
	public void addStudent(Integer key, String value);
	
	@WebMethod
	public String displayStudent(Integer key);
	
	@WebMethod
	public void updateStudent(Integer key, String value);
	
	@WebMethod
	public void deleteStudent(Integer key);
	
}
