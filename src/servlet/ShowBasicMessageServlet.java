package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import dao.StudentDaoImp;
import dao.TeacherDao;
import dao.TeacherDaoImp;

/**
 * Servlet implementation class ShowBasicMessageServlet
 */
@WebServlet("/ShowBasicMessageServlet")
public class ShowBasicMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBasicMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String userID = (String) request.getSession().getAttribute("username");
		if (userID.startsWith("s")) {
			StudentDao sDao = new StudentDaoImp();
			Student s = sDao.select(userID);
			if (s != null) {
				request.getSession().setAttribute("student", s);
				request.getRequestDispatcher("basic_message_student.jsp").forward(request, response);
			}
		} else if (userID.startsWith("t")) {
			TeacherDao tDao = new TeacherDaoImp();
			Teacher t = tDao.select(userID);
			if (t != null) {
				request.getSession().setAttribute("teacher", t);
				request.getRequestDispatcher("basic_message_teacher.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
