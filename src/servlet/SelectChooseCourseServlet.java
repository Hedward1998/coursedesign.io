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
 * Servlet implementation class SelectChooseCourseServlet
 */
@WebServlet("/SelectChooseCourseServlet")
public class SelectChooseCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectChooseCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String tno = (String) request.getSession().getAttribute("username");
		//学生选课情况1: select sno,sname,dept,major,grade,cname  where tno = //查询选此老师课
		//			 2：select sno,sname,dept,major,grade where sno not in(select tb_sc)//查询未选课
		//课程选择情况1：select  cname,cdescribe,major,number where tno = 
		StudentDao s = new StudentDaoImp();
		CourseDao c = new CourseDaoImp();
		ArrayList<Student> list_stu1 = s.selectByName(tno);//通过tno查询选了该老师课程的同学
		ArrayList<Student> list_stu2 = s.selectALL();//查询还未选课的同学
		ArrayList<Course> list_c = c.selectData(tno);//查询该老师的课题选题情况

		request.getSession().setAttribute("list_stu1", list_stu1);
		request.getSession().setAttribute("list_stu2", list_stu2);
		request.getSession().setAttribute("list_c", list_c);
		request.getRequestDispatcher("/select_choose_course.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
