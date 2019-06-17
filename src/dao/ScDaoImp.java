package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Sc;
import util.DButil;

public class ScDaoImp implements ScDao {

	@Override
	public boolean insert(Sc sc) {
		boolean flag = false;
		String sql = "insert into tb_sc(cno,sno) values(?,?)";
		int cno = sc.getCno();
		String sno = sc.getSno();
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, cno);
			psmt.setString(2,sno);
			int i = psmt.executeUpdate();
			if(i > 0){
				if(updateCourse(cno, 1)){
					flag = true;
				}else{
					flag = false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.close(con, psmt);
		}
		return flag;
	}
	

	@Override
	public boolean delect(String sno, int cno) {
		boolean flag = false;
		String sql = "delete from tb_sc where sno=?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, sno);
			int i = psmt.executeUpdate();
			if (i > 0) {
				if (updateCourse(cno, 2)) {
					flag = true;
				} else {
					flag = false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DButil.close(con, psmt);
		return flag;
	}
	
	public boolean updateCourse(int cno,int type){
		boolean flag = false;
		String sql_choose = "update tb_course set cnumber=cnumber-1 where cno=?";
		String sql_cancel = "update tb_course set cnumber=cnumber+1 where cno=?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		try {
			if (type == 1) {
				psmt = con.prepareStatement(sql_choose);
			} else if(type == 2) {
				psmt = con.prepareStatement(sql_cancel);
			}
			psmt.setInt(1, cno);
			int i = psmt.executeUpdate();
			if(i > 0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
		DButil.close(con, psmt);
		return flag;
	}

	@Override
	public boolean delect(String sno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String id, Sc data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Sc> selectALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sc select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean selectData(String id) {
		boolean flag = true;
		String sql = "select * from tb_sc where sno = ?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
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
	public boolean isSelectAll(int id) {
		boolean flag = false;
		String sql = "select cnumber from tb_course where cno = ?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
			res = psmt.executeQuery();
			if(res.next()){
				int number = res.getInt(1);
				if(number > 0){//可选
					flag = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
		DButil.close(con, psmt, res);
		return flag;
	}

	@Override
	public Sc selectDatas(String sno) {
		String sql = "SELECT cname,cdescribe,tname,filename,fpath,s.cno FROM tb_sc s,tb_course c,tb_filemsg f,tb_teacher t WHERE s.cno=c.cno AND c.cno=f.cno AND t.tno=c.tno AND sno=?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		Sc sc = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, sno);
			res = psmt.executeQuery();
			if(res.next()){
				String cname = res.getString(1);
				String cdescribe = res.getString(2);
				String tname = res.getString(3);
				String filename = res.getString(4);
				String filePath = res.getString(5);
				String fpath = filePath.substring(filePath.lastIndexOf("/") + 1);
				int cno = res.getInt(6);
				sc = new Sc();
				sc.setCname(cname);
				sc.setCdescribe(cdescribe);
				sc.setTname(tname);
				sc.setFilename(filename);
				sc.setFpath(fpath);
				sc.setCno(cno);
				sc.setSno(sno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			sc = null;
		}
		DButil.close(con, psmt, res);
		return sc;
	}


	@Override
	public Sc selectResultDatas(String id) {
		Sc sc = null;
		String sql = "SELECT cname,cdescribe,tname,filename,fpath,c.cno,fno FROM tb_course c,tb_teacher t,tb_sc sc,tb_filemsg f WHERE c.tno = t.tno AND c.cno = sc.cno AND sc.sno = f.userid AND userid=?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			res = psmt.executeQuery();
			if(res.next()){
				String cname = res.getString(1);
				String cdescribe = res.getString(2);
				String tname = res.getString(3);
				String filename = res.getString(4);
				String filePath = res.getString(5);
				String fpath = filePath.substring(filePath.lastIndexOf("/") + 1);
				int cno = res.getInt(6);
				int fno = res.getInt(7);
				sc = new Sc();
				sc.setCname(cname);
				sc.setCdescribe(cdescribe);
				sc.setTname(tname);
				sc.setFilename(filename);
				sc.setFpath(fpath);
				sc.setCno(cno);
				sc.setFno(fno);
				sc.setSno(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			sc = null;
		}
		DButil.close(con, psmt, res);
		return sc;
	}


	@Override
	public ArrayList<Sc> selectHasResultDatas(String id) {
		String sql = "SELECT cname,cdescribe,s.sno,sname,s.major,filename,fpath,uploadTime FROM tb_course c,tb_sc sc,tb_student s,tb_filemsg f WHERE c.cno=sc.cno AND sc.sno=s.sno AND s.sno=f.userid AND tno=?";
		Sc sc = null;
		ArrayList<Sc> list = new ArrayList<>();
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			res = psmt.executeQuery();
			while(res.next()){
				sc = new Sc();
				sc.setCname(res.getString(1));
				sc.setCdescribe(res.getString(2));
				sc.setSno(res.getString(3));
				sc.setSname(res.getString(4));
				sc.setMajor(res.getString(5));
				sc.setFilename(res.getString(6));
				String filepath = res.getString(7);
				String fpath = filepath.substring(filepath.lastIndexOf("/") + 1);
				sc.setFpath(fpath);
				sc.setUploadTime(res.getString(8));
				list.add(sc);
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
	public ArrayList<Sc> selectNoResultDatas(String id) {
		String sql = "SELECT cname,cdescribe,s.sno,sname,s.major FROM tb_course c,tb_sc sc,tb_student s WHERE c.cno=sc.cno AND sc.sno=s.sno AND s.sno NOT IN(SELECT userid FROM tb_filemsg) AND tno=?";
		Sc sc1 = null;
		ArrayList<Sc> list = new ArrayList<>();
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			res = psmt.executeQuery();
			while(res.next()){
				sc1 = new Sc();
				sc1.setCname(res.getString(1));
				sc1.setCdescribe(res.getString(2));
				sc1.setSno(res.getString(3));
				sc1.setSname(res.getString(4));
				sc1.setMajor(res.getString(5));
				sc1.setCno(0);
				list.add(sc1);
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
