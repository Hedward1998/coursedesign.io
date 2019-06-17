package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Course;
import dao.CourseDao;
import dao.CourseDaoImp;

/**
 * Servlet implementation class InsertCourse
 */
@WebServlet("/InsertCourseServlet")
public class InsertCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String tno = (String)request.getSession().getAttribute("tno");
		CourseDao cou = new CourseDaoImp();
		Course c = null;
		response.setContentType("text/html;charset=UTF-8");
		if (type.equals("InsertCourse")) {
			String cName = request.getParameter("cName");
			String cDescribe = request.getParameter("cDescribe");
			String major = request.getParameter("major");
			int cNumber = Integer.parseInt(request.getParameter("cNumber"));
			if (cou.select(tno, cName.trim(), major.trim())) {
				response.getWriter().println("<script>alert('该课程已被录入过，录入失败！');window.location.href = 'insert_course.jsp';</script>");
			}else {
				c = new Course( 0,tno, cName.trim(), cDescribe, major.trim(), cNumber);
				if (cou.insert(c)) {
					int cno = c.getCno();
					request.getSession().setAttribute("cno", cno);
					request.getSession().setAttribute("userid", tno);
					response.getWriter().println("<script>alert('课程录入成功！');alert('请上传课题文件！');window.location.href = 'course_file_upload.jsp';</script>");
				}else{
					response.getWriter().println("<script>alert('课程录入失败！');window.location.href = 'insert_course.jsp';</script>");
				}
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
