package dao;

import java.util.ArrayList;

import bean.Sc;

public interface ScDao extends GenericDao<Sc, String> {
	public boolean selectData(String id);
	public Sc selectDatas(String id);
	public Sc selectResultDatas(String id);
	public boolean isSelectAll(int id);
	public boolean delect(String id, int i);
	public ArrayList<Sc> selectHasResultDatas(String id);
	public ArrayList<Sc> selectNoResultDatas(String id);
}
