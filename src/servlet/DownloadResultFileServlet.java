package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadResultFileServlet
 */
@WebServlet("/DownloadResultFileServlet")
public class DownloadResultFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadResultFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String fileName = request.getParameter("filename");
		String fileSavePath = "D:\\file\\CourseDesign\\upload\\student";
		File file = new File(fileSavePath + "\\" + fileName);
		if (!file.exists()) {
			response.getWriter().println("<script>alert('下载的资源已删除！');window.location.href = 'CheckResultServlet';</script>");
			return;
		}
		String realName = fileName.substring(fileName.indexOf("_") + 1);
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realName,"UTF-8"));
		FileInputStream in = new FileInputStream(fileSavePath + "\\" + fileName);
		OutputStream out = response.getOutputStream();
		byte buffer[] = new byte[1024];
		int len = 0;
		while((len = in.read(buffer)) > 0){
			out.write(buffer,0,len);
		}
		in.close();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
