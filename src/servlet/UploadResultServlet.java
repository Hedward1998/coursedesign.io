package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.FileMsg;
import dao.FileMsgDao;
import dao.FileMsgDaoImp;

/**
 * Servlet implementation class UploadResultServlet
 */
@WebServlet("/UploadResultServlet")
public class UploadResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Calendar calendar = null;
	Date date = null;
	String d1 = null;
	String d2 = null;
	String userid;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void getTime() {
    	calendar = Calendar.getInstance();
    	date = calendar.getTime();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	SimpleDateFormat sdf2 = new SimpleDateFormat("MMddHHmmss");
    	d1 = sdf1.format(date);
    	d2 = sdf2.format(date);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = (String) request.getSession().getAttribute("username");
		response.setContentType("text/html;charset=utf-8");
		String savePath = "D:\\file\\CourseDesign\\upload\\student";
		File file = new File(savePath);
		if(!file.exists() && !file.isDirectory()){
			file.mkdirs();
		}
		//String message = "";
		try {
			//1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			//3、解决上传中文名乱码
			upload.setHeaderEncoding("UTF-8");
			//3、判断提交上来的数据是否来自表单
			if(!ServletFileUpload.isMultipartContent(request)){
				return;
			}
			//设置上传单个文件最大值，设置1024*1024*10 10M
			upload.setFileSizeMax(1024*1024*10);
			
			//4、使用ServletFileUpload解析器解析上传的数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个表单的输入项
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list){
				//如果fileitem封装的是普通输入项的数据
				if(item.isFormField()){
					//String name = item.getFieldName();
					//String value = item.getString("UTF-8");
					//System.out.println(name + "=" + value);
				}else{//如果fileitem封装的是上传文件
					String filename = item.getName();
					if(filename == null || filename.trim().equals("")){
						continue;
					}
					//注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
					//处理获取到的上传文件的文件名的路径部分，只保留文件名部分
					filename = filename.substring(filename.lastIndexOf("\\") + 1);
					
					//得到文件上传的拓展名
					//String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
					
					//获取item中的上传文件的输入域
					InputStream in = item.getInputStream();
					
					//得到文件保存名
					String saveFilename = makeFileName(filename);
					
					//得到文件保存目录
					String realSavePath = makePath(saveFilename, savePath);
					
					//创建一个文件输出流
					FileOutputStream out = new FileOutputStream(savePath + "\\" + saveFilename);
					//创建一个缓冲区
					byte buffer[] = new byte[1024];
					//判断输入流中数据是否读完的标志
					int length = 0;
					while((length = in.read(buffer)) > 0){
						//将输出流中缓冲区的数据写入到指定目录(savePath\filename)中
						out.write(buffer, 0, length);
					}
					//关闭输入流/输出流
					in.close();
					out.close();
					//删除处理文件上传生成的临时文件
					item.delete();
					//message = "文件上传成功!";
					response.getWriter().println("<script>alert('文件上传成功!');</script>");
					
					getTime();
					FileMsg fmsg = new FileMsg(userid, filename, realSavePath,d1);
					FileMsgDao f = new FileMsgDaoImp();
					//查询文件是否已经插入，重复插入的问题以后修复
					if(f.insertData(fmsg)){
						response.getWriter().println("<script>alert('成果文件信息录入成功！');alert('请及时就实际情况自评成绩！');window.location.href = 'CheckResultServlet';</script>");
					}else{
						response.getWriter().println("<script>alert('成果文件信息录入失败！');window.location.href = 'result_file_upload.jsp';</script>");
					}
				}
			}
		}catch (FileUploadBase.FileSizeLimitExceededException e) {
			e.printStackTrace();
			//文件超过最大值
		} catch (Exception e) {
			//message = "文件上传失败!";
			response.getWriter().println("<script>alert('文件上传失败!');window.location.href='result_file_upload.jsp';</script>");
			e.printStackTrace();
		}
	}
	
	//构造文件名：MMddHHmmss:文件名
	private String makeFileName(String filename){
		getTime();
		return d2 + "_" + filename;
	}
		
	//构造虚拟路径
	private String makePath(String saveFilename, String savePath) {
		return "upload/student/" + saveFilename;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
