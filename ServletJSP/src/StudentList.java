

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentList
 */
@WebServlet("/StudentList")
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Student> studentList = new ArrayList<Student>();
		
		studentList.add(new Student("1", "Saurabh", new Date(), "Banking"));
		studentList.add(new Student("2", "Vignesh", new Date(), "EComm"));
		studentList.add(new Student("3", "Nishant", new Date(), "Healthcare"));
		studentList.add(new Student("4", "Nawaz", new Date(), "Telecom"));
		studentList.add(new Student("5", "Ragul", new Date(), "Banking"));
		studentList.add(new Student("6", "Anand", new Date(), "EComm"));
		
		request.setAttribute("slist", studentList);
		RequestDispatcher rd= request.getRequestDispatcher("studentList.jsp");
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
