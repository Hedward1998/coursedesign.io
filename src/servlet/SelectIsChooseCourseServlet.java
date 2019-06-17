package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScDao;
import dao.ScDaoImp;

/**
 * Servlet implementation class SelectIsChooseCourseServlet
 */
@WebServlet("/SelectIsChooseCourseServlet")
public class SelectIsChooseCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectIsChooseCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String sno = (String) request.getSession().getAttribute("username");
		ScDao scDao = new ScDaoImp();
		if (scDao.selectData(sno)) {
			request.getRequestDispatcher("result_file_upload.jsp").forward(request, response);
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
