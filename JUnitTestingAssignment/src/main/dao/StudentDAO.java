package dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.Student;

public class StudentDAO {

	private  Map<Integer,Student> studentList;
	static {
		
	}
	@SuppressWarnings("deprecation")
	public StudentDAO() {
		// TODO Auto-generated constructor stub
		studentList=new HashMap<Integer,Student>();
		studentList.put(1,new Student(1, "Saurabh", "Chalke", "UVCE", new Date(1996, 03, 8), 12345, 33, "cse"));
		studentList.put(2,new Student(0, "Vignesh", "B", "UVCE", new Date(1994, 8, 15), 12345, 3, "cse"));
		studentList.put(3,new Student(7, "Deepak", "Sharma", "ISBM", new Date(1994, 10, 12), 3780, 45, "cse"));
		studentList.put(4,new Student(4, "Pramod", "Dubey", "Ellahabad", new Date(1994, 4, 11), 12325, 7, "civil"));
		studentList.put(5,new Student(5, "Aunty", "Bik", "Gormint", new Date(1994, 3, 26), 45321, 8, "cse"));
	}

	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		if(studentList.get(student.getRollNo())!=null)
		return null;
		studentList.put(student.getRollNo(), student);
		return studentList.get(student.getRollNo());
	}

	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		if(studentList.get(student.getRollNo())==null)
			return null;
		studentList.put(student.getRollNo(), student);	
		
		return studentList.get(student.getRollNo());

	}

	public Student getStudent(int rollNo) {
		// TODO Auto-generated method stub
		if(studentList.get(rollNo)==null)
			return null;
			
		
		return studentList.get(rollNo);
	}

	

	public Student deleteStudent(int rollNo) {
		// TODO Auto-generated method stub
		if(studentList.get(rollNo)==null)
			return null;
		Student stud=studentList.remove(rollNo);
		return stud;
	}

}
