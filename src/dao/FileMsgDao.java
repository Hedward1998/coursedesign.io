package dao;

import java.util.ArrayList;

import bean.FileMsg;

public interface FileMsgDao extends GenericDao<FileMsg, String> {

	boolean selectData(int id);
	public ArrayList<FileMsg> selectALL(String id);
	public boolean insertData(FileMsg fmsg);
	public boolean selectDatas(String id);

}
