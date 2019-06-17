package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Sign;
import dao.SignDao;
import dao.SignDaoImp;

/**
 * Servlet implementation class SignServlet
 */
@WebServlet("/SignServlet")
public class SignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int year;
	int month;
	int day;
	int hours;
	int minutes;
	int seconds;
	Calendar c;
	String sno;
	String type_in;
	String type_out;
	boolean signAgain = false;

	protected void getTime() {
		c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH) + 1;
		day = c.get(Calendar.DATE);
		hours = c.get(Calendar.HOUR_OF_DAY);
		minutes = c.get(Calendar.MINUTE);
		/*day = 17;
		hours = 11;
		minutes = 48;
		seconds = 34;*/
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("signType");
		sno = (String) request.getSession().getAttribute("username");
		String sname = (String) request.getSession().getAttribute("name");
		response.setContentType("text/html;charset=UTF-8");
		int signIn = 0;
		int signOut = 0;
		int signScore;

		Date date;
		Timestamp ts;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH");
		String time = null;
		
		
		
		getTime();
		String s = String.format("%d-%d-%d %d:%d:%d", year, month, day, hours, minutes, seconds);
		int hour  = hours - 3;
		String s1 = String.format("%d-%d-%d %d:%d:%d", year, month, day, hour, minutes, seconds);
		try {
			date = df.parse(s);
			time = df.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (year == 2019 && month == 5 && 13 <= day && day <= 17) {
			if (flag.equals("signIn")) {
				if (hours == 8 || hours == 15) {
					if (0 <= minutes && minutes <= 5) {//准时签到
						// 判断如果存在今日本次签到数据like signInDate（y-m-d h） sno = sno,不存在则insert,存在则提示不允许重复签到
						signIn = 2;
						signScore = signIn;
						Sign sign = new Sign(sno, sname, signIn, time, signScore);
						ts = Timestamp.valueOf(s);
						String testTime = df1.format(ts) + "%";
						if (signIn(sign, testTime)) {
							request.getSession().setAttribute("sign", "signIn");
							request.getSession().setAttribute("signTime", time);
							response.getWriter().println("<script>alert('签到成功！');window.location.href = 'sign.jsp';</script>");
						} else {
							if (signAgain == true){
								signAgain = false;
								response.getWriter().println("<script>alert('不允许重复签到！');window.location.href = 'sign.jsp';</script>");
							}
							else
								response.getWriter().println("<script>alert('签到失败！');window.location.href = 'sign.jsp';</script>");
						}
					}else if(6 <= minutes && minutes <= 20){//迟到
						signIn = 1;
						signScore = signIn;
						Sign sign = new Sign(sno, sname, signIn, time, signScore);
						ts = Timestamp.valueOf(s);
						String testTime = df1.format(ts) + "%";
						if (signIn(sign, testTime)) {
							request.getSession().setAttribute("sign", "signIn");
							request.getSession().setAttribute("signTime", time);
							response.getWriter().println("<script>alert('签到成功！');window.location.href = 'sign.jsp';</script>");
						} else {
							if (signAgain == true){
								signAgain = false;
								response.getWriter().println("<script>alert('不允许重复签到！');window.location.href = 'sign.jsp';</script>");
							}
							else
								response.getWriter().println("<script>alert('签到失败！');window.location.href = 'sign.jsp';</script>");
						}
					}else{
						response.getWriter().println("<script>alert('不在签到时间！');window.location.href = 'sign.jsp';</script>");
					}
				} else
					response.getWriter().println("<script>alert('不在签到时间！');window.location.href = 'sign.jsp';</script>");
			} else if (flag.equals("signOut")) {
				if ((hours == 11 && 30 <= minutes && minutes <= 45) || (hours == 18 && 20 <= minutes && minutes <= 35)) {//早退
					// 判断如果存在今日本次签到数据like signInDate（y-m-d h） sno = sno ，不存在则insert，没有签到，仅签退
					// 存在签到，判断其中是否有签退，无则update，有则提示不许重复签退
					signOut = 1;
					signScore = signOut;
					Sign sign = new Sign(sno , sname, 0, signOut, time, signScore);
					ts = Timestamp.valueOf(s);
					String testTime1 = df1.format(ts) + "%";
					ts = Timestamp.valueOf(s1);
					String testTime2 = df1.format(ts) + "%";
					if (signOut(sign, testTime1, testTime2)) {
						request.getSession().setAttribute("sign", "signOut");
						request.getSession().setAttribute("signTime", time);
						response.getWriter().println("<script>alert('签退成功！');window.location.href = 'sign.jsp';</script>");
					} else {
						if (signAgain == true){
							signAgain = false;
							response.getWriter().println("<script>alert('不允许重复签退！');window.location.href = 'sign.jsp';</script>");
						}
						else
							response.getWriter().println("<script>alert('签退失败！');window.location.href = 'sign.jsp';</script>");
					}
				}
				else if ((hours == 11 && 46 <= minutes && minutes <= 50) || (hours == 18 && 36 <= minutes && minutes <= 40)) {// 准时签退
					signOut = 2;
					signScore = signOut;
					Sign sign = new Sign(sno , sname, 0, signOut, time, signScore);
					ts = Timestamp.valueOf(s);
					String testTime1 = df1.format(ts) + "%";
					ts = Timestamp.valueOf(s1);
					String testTime2 = df1.format(ts) + "%";
					if (signOut(sign, testTime1, testTime2)) {
						request.getSession().setAttribute("sign", "signOut");
						request.getSession().setAttribute("signTime", time);
						response.getWriter().println("<script>alert('签退成功！');window.location.href = 'sign.jsp';</script>");
					} else {
						if (signAgain == true){
							signAgain = false;
							response.getWriter().println("<script>alert('不允许重复签退！');window.location.href = 'sign.jsp';</script>");
						}
						else
							response.getWriter().println("<script>alert('签退失败！');window.location.href = 'sign.jsp';</script>");
					}
				}else {
					response.getWriter().println("<script>alert('不在签退时间！');window.location.href = 'sign.jsp';</script>");
				}
			}
		} else
			response.getWriter().println("<script>alert('不在课程设计时间！');window.location.href= 'sign.jsp';</script>");
	}

	private boolean signIn(Sign sign, String str) {
		type_in = "signInDate";
		SignDao dao = new SignDaoImp();
		if (dao.selectData(sno, str, type_in)) {//查询是否已经有本次签到记录，有则返回true，避免重复签到
			signAgain = true;
			return false;
		} else {
			if (dao.insertData(sign, type_in)) {//插入签到数据，成功则true，失败false
				return true;
			} else
				return false;
		}
	}

	private boolean signOut(Sign sign, String str, String str1) {
		type_in = "signInDate";
		type_out = "signOutDate";
		SignDao dao = new SignDaoImp();
		if(dao.selectData(sno, str, type_out)){//判断是否已经签退
			signAgain = true;
			return false;
		}else{
			if (dao.selectData(sno, str1, type_in)) {//判断是否有签到，有则update签到，无则直接insert签退
				if (dao.update(str1, sign)) {//成功签退数据，成功则true，失败false
					return true;
				} else
					return false;
			} else {
				if (dao.insertData(sign, type_out)) {//插入签退数据，成功则true，失败false
					return true;
				} else
					return false;
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
