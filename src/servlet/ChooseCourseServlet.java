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
 * Servlet implementation class ChooseCourseServlet
 */
@WebServlet("/ChooseCourseServlet")
public class ChooseCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public ChooseCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String sno = (String) request.getSession().getAttribute("username");
		ScDao dao = new ScDaoImp();
		Sc sc = null;
		String choose[] =  request.getParameterValues("radio1");
		if(choose == null){
			response.getWriter().println("<script>alert('没有选择课程！');window.location.href = 'ShowCourseServlet';</script>");
		}else if(choose != null){
			int cno = Integer.parseInt( choose[0]);
			sc = new Sc(cno, sno);
			if (dao.selectData(sno)) {
				Sc s = dao.selectDatas(sno);
				request.getSession().setAttribute("sc", s);
				response.getWriter().println("<script>alert('你已存在选课记录，请先退选！');window.location.href = 'show_choose_course.jsp';</script>");
			} else {
				if (dao.isSelectAll(cno)) {//查询是否课程被选完
					if (dao.insert(sc)) {
						Sc s = dao.selectDatas(sno);
						request.getSession().setAttribute("sc", s);
						response.getWriter().println("<script>alert('选课成功！');window.location.href = 'show_choose_course.jsp';</script>");
					} else {
						response.getWriter().println("<script>alert('选课失败！');window.location.href = 'ShowCourseServlet';</script>");
					}
				} else {
					response.getWriter().println("<script>alert('抱歉，该课程已被选完，请重新选择课程！');window.location.href = 'ShowCourseServlet';</script>");
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
