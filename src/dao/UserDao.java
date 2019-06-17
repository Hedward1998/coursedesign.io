package dao;

import bean.User;

public interface UserDao extends GenericDao<User, String>{
	public String getName(String id);
	
}
