package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Sc;
import dao.ScDao;
import dao.ScDaoImp;

/**
 * Servlet implementation class StudentSeeScServlet
 */
@WebServlet("/CancelCourseServlet")
public class CancelCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String sno = (String) request.getSession().getAttribute("username");
		String type = null;
		type = request.getParameter("type");
		ScDao dao = new ScDaoImp();
		Sc s = dao.selectDatas(sno);
		if (type == null) {
			if (s != null) {
				request.getSession().setAttribute("sc", s);
				request.getRequestDispatcher("show_choose_course.jsp").forward(request, response);
			}else{
				response.getWriter().println("<script>alert('你还没有选课，请先选择课程！');window.location.href = 'ShowCourseServlet';</script>");
			}
		}else if (type.equals("cancelCourse")) {
			response.setCharacterEncoding("UTF-8");
			if (dao.delect(sno, s.getCno())) {
				response.getWriter().println("<script>alert('退选成功！');window.location.href = 'ShowCourseServlet';</script>");
			} else {
				request.getSession().setAttribute("sc", s);
				response.getWriter().println("<script>alert('退选失败！');window.location.href = 'show_choose_course.jsp';</script>");
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
