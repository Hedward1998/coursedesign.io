package bean;

public class Sc {
	int cno;
	String sno;
	
	//附加字段
	String cname;
	String cdescribe;
	String tname;
	String filename;
	String fpath;
	int fno;
	
	String sname;
	String major;
	String uploadTime;
	
	
	public Sc(int cno, String sno) {
		super();
		this.cno = cno;
		this.sno = sno;
	}
	
	public Sc(String cname, String cdescribe, String tname, String filename, String fpath) {
		super();
		this.cname = cname;
		this.cdescribe = cdescribe;
		this.tname = tname;
		this.filename = filename;
		this.fpath = fpath;
	}

	public Sc(String cname, String cdescribe, String tname, String filename, String fpath,int cno,int fno) {
		super();
		this.cname = cname;
		this.cdescribe = cdescribe;
		this.tname = tname;
		this.filename = filename;
		this.fpath = fpath;
		this.cno = cno;
		this.fno = fno;
	}
	
	public Sc(String sno, String cname, String cdescribe, String sname, String major,int cno) {//cno无效，区别方法使用，传0 不同
		super();
		this.sno = sno;
		this.cname = cname;
		this.cdescribe = cdescribe;
		this.sname = sname;
		this.major = major;
	} 

	public Sc(String sno, String cname, String cdescribe, String filename, String fpath, String sname, String major,
			String uploadTime) {
		super();
		this.sno = sno;
		this.cname = cname;
		this.cdescribe = cdescribe;
		this.filename = filename;
		this.fpath = fpath;
		this.sname = sname;
		this.major = major;
		this.uploadTime = uploadTime;
	}

	public Sc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCdescribe() {
		return cdescribe;
	}

	public void setCdescribe(String cdescribe) {
		this.cdescribe = cdescribe;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFpath() {
		return fpath;
	}

	public void setFpath(String fpath) {
		this.fpath = fpath;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	
}
