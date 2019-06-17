package bean;

public class Teacher {
	private String tno;
	private String tname;
	private String sex;
	private String title;
	public Teacher(String tno, String tname, String sex, String title) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.sex = sex;
		this.title = title;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
