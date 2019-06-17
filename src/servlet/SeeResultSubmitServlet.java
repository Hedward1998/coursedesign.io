package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Sc;
import dao.ScDao;
import dao.ScDaoImp;

/**
 * Servlet implementation class SeeResultSubmitServlet
 */
@WebServlet("/SeeResultSubmitServlet")
public class SeeResultSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeResultSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String tno = (String) request.getSession().getAttribute("username");
		//分为已提交 、未提交 两个table 
		//查询cname,cdescribe,sno,sname,major,filename(fpath),uploadTime
		//查询cname,cdescribe,sno,sname,major
		//list1 = ScDaoImp.selectHasResultDatas(tno)//// list2 =  ScDaoImp.selectNoResultDatas(tno)
		ScDao scDao = new ScDaoImp();
		ArrayList<Sc> list1 = scDao.selectHasResultDatas(tno);
		ArrayList<Sc> list2 = scDao.selectNoResultDatas(tno);
		
		request.getSession().setAttribute("list1", list1);
		request.getSession().setAttribute("list2", list2);
		request.getRequestDispatcher("/show_result_message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
