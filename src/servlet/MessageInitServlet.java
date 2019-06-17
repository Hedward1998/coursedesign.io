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
 * Servlet implementation class MessageInitServlet
 */
@WebServlet("/MessageInitServlet")
public class MessageInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageInitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String type1 = "PasswordInit";
		String type2 = "MessageInit";
		String username = (String) request.getSession().getAttribute("username");
		String password = request.getParameter("newPwd");
		response.setContentType("text/html;charset=UTF-8");
		UserDao dao = new UserDaoImp();
		if (type.equals(type1)) {
			User user = new User(username, password);
			if (dao.update(type, user)) {
				response.getWriter().println("<script>alert('密码修改成功，返回登录！');window.location.href = 'login.jsp';</script>");
			} else {
				response.getWriter().println("<script>alert('密码修改失败，请重试！');window.location.href = 'password_init.jsp';</script>");
			}
		} else if (type.equals(type2)) {
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			User user = new User(username, password, phone, email);
			if (dao.update(type, user)) {
				response.getWriter().println("<script>alert('信息更新成功，返回登录！');window.location.href = 'login.jsp';</script>");
			} else {
				response.getWriter().println("<script>alert('信息更新失败，请重试！');window.location.href = 'message_init.jsp';</script>");
			}
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
