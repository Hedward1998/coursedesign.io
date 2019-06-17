package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Sc;
import dao.FileMsgDao;
import dao.FileMsgDaoImp;
import dao.ScDao;
import dao.ScDaoImp;

/**
 * Servlet implementation class CheckResultServlet
 */
@WebServlet("/CheckResultServlet")
public class CheckResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String sno = (String) request.getSession().getAttribute("username");
		Sc sc = null;
		ScDao scDao = new ScDaoImp();
		FileMsgDao fileDao = new FileMsgDaoImp();
		if (scDao.selectData(sno)) {
			if (fileDao.selectDatas(sno)) {
				sc = scDao.selectResultDatas(sno);
				if (sc != null) {
					request.getSession().setAttribute("scResult", sc);
					response.getWriter().println("<script>window.location.href = 'self_grade.jsp';</script>");
				}else{
					response.getWriter().println("<script>alert('请重试！');window.location.href = 'result_file_upload.jsp';</script>");
				}
			} else {
				response.getWriter().println("<script>alert('你还未上传成果文件，不能够进行自评。请先上传成果！');window.location.href = 'result_file_upload.jsp';</script>");
			}
		}else {
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
