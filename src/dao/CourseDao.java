package dao;


import java.util.ArrayList;

import bean.Course;

public interface CourseDao extends GenericDao<Course, String> {
	public boolean select(String id1, String id2,String id3);
	public ArrayList<Course> selectALL(String id);
	public ArrayList<Course> selectData(String id);
}
