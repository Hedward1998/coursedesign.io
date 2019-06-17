package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.User;
import util.DButil;

public class UserDaoImp implements UserDao {

	@Override
	public boolean insert(User data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delect(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String type, User user) {
		boolean flag = false;
		String type1 = "PasswordInit";
		String type2 = "MessageInit";
		String sql_update_message = "update tb_user set password = ?,phone = ?,email = ? where username = ?";
		String sql_update_password = "update tb_user set password = ? where username = ?";
		String username = user.getUsername();
		String password = user.getPassword();
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		try {
			if (type.equals(type1)) {
				psmt = con.prepareStatement(sql_update_password);
				psmt.setString(1, password);
				psmt.setString(2, username);
			} else if (type.equals(type2)) {
				String phone = user.getPhone();
				String email = user.getEmail();
				psmt = con.prepareStatement(sql_update_message);
				psmt.setString(1, password);
				psmt.setString(2, phone);
				psmt.setString(3, email);
				psmt.setString(4, username);
			}
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
	public ArrayList<User> selectALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User select(String id) {
		User user = new User();
		String sql = "select * from tb_user where username = ?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			res = psmt.executeQuery();
			if (res.next()) {
				user.setUsername(res.getString(1));
				user.setPassword(res.getString(2));
				user.setPhone(res.getString(3));
				user.setEmail(res.getString(4));
			} else {
				user = null;
			}
		} catch (SQLException e) {
			user = null;
		}
		DButil.close(con, psmt, res);
		return user;
	}

	@Override
	public String getName(String id) {
		String name = "";
		String sql_t = "select tname from tb_user u, tb_teacher t where t.tno = u.username and username=?";
		String sql_s = "select sname from tb_user u, tb_student s where s.sno = u.username and username=?";
		Connection con = DButil.getConnection();
		PreparedStatement ptmt = null;
		ResultSet res = null;
		try {
			if (id.startsWith("s")) {
				ptmt = con.prepareStatement(sql_s);
			} else {
				ptmt = con.prepareStatement(sql_t);
			}
			ptmt.setString(1, id);
			res = ptmt.executeQuery();
			while (res.next())
				name = res.getString(1);
		} catch (SQLException e) {
			return "";
		}
		return name;
	}

}
