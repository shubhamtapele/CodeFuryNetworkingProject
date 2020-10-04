package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.bean.User;

public interface AdminDao {


/*
	List<String> getDisabledUserId(); 
	
	void enableUser(String s);
	
	List<User> findByDisableFlag() throws SQLException;

	void deleteUser(User u);

	User getByUsername(String s);

	void deleteSelectedUser(String[] username);

	void disableSelectedUser(String[] username);

	List<User> getByUserToDisable();
*/
	void deleteSelectedUser(String[] username);
	
	List<User> getByDisabledUser();

	void disableSelectedUser(String[] username);

	List<User> getByUserToDisable();

	void enableUser(String s);

	List<String> getDisabledUserId();

	void deleteUser(User u);

	User getByUsername(String s);

}
