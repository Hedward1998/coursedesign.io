package bean;

public class Sign {
	String sno;
	String sname;
	int signIn;
	int signOut;
	String signInDate;
	String signOutDate;
	int signScore;
	
	String signInStatus;
	String signOutStatus;

	public Sign(){
		
	}
	
	public Sign(String sno, String sname, int signIn, String signInDate, int signScore) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.signIn = signIn;
		this.signInDate = signInDate;
		this.signScore = signScore;
	}

	public Sign(String sno, String sname, int signIn, int signOut, String signOutDate, int signScore) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.signIn = signIn;
		this.signOut = signOut;
		this.signOutDate = signOutDate;
		this.signScore = signScore;
	}
	
	public Sign(String sno, String sname, String signInStatus, String signOutStatus) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.signInStatus = signInStatus;
		this.signOutStatus = signOutStatus;
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

	public int getSignIn() {
		return signIn;
	}

	public void setSignIn(int signIn) {
		this.signIn = signIn;
	}

	public int getSignOut() {
		return signOut;
	}

	public void setSignOut(int signOut) {
		this.signOut = signOut;
	}

	public String getSignInDate() {
		return signInDate;
	}

	public void setSignInDate(String signInDate) {
		this.signInDate = signInDate;
	}

	public String getSignOutDate() {
		return signOutDate;
	}

	public void setSignOutDate(String signOutDate) {
		this.signOutDate = signOutDate;
	}

	public int getSignScore() {
		return signScore;
	}

	public void setSignScore(int signScore) {
		this.signScore = signScore;
	}

	public String getSignInStatus() {
		return signInStatus;
	}

	public void setSignInStatus(String signInStatus) {
		this.signInStatus = signInStatus;
	}

	public String getSignOutStatus() {
		return signOutStatus;
	}

	public void setSignOutStatus(String signOutStatus) {
		this.signOutStatus = signOutStatus;
	}
	
	
}
