package com.au2018.webservices.crud;

import javax.xml.ws.Endpoint;

public class CrudStudentPublisher {
	 public static void main(String[] args) {
	  Endpoint.publish("http://localhost:8020/",new CrudStudentImp());
	 }

}

