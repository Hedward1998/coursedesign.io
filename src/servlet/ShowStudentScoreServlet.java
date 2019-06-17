package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Score;
import dao.ScoreDao;
import dao.ScoreDaoImp;

/**
 * Servlet implementation class ShowStudentScore
 */
@WebServlet("/ShowStudentScoreServlet")
public class ShowStudentScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudentScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String tno = (String) request.getSession().getAttribute("username");
		ScoreDao sc = new ScoreDaoImp();
		//查询 sno,sname,dept,major,cname,selfgrade,signScore,comments,usualScore,finalScore,score
		ArrayList<Score> list_StuScore = sc.selectStudentScore(tno);
		if (list_StuScore != null) {
			request.getSession().setAttribute("list_stuScore", list_StuScore);
			request.getRequestDispatcher("show_student_score.jsp").forward(request, response);
		} else {
			response.getWriter().println("<script>window.location.href = 'ShowStudentScoreServlet';</script>");
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
