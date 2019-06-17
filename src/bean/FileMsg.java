package bean;

public class FileMsg {
	int cno;//非必须字段，老师存文件时区分不同课程的文件
	String userId;
	String fileName;
	String filePath;
	String uploadTime;
	public FileMsg(int cno, String userId, String fileName, String filePath, String uploadTime) {
		super();
		this.cno = cno;
		this.userId = userId;
		this.fileName = fileName;
		this.filePath = filePath;
		this.uploadTime = uploadTime;
	}
	public FileMsg(String userId, String fileName, String filePath, String uploadTime) {
		super();
		this.userId = userId;
		this.fileName = fileName;
		this.filePath = filePath;
		this.uploadTime = uploadTime;
	}
	public FileMsg() {
		// TODO Auto-generated constructor stub
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
}
