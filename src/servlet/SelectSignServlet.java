package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Sign;
import dao.SignDao;
import dao.SignDaoImp;

/**
 * Servlet implementation class SelectSignServlet
 */
@WebServlet("/SelectSignServlet")
public class SelectSignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectSignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String tno = (String) request.getSession().getAttribute("username");
		String time = request.getParameter("choose_time");
		if (time.length() == 0) {
			response.getWriter().println("<script>alert('请重新选择正确的时间！');window.location.href = 'sign_manager.jsp';</script>");
		} else {
			String select_time = time + "%";
			SignDao sDao = new SignDaoImp();
			ArrayList<Sign> list_sign = sDao.selectALL(tno, select_time);
			if (list_sign != null) {
				request.getSession().setAttribute("timeSign", time);
				request.getSession().setAttribute("list_sign", list_sign);
				response.getWriter().println("<script>window.location.href = 'sign_manager.jsp';</script>");
			}else{
				response.getWriter().println("<script>window.location.href = 'SelectSignServlet?choose_time='"+time+";</script>");
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
