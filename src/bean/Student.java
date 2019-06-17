package bean;

public class Student {
	private String sno;
	private String sname;
	private String sex;
	private int age;
	private String dept;
	private String major;
	private int grade;
	private int classno;
	
	String cname;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String sno, String sname, String sex, int age, String dept, String major, int grade, int classno) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
		this.age = age;
		this.dept = dept;
		this.major = major;
		this.grade = grade;
		this.classno = classno;
	}
	
	public Student(String sno, String sname, String dept, String major, int grade, String cname) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.dept = dept;
		this.major = major;
		this.grade = grade;
		this.cname = cname;
	}
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
	
}
