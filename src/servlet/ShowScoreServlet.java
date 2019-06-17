package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Score;
import dao.ScDao;
import dao.ScDaoImp;
import dao.ScoreDao;
import dao.ScoreDaoImp;

/**
 * Servlet implementation class ShowScoreServlet
 */
@WebServlet("/ShowScoreServlet")
public class ShowScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String sno = (String) request.getSession().getAttribute("username");
		ScoreDao score = new ScoreDaoImp();
		ScDao sc = new ScDaoImp();
		if (sc.selectData(sno)) {
			int flag = score.selectDatas(sno);
			if (flag == 2) {
				Score s = score.selectScore(sno);
				if (s != null) {
					request.getSession().setAttribute("score", s);
					request.getRequestDispatcher("show_score.jsp").forward(request, response);
				} else {
					response.getWriter().println("<script>alert('老师还未评分！');window.location.href = 'first_student.jsp';</script>");
				}
			} else {
				if (flag == 1) {
					response.getWriter().println("<script>alert('你还未自评成绩！');window.location.href = 'CheckResultServlet';</script>");
				} else if(flag == 0){
					response.getWriter().println("<script>alert('你还未上传成果文件！');window.location.href = 'result_file_upload.jsp';</script>");
				}
			}
		} else {
			response.getWriter().println("<script>alert('你还未选题！');window.location.href = 'ShowCourseServlet';</script>");
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
