package model;

import java.util.Date;

public class Student {

	private int rollNo;
	private String fname;
	private String lName;
	private String address;
	private Date dob;
	private int contactNo;
	private int semester;
	private String branch;

	
	public Student(int rollNo, String fname, String lName, String address, Date dob, int contactNo, int semester,
			String branch) {
		super();
		this.rollNo = rollNo;
		this.fname = fname;
		this.lName = lName;
		this.address = address;
		this.dob = dob;
		this.contactNo = contactNo;
		this.semester = semester;
		this.branch = branch;
	}





		public int getRollNo() {
		return rollNo;
	}


	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public int getContactNo() {
		return contactNo;
	}


	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}


	public int getSemester() {
		return semester;
	}


	public void setSemester(int semester) {
		this.semester = semester;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	
	
	
	public Student() {}

}
