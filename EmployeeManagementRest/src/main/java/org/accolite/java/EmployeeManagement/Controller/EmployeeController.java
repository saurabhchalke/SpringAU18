package com.accolite.java.EmployeeForum.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.accolite.java.EmployeeForum.Model.Employee;
import com.accolite.java.EmployeeForum.Services.EmployeeServices;

import java.util.List;

@Path("employee")
public class EmployeeController {
	
	static EmployeeServices serviceObject = new EmployeeServices();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployeeDetails() {
		return serviceObject.getAllEmployee();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(int id) {
		return serviceObject.getEmployee(id);
	}
	
}
