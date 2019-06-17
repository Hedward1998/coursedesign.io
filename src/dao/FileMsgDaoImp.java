package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.FileMsg;
import util.DButil;

public class FileMsgDaoImp implements FileMsgDao {

	@Override
	public boolean insert(FileMsg fmsg) {
		boolean flag = false;
		int cno = fmsg.getCno();
		String userId = fmsg.getUserId();
		String filename = fmsg.getFileName();
		String fpath = fmsg.getFilePath();
		String time = fmsg.getUploadTime();
		String sql_tno = "insert into tb_filemsg(cno,userid,filename,fpath,uploadTime) values(?,?,?,?,?)";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement(sql_tno);
			psmt.setInt(1, cno);
			psmt.setString(2, userId);
			psmt.setString(3, filename);
			psmt.setString(4, fpath);
			psmt.setString(5, time);
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
	public boolean insertData(FileMsg fmsg) {
		boolean flag = false;
		String userId = fmsg.getUserId();
		String filename = fmsg.getFileName();
		String fpath = fmsg.getFilePath();
		String time = fmsg.getUploadTime();
		String sql_tno = "insert into tb_filemsg(userid,filename,fpath,uploadTime) values(?,?,?,?)";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement(sql_tno);
			psmt.setString(1, userId);
			psmt.setString(2, filename);
			psmt.setString(3, fpath);
			psmt.setString(4, time);
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
	public boolean delect(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String id, FileMsg data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<FileMsg> selectALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileMsg select(String id) {//查询是否有userID=sno，是否已经上传成果
		return null;
	}
	
	@Override
	public boolean selectDatas(String id){
		boolean flag = false;
		String sql = "select * from tb_filemsg where userid=?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			res = psmt.executeQuery();
			if(res.next()){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DButil.close(con, psmt, res);
		return flag;
	}
	
	public boolean selectData(int id) {//后期修复查重复
		boolean flag = true;
		String sql = "select * from tb_filemsg where cno = ?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
			res = psmt.executeQuery();
			if (res.next()) {
				flag = true;
			}else {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DButil.close(con, psmt, res);
		return flag;
	}

	@Override
	public ArrayList<FileMsg> selectALL(String userid) {
		ArrayList<FileMsg> list = new ArrayList<>();
		String sql  = "select cno, fpath from tb_filemsg where userid like ?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, userid);
			res = psmt.executeQuery();
			while(res.next()){
				FileMsg fileMsg = new FileMsg();
				int cno = res.getInt(1);
				String fpath = res.getString(2);
				String fileSaveName = fpath.substring(fpath.lastIndexOf("/") + 1);
				String filename = fpath.substring(fpath.lastIndexOf("_") + 1);
				fileMsg.setCno(cno);
				fileMsg.setFileName(filename);
				fileMsg.setFilePath(fileSaveName);
				list.add(fileMsg);
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
