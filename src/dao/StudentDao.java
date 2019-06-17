package dao;

import java.util.ArrayList;

import bean.Student;

public interface StudentDao extends GenericDao<Student, String> {

	ArrayList<Student> selectByName(String id);

}
