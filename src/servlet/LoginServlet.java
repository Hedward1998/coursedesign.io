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
import util.ImageUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		response.setContentType("text/html;charset=UTF-8");
		if (ImageUtil.getScode().toLowerCase().equals(code.toLowerCase())) {
			UserDao dao = new UserDaoImp();
			User user = dao.select(username);
			if (user != null) {
				// String time =
				// (String)request.getSession().getAttribute("time");
				// String sPwd =
				// Conver2MD5.getMD5(user.getPassword().toUpperCase() +
				// time);
				// request.getSession().setAttribute("time", "");
				String pwd = user.getPassword();
				String phone = user.getPhone();
				String email = user.getEmail();
				if (pwd.equals(password)) {
					name = dao.getName(username);
					request.getSession().setAttribute("name", name);
					request.getSession().setAttribute("username", username);
					request.getSession().setAttribute("checkName", username);
					request.getSession().setAttribute("checkPwd", pwd);
					request.getSession().setAttribute("checkPhone", phone);
					request.getSession().setAttribute("checkEmail", email);
					request.getSession().setAttribute("user", user);
					if (phone == null || email == null || pwd.equals(username)) {
						if (phone == null || email == null) {
							request.getSession().setAttribute("flag", "0");
						} else if (phone != null && password.equals(username)) {
							request.getSession().setAttribute("flag", "1");
						}
						response.getWriter().println(
								"<script>alert('由于你的账号信息未完善，我们需要完善你的信息，以便于后续使用！');window.location.href = 'first_insert_message.jsp';</script>");
					}
					if (username.startsWith("g")) {
						response.getWriter().println("<script>window.location.href = 'g.jsp';</script>");
					} else if (username.startsWith("t")) {
						response.getWriter().println("<script>window.location.href = 'head_teacher.jsp';</script>");
					} else if (username.startsWith("s")) {
						response.getWriter().println("<script>window.location.href = 'head_student.jsp';</script>");
					}
				} else {
					response.getWriter().println("<script>alert('密码错误！');window.location.href = 'login.jsp';</script>");
				}
			} else {
				response.getWriter().println("<script>alert('用户名不存在！');window.location.href = 'login.jsp';</script>");
			}
		} else {
			response.getWriter().println("<script>alert('验证码错误！');window.location.href = 'login.jsp';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
