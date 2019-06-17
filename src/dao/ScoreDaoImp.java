package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Score;
import util.DButil;

public class ScoreDaoImp implements ScoreDao {

	@Override
	public boolean insert(Score s) {
		boolean flag = false;
		String sql = "insert into tb_score(cno,fno,sno,selfGrade) values(?,?,?,?)";
		int cno = s.getCno();
		int fno = s.getFno();
		String sno = s.getSno();
		String selfGrade = s.getSelfGrade();
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, cno);
			psmt.setInt(2,fno);
			psmt.setString(3, sno);
			psmt.setString(4, selfGrade);
			int i = psmt.executeUpdate();
			if(i > 0){
				flag = true;
			}else{
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.close(con, psmt);
		}
		return flag;
	}

	@Override
	public boolean delect(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String sno, Score s) {
		boolean flag = false;
		String sql = "UPDATE tb_score SET comments=?,usualScore=?,finalScore=?,score=usualScore*30/100+finalScore*70/100 WHERE sno=?";
		double usualScore = s.getUsualScore();
		double finalScore = s.getFinalScore();
		String comments = s.getComments();
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, comments);
			psmt.setDouble(2, usualScore);
			psmt.setDouble(3, finalScore);
			psmt.setString(4, sno);
			int i = psmt.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		DButil.close(con, psmt);
		return flag;
	}

	@Override
	public ArrayList<Score> selectALL() {
		
		return null;
	}

	@Override
	public Score select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean selectData(String id) {
		boolean flag = true;
		String sql = "select * from tb_score where sno = ?";
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
	
	public int selectDatas(String id){
		int flag = 0;
		String sql = "select * from tb_filemsg where userid=?";
		String sql1 = "select * from tb_score where sno = ?";
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		PreparedStatement psmt1 = null;
		ResultSet res1 = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			res = psmt.executeQuery();
			if(res.next()){
				psmt1 = con.prepareStatement(sql1);
				psmt1.setString(1, id);
				res1 = psmt1.executeQuery();
				if(res1.next()){
					flag = 2;
				}else{
					flag = 1;
				}
			}else{
				flag = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.close(con, psmt, res);
			DButil.close(con, psmt1, res1);
		}
		return flag;
	}

	@Override
	public ArrayList<Score> selectALL(String id) {
		String sql = "SELECT s.sno,s.sname,s.major,cname,filename,fpath,selfGrade FROM tb_student s,tb_sc sc,tb_course c,tb_filemsg f,tb_score score WHERE s.sno=sc.sno AND sc.cno=c.cno AND s.sno=f.userid AND s.sno=score.sno AND score IS NULL AND tno=?";
		Score s = null;
		ArrayList<Score> list = new ArrayList<>();
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			res = psmt.executeQuery();
			while(res.next()){
				s = new Score();
				String sno = res.getString(1);
				String sname = res.getString(2);
				String major = res.getString(3);
				String cname = res.getString(4);
				String filename = res.getString(5);
				String filepath = res.getString(6);
				String fpath = filepath.substring(filepath.lastIndexOf("/") + 1);
				String selfGrade = res.getString(7);//分解自评为评分和评论
				//String sScore = selfGrade.substring(0, selfGrade.lastIndexOf("_"));
				//double selfScore = Double.parseDouble(sScore);
				String selfScore = selfGrade.substring(0, selfGrade.lastIndexOf("_"));
				String selfComments = selfGrade.substring(selfGrade.lastIndexOf("_") + 1);
				int signScore = getSignScore(sno);
				s.setSno(sno);
				s.setSname(sname);
				s.setMajor(major);
				s.setCname(cname);
				s.setFilename(filename);
				s.setFpath(fpath);
				s.setSelfScore(selfScore);
				s.setSelfComments(selfComments);
				s.setSignScore(signScore);
				list.add(s);				
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DButil.close(con, psmt, res);
		}
	}
	
	public int getSignScore(String sno){
		String sql = "SELECT (SUM(signScore)/20)*100 sign_Score FROM tb_sign WHERE sno=?";
		int signScore = 0;
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, sno);
			res = psmt.executeQuery();
			if (res.next()) {
				signScore = res.getInt(1);
			}else{
				signScore = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DButil.close(con, psmt, res);
		return signScore;
	}

	@Override
	public ArrayList<Score> selectStudentScore(String id) {
		String sql = "SELECT s.sno,s.sname,dept,s.major,cname,selfGrade,comments,usualScore,finalScore,score FROM tb_student s,tb_sc sc,tb_course c,tb_score score WHERE s.sno=sc.sno AND sc.cno=c.cno AND s.sno=score.sno AND score IS NOT NULL AND tno=?";
		Score s = null;
		ArrayList<Score> list = new ArrayList<>();
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			res = psmt.executeQuery();
			while(res.next()){
				s = new Score();
				String sno = res.getString(1);
				String sname = res.getString(2);
				String dept = res.getString(3);
				String major = res.getString(4);
				String cname = res.getString(5);
				String selfGrade = res.getString(6);
				String comments = res.getString(7);
				double usualScore = res.getDouble(8);
				double finalScore = res.getDouble(9);
				double score = res.getDouble(10);
				String selfScore = selfGrade.substring(0, selfGrade.lastIndexOf("_"));
				String selfComments = selfGrade.substring(selfGrade.lastIndexOf("_") + 1);
				int signScore = getSignScore(sno);
				s.setSno(sno);
				s.setSname(sname);
				s.setDept(dept);
				s.setMajor(major);
				s.setCname(cname);
				s.setSelfScore(selfScore);
				s.setSelfComments(selfComments);
				s.setSignScore(signScore);
				s.setComments(comments);
				s.setUsualScore(usualScore);
				s.setFinalScore(finalScore);
				s.setScore(score);
				list.add(s);				
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
	public Score selectScore(String sno) {
		String sql = "SELECT s.sname,cname,selfGrade,comments,usualScore,finalScore,score FROM tb_student s,tb_sc sc,tb_course c,tb_score score WHERE s.sno=sc.sno AND sc.cno=c.cno AND s.sno=score.sno AND score IS NOT NULL AND s.sno=?";
		Score s = null;
		Connection con = DButil.getConnection();
		PreparedStatement psmt = null;
		ResultSet res = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, sno);
			res = psmt.executeQuery();
			if(res.next()){
				s = new Score();
				String sname = res.getString(1);
				String cname = res.getString(2);
				String selfGrade = res.getString(3);
				String comments = res.getString(4);
				double usualScore = res.getDouble(5);
				double finalScore = res.getDouble(6);
				double score = res.getDouble(7);
				String selfScore = selfGrade.substring(0, selfGrade.lastIndexOf("_"));
				String selfComments = selfGrade.substring(selfGrade.lastIndexOf("_") + 1);
				int signScore = getSignScore(sno);
				s.setSno(sno);
				s.setSname(sname);
				s.setCname(cname);
				s.setSelfScore(selfScore);
				s.setSelfComments(selfComments);
				s.setSignScore(signScore);
				s.setComments(comments);
				s.setUsualScore(usualScore);
				s.setFinalScore(finalScore);
				s.setScore(score);
				System.out.println();
			}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DButil.close(con, psmt, res);
		}
	}

}
