package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Teacher;
import util.DButil;

public class TeacherDaoImp implements TeacherDao {

	@Override
	public boolean insert(Teacher data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delect(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String id, Teacher data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Teacher> selectALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher select(String tno) {
		Teacher t = null;
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		String sql = "select * from tb_teacher where tno=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, tno);
			res = psmt.executeQuery();
			if (res.next()) {
				t = new Teacher();
				t.setTno(tno);
				t.setTname(res.getString(2));
				t.setSex(res.getString(3));
				t.setTitle(res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DButil.close(con, psmt, res);
		return t;
	}

}
