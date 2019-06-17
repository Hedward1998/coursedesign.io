package bean;

public class Course {
	int cno;
	String tno;
	String name;
	String describe;
	String major;
	int number;
	
	//附加字段
	String tname;
	String filename;
	String fpath;
	
	
	
	public Course() {
		super();
	}
	public Course(String tno, String name, String describe, String major, int number) {
		super();
		this.tno = tno;
		this.name = name;
		this.describe = describe;
		this.major = major;
		this.number = number;
	}
	public Course(int cno, String tno, String name, String describe, String major, int number) {
		super();
		this.cno = cno;
		this.tno = tno;
		this.name = name;
		this.describe = describe;
		this.major = major;
		this.number = number;
	}
	
	
	
	public Course(int cno, String name, String describe, int number, String tname, String filename, String fpath) {
		super();
		this.cno = cno;
		this.name = name;
		this.describe = describe;
		this.number = number;
		this.tname = tname;
		this.filename = filename;
		this.fpath = fpath;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	
	
}
