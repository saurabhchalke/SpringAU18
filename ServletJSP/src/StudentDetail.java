

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDetail
 */
@WebServlet("/StudentDetail")
public class StudentDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentId = request.getParameter("id");
		
		List<Student> studentList = new ArrayList<Student>();
		
		studentList.add(new Student("1", "Saurabh", new Date(), "Banking"));
		studentList.add(new Student("2", "Vignesh", new Date(), "EComm"));
		studentList.add(new Student("3", "Nishant", new Date(), "Healthcare"));
		studentList.add(new Student("4", "Nawaz", new Date(), "Telecom"));
		studentList.add(new Student("5", "Ragul", new Date(), "Banking"));
		studentList.add(new Student("6", "Anand", new Date(), "EComm"));
		
		Iterator<Student> it = studentList.iterator();
		
		while(it.hasNext()) {
			Student temp = it.next();
			if((temp).getStudentId().equals(studentId)) {
				List<Student> iList = new ArrayList<Student>();
				iList.add(temp);
				request.setAttribute("ilist", iList);
				break;
			}
		}
		//request.setAttribute("ilist", studentList);
		RequestDispatcher rd= request.getRequestDispatcher("searchList.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
