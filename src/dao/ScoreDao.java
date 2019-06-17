package dao;

import java.util.ArrayList;

import bean.Score;

public interface ScoreDao extends GenericDao<Score, String> {
	public int selectDatas(String id);
	public boolean selectData(String id);
	public Score selectScore(String id);
	public ArrayList<Score> selectALL(String id);
	public ArrayList<Score> selectStudentScore(String id);
}
