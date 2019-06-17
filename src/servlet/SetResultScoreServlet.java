package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Score;
import dao.ScoreDao;
import dao.ScoreDaoImp;

/**
 * Servlet implementation class SetResultScoreServlet
 */
@WebServlet("/SetResultScoreServlet")
public class SetResultScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetResultScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String uScore = request.getParameter("usualScore");
		String fScore = request.getParameter("finalScore");
		double usualScore = Double.parseDouble(uScore);
		double finalScore = Double.parseDouble(fScore);
		String comments = request.getParameter("comments");
		String sno = (String) request.getSession().getAttribute("sno");
		//处理分数
		ScoreDao sc = new ScoreDaoImp();
		Score s = new Score();
		s.setUsualScore(usualScore);
		s.setFinalScore(finalScore);
		s.setComments(comments);
		if (sc.update(sno, s)) {
			response.getWriter().println("<script>alert('评分成功！');window.location.href = 'ShowStudentSelfGradeServlet';</script>");
		} else {
			response.getWriter().println("<script>alert('评分失败！');window.location.href = 'ShowStudentSelfGradeServlet';</script>");
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
