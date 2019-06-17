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
 * Servlet implementation class SetScoreServlet
 */
@WebServlet("/ShowStudentSelfGradeServlet")
public class ShowStudentSelfGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudentSelfGradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String tno = (String) request.getSession().getAttribute("username");
		//①采用StringBuffer进行select下拉框赋值，需要使用一个专门查学号servlet提交之后更新数据，
		//一个jsp页面根据选择的学号传值到servlet获得学生的数据，再传回到jsp显示，填写成绩数据后，
		//跳转到一个servlet页面更新成绩，再到查学号servlet，查出剩余学号，若为空，即跳转到查看成绩servlet，jsp。
		
		//②servlet使用ArrayList读取必要数据到jsp，然后设置按钮点击，即到jsp输入，再到servlet评价，返回查询信息servlet，
		//直至所有数据已评价完，跳转到查看成绩页面servlet,jsp。
		//采用第二种
		
		//select  sno,sname,major,cname,filename,fpath,signScore(100)
		//,self_Score,self_comments
		ScoreDao score = new ScoreDaoImp();
		ArrayList<Score> list_score = score.selectALL(tno);
		if (list_score == null || list_score.size() == 0) {
			//转到查看学生成绩
			response.getWriter().println("<script>alert('没有需要评分的记录，请查看已评阅的记录！');window.location.href = 'ShowStudentScoreServlet';</script>");
		} else {
			request.getSession().setAttribute("list_score", list_score);
			//response.getWriter().println("<script>alert('请评分！');window.location.href = 'show_student_self_grade.jsp';</script>");
			response.getWriter().println("<script>alert('请评分！');</script>");
			request.getRequestDispatcher("show_student_self_grade.jsp").forward(request, response);
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
