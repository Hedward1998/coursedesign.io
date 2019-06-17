package bean;

public class Score{
	int cno;
	int fno;
	String sno;
	String selfGrade;
	String comments;
	double usualScore;
	double finalScore;
	double score;
	
	//附加
	String sname;
	String major;
	String cname;
	String filename;
	String fpath;
	int signScore;
	String selfScore;
	String selfComments;
	
	String dept;
	
	
	
	
	public Score() {
		super();
	}

	public Score(int cno, int fno, String sno, String selfGrade, String comments, double usualScore, double finalScore,
			double score) {
		super();
		this.cno = cno;
		this.fno = fno;
		this.sno = sno;
		this.selfGrade = selfGrade;
		this.comments = comments;
		this.usualScore = usualScore;
		this.finalScore = finalScore;
		this.score = score;
	}
	
	

	public Score(String sno, String sname, String major, String cname, String filename, String fpath, int signScore,
			String selfScore, String selfComments) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.major = major;
		this.cname = cname;
		this.filename = filename;
		this.fpath = fpath;
		this.signScore = signScore;
		this.selfScore = selfScore;
		this.selfComments = selfComments;
	}
	
	public Score(String sno, String comments, double usualScore, double finalScore, double score, String sname,
			String major, String cname, int signScore, String selfScore, String selfComments, String dept) {
		super();
		this.sno = sno;
		this.comments = comments;
		this.usualScore = usualScore;
		this.finalScore = finalScore;
		this.score = score;
		this.sname = sname;
		this.major = major;
		this.cname = cname;
		this.signScore = signScore;
		this.selfScore = selfScore;
		this.selfComments = selfComments;
		this.dept = dept;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSelfGrade() {
		return selfGrade;
	}

	public void setSelfGrade(String selfGrade) {
		this.selfGrade = selfGrade;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public double getUsualScore() {
		return usualScore;
	}

	public void setUsualScore(double usualScore) {
		this.usualScore = usualScore;
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

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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

	public int getSignScore() {
		return signScore;
	}

	public void setSignScore(int signScore) {
		this.signScore = signScore;
	}

	public String getSelfScore() {
		return selfScore;
	}

	public void setSelfScore(String selfScore) {
		this.selfScore = selfScore;
	}

	public String getSelfComments() {
		return selfComments;
	}

	public void setSelfComments(String selfComments) {
		this.selfComments = selfComments;
	}

	public double getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(double finalScore) {
		this.finalScore = finalScore;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
