package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Student;
import util.DButil;

public class StudentDaoImp implements StudentDao{

	@Override
	public boolean insert(Student data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delect(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String id, Student data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Student> selectALL() {
		ArrayList<Student> list = new ArrayList<>();
		Connection con = DButil.getConnection();
		Statement psmt = null;
		ResultSet res = null;
		String sql = "SELECT sno,sname,dept,major,grade FROM tb_student WHERE sno NOT IN(SELECT sno FROM tb_sc)";
		try {
			psmt = con.createStatement();
			res = psmt.executeQuery(sql);
			while (res.next()) {
				Student student = new Student();
				student.setSno(res.getString(1));
				student.setSname(res.getString(2));
				student.setDept(res.getString(3));
				student.setMajor(res.getString(4));
				student.setGrade(res.getInt(5));
				list.add(student);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		}
		DButil.close(con, psmt, res);
		return list;
	}

	@Override
	public Student select(String sno) {
		Student student = new Student();
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		String sql = "select * from tb_student where sno=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, sno);
			res = psmt.executeQuery();
			
			while (res.next()) {
				student.setSno(res.getString(1));
				student.setSname(res.getString(2));
				student.setSex(res.getString(3));
				student.setAge(res.getInt(4));
				student.setDept(res.getString(5));
				student.setMajor(res.getString(6));
				student.setGrade(res.getInt(7));
				student.setClassno(res.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DButil.close(con, psmt, res);
		return student;
	}

	@Override
	public ArrayList<Student> selectByName(String tno) {
		ArrayList<Student> list = new ArrayList<>();
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		String sql = "SELECT s.sno,sname,dept,s.major,grade,cname FROM tb_student s,tb_sc sc,tb_course c WHERE s.sno=sc.sno AND sc.cno=c.cno AND c.tno=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, tno);
			res = psmt.executeQuery();
			while (res.next()) {
				Student student = new Student();
				student.setSno(res.getString(1));
				student.setSname(res.getString(2));
				student.setDept(res.getString(3));
				student.setMajor(res.getString(4));
				student.setGrade(res.getInt(5));
				student.setCname(res.getString(6));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		}
		DButil.close(con, psmt, res);
 		return list;
	}
	
	

}
