package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import bean.Course;
import util.DButil;

public class CourseDaoImp implements CourseDao {

	@Override
	public boolean insert(Course c) {
		boolean flag = false;
		String sql = "insert into tb_course(tno,cname,cdescribe,major,cnumber) values(?,?,?,?,?)";
		String tno = c.getTno();
		String name = c.getName();
		String describe = c.getDescribe();
		String major = c.getMajor();
		int number = c.getNumber();
		int cno = 0;
		String sql_con;
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, tno);
			psmt.setString(2, name);
			psmt.setString(3, describe);
			psmt.setString(4, major);
			psmt.setInt(5, number);
			int i = psmt.executeUpdate();
			if(i > 0){
				sql_con = "select * from tb_course where tno='" + tno + "' and cname='" + name + "' and major='" + major + "'";
				cno = selectCno(sql_con);
				c.setCno(cno);
				if (cno != 0) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DButil.close(con, psmt);
		return flag;
	}
	
	public int selectCno(String sql){
		int cno = 0;
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			res = psmt.executeQuery();
			if(res.next()){
				cno = res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			cno = 0;
		}
		DButil.close(con, psmt, res);
		return cno;
	}

	@Override
	public boolean delect(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String id, Course data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Course> selectALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course select(String major) {
		
		return null;
	}

	@Override
	public boolean select(String tno, String name, String major) {
		boolean flag = true;
		String sql = "select * from tb_course where tno=? and cname=? and major=?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, tno);
			psmt.setString(2, name);
			psmt.setString(3, major);
			res = psmt.executeQuery();
			if(res.next()){
				flag = true;
			}else{
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DButil.close(con, psmt, res);
		return flag;
	}

	@Override
	public ArrayList<Course> selectALL(String major) {
		ArrayList<Course> list = new ArrayList<>();
		String sql = "SELECT c.cname,c.cdescribe,t.tname,c.cnumber,f.filename,c.cno,f.fpath FROM tb_course c,tb_teacher t,tb_filemsg f WHERE c.cno = f.cno AND c.tno = t.tno AND f.userid LIKE 't%' AND c.cnumber>=1 AND major=?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, major);
			res = psmt.executeQuery();
			while(res.next()){
				Course c = new Course();
				String cname = res.getString(1);
				String cdescribe = res.getString(2);
				String tname = res.getString(3);
				int cnumber = res.getInt(4);
				String filename = res.getString(5);
				int cno = res.getInt(6);
				String filepath = res.getString(7);
				String fpath = filepath.substring(filepath.lastIndexOf("/") + 1);
				c.setName(cname);
				c.setDescribe(cdescribe);
				c.setTname(tname);
				c.setNumber(cnumber);
				c.setFilename(filename);
				c.setCno(cno);
				c.setFpath(fpath);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DButil.close(con, psmt, res);
		}
	}

	@Override
	public ArrayList<Course> selectData(String tno) {
		ArrayList<Course> list = new ArrayList<>();
		String sql = "SELECT cname,cdescribe,major,cnumber FROM tb_course WHERE tno=?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, tno);
			res = psmt.executeQuery();
			while(res.next()){
				Course c = new Course();
				String cname = res.getString(1);
				String cdescribe = res.getString(2);
				String major = res.getString(3);
				int cnumber = res.getInt(4);
				c.setName(cname);
				c.setDescribe(cdescribe);
				c.setMajor(major);
				c.setNumber(cnumber);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DButil.close(con, psmt, res);
		}
	}

}
