package com.demo.service;

import java.util.List;

import com.demo.bean.User;

public interface AdminService {

	
/*
	List<User> getByDisabledUser();

	void enableUser(String s);

	List<String> getDisabledUserId();

	User getByUsername(String s);

	void deleteUser(String s);

	void deleteSelectedUser(String[] username);

	List<User> getByUserToDisable();

	void disableSelectedUser(String[] username);
*/

	void deleteSelectedUser(String[] username);
	
	List<User> getByDisabledUser();

	void disableSelectedUser(String[] username);

	List<User> getByUserToDisable();

	List<String> getDisabledUserId();

	void enableUser(String s);

}
