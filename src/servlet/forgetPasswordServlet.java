package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;
import dao.UserDaoImp;

/**
 * Servlet implementation class forgetPasswordServlet
 */
@WebServlet("/forgetPasswordServlet")
public class forgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		response.setContentType("text/html;charset=UTF-8");
		UserDao dao = new UserDaoImp();
		User user = dao.select(username);
		if (user != null) {
			String password = user.getPassword();
			String phone_u = user.getPhone();
			String email_u = user.getEmail();
			if (phone.equals(phone_u) && email.equals(email_u)) {
				request.getSession().setAttribute("checkName", username);
				request.getSession().setAttribute("checkPwd", password);
				response.getWriter().println("<script>window.location.href = 'password_init.jsp';</script>");
			} else {
				response.getWriter()
						.println(
								"<script>alert('你输入的电话或邮箱不正确！');window.location.href = 'forget_password.jsp';</script>");
			}
		} else {
			response.getWriter()
					.println("<script>alert('用户名不存在！');window.location.href = 'forget_password.jsp';</script>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
