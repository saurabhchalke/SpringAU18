import java.util.Date;

public class Student {

	private String studentId;
	private String studentName;
	private Date studentDate;
	private String studentDept;
	
	public Student(String studentId, String studentName, Date studentDate, String studentDept) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDate = studentDate;
		this.studentDept = studentDept;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStdentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getStudentDate() {
		return studentDate;
	}

	public void setStudentDate(Date studentDate) {
		this.studentDate = studentDate;
	}

	public String getStudentDept() {
		return studentDept;
	}

	public void setStudentDept(String studentDept) {
		this.studentDept = studentDept;
	}
	
	
	
}
