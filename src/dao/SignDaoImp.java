package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Sign;
import util.DButil;

public class SignDaoImp implements SignDao {

	@Override
	public boolean insert(Sign data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delect(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String str, Sign sign) {
		boolean flag = false;
		String sql = "UPDATE tb_sign SET signOut = ?,signOutDate = ?,signScore = signScore + ?  WHERE sno=? AND signInDate LIKE ?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		String sno = sign.getSno();
		int signOut = sign.getSignOut();
		String signOutDate = sign.getSignOutDate();
		int signScore = sign.getSignScore();
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, signOut);
			psmt.setString(2, signOutDate);
			psmt.setInt(3, signScore);
			psmt.setString(4, sno);
			psmt.setString(5, str);
			int i = psmt.executeUpdate();
			if(i > 0)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
		DButil.close(con, psmt);
		return flag;
	}

	@Override
	public ArrayList<Sign> selectALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sign select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean selectData(String sno, String str, String type) {
		boolean flag = true;
		String sql = "select * from tb_sign where sno = ? and " + type + " like ?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, sno);
			psmt.setString(2, str);
			res = psmt.executeQuery();
			if(res.next()){
				flag = true;
			}else{
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag = true;
		}
		DButil.close(con, psmt, res);
		return flag;
	}

	@Override
	public boolean insertData(Sign sign, String type) {
		boolean flag = false;
		String type1 = "signInDate";
		String type2 = "signOutDate";
		String sql_in = "INSERT INTO tb_sign(sno,sname,signIn,signInDate,signScore) VALUES(?,?,?,?,?)";
		String sql_out = "INSERT INTO tb_sign(sno,sname,signOut,signOutDate,signScore) VALUES(?,?,?,?,?)";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		String sno = sign.getSno();
		String sname = sign.getSname();
		int signIn;
		int signOut;
		String signInDate;
		String signOutDate;
		int signScore = sign.getSignScore();
		try {
			if (type.equals(type1)) {
				signIn = sign.getSignIn();
				signInDate = sign.getSignInDate();
				psmt = con.prepareStatement(sql_in);
				psmt.setInt(3, signIn);
				psmt.setString(4, signInDate);
			} else if (type.equals(type2)) {
				signOut = sign.getSignOut();
				signOutDate = sign.getSignOutDate();
				psmt = con.prepareStatement(sql_out);
				psmt.setInt(3, signOut);
				psmt.setString(4, signOutDate);
			}
			psmt.setString(1, sno);
			psmt.setString(2, sname);
			psmt.setInt(5, signScore);
			int i = psmt.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			DButil.close(con, psmt);
		}
		return flag;
	}

	@Override
	public ArrayList<Sign> selectALL(String tno, String select_time) {
		ArrayList<Sign> list = new ArrayList<>();
		Sign sign = null;
		String sql1 = "SELECT sc.sno,sname,IFNULL(signIn,0),IFNULL(signOut,0) FROM tb_sc sc,tb_course c,tb_sign s WHERE sc.cno=c.cno AND s.sno=sc.sno AND tno=? AND (signInDate LIKE ? OR signOutDate like ?) ORDER BY sno";
		String sql2 = "SELECT sc.sno,sname FROM tb_sc sc,tb_course c,tb_student s WHERE sc.cno=c.cno AND s.sno=sc.sno AND sc.sno NOT IN(SELECT sno FROM tb_sign WHERE signInDate LIKE ? OR signOutDate LIKE ?) AND tno=? ORDER BY sc.sno";
		Connection con = DButil.getConnection();
		PreparedStatement psmt1 = null;
		PreparedStatement psmt2 = null;
		ResultSet res1 = null;
		ResultSet res2 = null;
		try {
			psmt1 = con.prepareStatement(sql1);
			psmt1.setString(1, tno);
			psmt1.setString(2, select_time);
			psmt1.setString(3, select_time);
			res1 = psmt1.executeQuery();
			while(res1.next()){
				sign = new Sign();
				sign.setSno(res1.getString(1));
				sign.setSname(res1.getString(2));
				int signIn = res1.getInt(3);
				int signOut = res1.getInt(4);
				if (signIn == 2) {
					sign.setSignInStatus("准时");
				} else if(signIn == 1){
					sign.setSignInStatus("迟到");
				}else if(signIn == 0
						){
					sign.setSignInStatus("缺勤");
				}
				
				if (signOut == 2) {
					sign.setSignOutStatus("准时");
				} else if(signOut == 1){
					sign.setSignOutStatus("早退");
				}else if(signOut == 0){
					sign.setSignOutStatus("缺勤");
				}
				list.add(sign);
			}
			psmt2 = con.prepareStatement(sql2);
			psmt2.setString(1, select_time);
			psmt2.setString(2, select_time);
			psmt2.setString(3, tno);
			res2 = psmt2.executeQuery();
			while(res2.next()){
				sign = new Sign();
				sign.setSno(res2.getString(1));
				sign.setSname(res2.getString(2));
				sign.setSignInStatus("缺勤");
				sign.setSignOutStatus("缺勤");
				list.add(sign);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DButil.close(con, psmt1, res1);
			DButil.close(con, psmt2, res2);
		}
	}

}
