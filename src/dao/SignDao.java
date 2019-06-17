package dao;

import java.util.ArrayList;

import bean.Sign;

public interface SignDao extends GenericDao<Sign, String> {
	public boolean selectData(String id, String id1, String type);
	public boolean insertData(Sign data, String type);
	public ArrayList<Sign> selectALL(String id,String id1);
}
