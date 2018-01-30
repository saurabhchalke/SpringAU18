package service;

import dao.StudentDAO;
import model.Student;



public class StudentService {
	
	private static StudentDAO dao;  
	public StudentService() {
		dao=new StudentDAO();
	}

	public Student addStudent(Student student) {
		Student addedStudent=null;
		boolean status=verifyStudentEntry(student);
		if(status==true)
		addedStudent=dao.addStudent(student);
		return addedStudent;
	}
	
	public Student updateStudent(Student student) 
	{
		if(student.getRollNo()<=0)
			return null;
		Student updatedStudent=dao.updateStudent(student);
		if(verifyStudentEntry(updatedStudent))
		return updatedStudent;
		return null;
		
	}
	
	public Student getStudent(int rollNo)
	{
		if(rollNo<1)
			return null;
		Student student=dao.getStudent(rollNo);
		
		return student;
	}
	
	public Student deleteStudent(int rollNo)
	{	if(rollNo<=0)
		return null;
		return dao.deleteStudent(rollNo);
		
	}
	
	private boolean verifyStudentEntry(Student student)
	{
		if(student.getRollNo()<=0)
			return false;
		else if(student.getFname()==null)
			return false;
		else if(student.getDob()==null)
			return false;
		else if(student.getSemester()<=0 && student.getSemester()>8)
			return false;
	switch(student.getBranch().toLowerCase())
	{
		case "cse" : return true;
		case "mech":return true;
		case "civil": return true;
		default : return true;
	}
		
		
	}
	
}
