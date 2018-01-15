package org.accolite.java.EmployeeManagement.Services;

import java.util.GenericArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAcceptableException;

import java.util.*;

import org.accolite.java.EmployeeManagement.Model.*;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

public class EmployeeManagementService {
	
	static Map<Integer, Employee> employeeMap=new HashMap<Integer, Employee>();
	
	public EmployeeManagementService() {
		
		Employee e1= new Employee();
		e1.setEmployeeId(1);
		e1.setEmployeeName("Saurabh Chalke");
		employeeMap.put(e1.getEmployeeId(), e1);
		
		Employee e2= new Employee();
		e2.setEmployeeId(2);
		e2.setEmployeeName("Vignesh B");
		employeeMap.put(e2.getEmployeeId(), e2);
		
		Employee e3= new Employee();
		e3.setEmployeeId(3);
		e3.setEmployeeName("Nishant Kaushik");
		employeeMap.put(e3.getEmployeeId(), e3);
		
		Employee e4= new Employee();
		e4.setEmployeeId(4);
		e4.setEmployeeName("Khazi Nawaz");
		employeeMap.put(e4.getEmployeeId(), e4);
		
	}
	
	public List<Employee> getAllEmployee(){
		List<Employee> values = new GenericArrayList<Employee>(employeeMap.values());
		return values;
	}
	
	public Employee getEmployee(int Id) {
		
		Employee employee = employeeMap.get(Id);
		if (employee != null) {
		    return employee;
		} else {
		    return null;
		}
		
//		Optional<Employee> matchingEmployee= employeeMap.stream().filter(p ->p.getEmployeeId()==Id).findFirst();
//		if(matchingEmployee.isPresent())
//			return matchingEmployee.get();
//		else
//			return null;
	}

	public String insert(String name, Integer id) {
		Employee employeeTemp = new Employee();
		employeeTemp.setEmployeeId(id);
		employeeTemp.setEmployeeName(name);
		
		if (employeeMap.get(employeeTemp.getEmployeeId()) == null) {
			employeeMap.put(employeeTemp.getEmployeeId(),employeeTemp);
			return "Successfully inserted employee with id " + employeeTemp.getEmployeeId();
		} else {
			throw new NotAcceptableException();
		}
	}
	
	public String update(String name, Integer id) {
		Employee employeeTemp = new Employee();
		employeeTemp.setEmployeeId(id);
		employeeTemp.setEmployeeName(name);
		
		if (employeeMap.get(employeeTemp.getEmployeeId()) != null) {
			employeeMap.put(employeeTemp.getEmployeeId(),employeeTemp);
			return "Successfully updated employee with id " + employeeTemp.getEmployeeId();
		} else {
			throw new NotAcceptableException();
		}
	}
	
	public String delete(Integer id) {
		Employee employeeTemp = new Employee();
		employeeTemp.setEmployeeId(id);
		
		if (employeeMap.get(employeeTemp.getEmployeeId()) != null) {
			employeeMap.remove(employeeTemp.getEmployeeId());
			return "Successfully updated employee with id " + employeeTemp.getEmployeeId();
		} else {
			throw new NotAcceptableException();
		}
	}
	
	
	
}
