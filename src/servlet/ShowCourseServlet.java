package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Course;
import bean.Student;
import dao.CourseDao;
import dao.CourseDaoImp;
import dao.StudentDao;
import dao.StudentDaoImp;

/**
 * Servlet implementation class showCourseServlet
 */
@WebServlet("/ShowCourseServlet")
public class ShowCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String sno = (String) request.getSession().getAttribute("username");
		StudentDao stu = new StudentDaoImp();
		Student s = stu.select(sno);
		String major = s.getMajor();
		
		CourseDao cou = new CourseDaoImp();
		
		//选课：cno,sno
		//选课信息显示：cname,cDescribe,tname,cNumber,filename; 隐式信息：cno,fpath;
		ArrayList<Course> list = cou.selectALL(major);
		
		request.getSession().setAttribute("list", list);
		request.getRequestDispatcher("/choose_course.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
