package org.accolite.java.EmployeeManagement.Model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Employee")
public class Employee {
	private int EmployeeId;
	
	private String EmployeeName;
	
	private Date DOB;
	
	private float Salary;


	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public float getSalary() {
		return Salary;
	}

	public void setSalary(float salary) {
		Salary = salary;
	}
	
	
}
