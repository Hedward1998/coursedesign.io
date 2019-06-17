package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Sc;
import bean.Score;
import dao.ScoreDao;
import dao.ScoreDaoImp;

/**
 * Servlet implementation class SelfGradeServlet
 */
@WebServlet("/SelfGradeServlet")
public class SelfGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelfGradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Sc sc = (Sc)request.getSession().getAttribute("scResult");
		String score = request.getParameter("score");
		String comments = request.getParameter("comments");
		String sno = sc.getSno();
		int fno = sc.getFno();
		int cno = sc.getCno();
		String selfGrade = score + "_" + comments;//使用下滑线做标志
		ScoreDao scoreDao = new ScoreDaoImp();
		Score s = new Score();
		if (scoreDao.selectData(sno)) {
			response.getWriter().println("<script>alert('你已经自评过一次，不允许重复自评！');window.location.href = 'self_grade.jsp';</script>");
		} else {
			s.setCno(cno);
			s.setFno(fno);
			s.setSno(sno);
			s.setSelfGrade(selfGrade);
			if (scoreDao.insert(s)) {
				response.getWriter().println("<script>alert('自评成功！');window.location.href = 'self_grade.jsp';</script>");
			} else {
				response.getWriter().println("<script>alert('自评失败！');window.location.href = 'self_grade.jsp';</script>");
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
