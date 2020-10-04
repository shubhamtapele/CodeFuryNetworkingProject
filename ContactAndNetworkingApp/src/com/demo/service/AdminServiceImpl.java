package com.demo.service;

import java.util.List;

import com.demo.bean.User;
import com.demo.dao.AdminDao;
import com.demo.dao.AdminDaoImpl;

public class AdminServiceImpl implements AdminService{
	AdminDao adminDao=new AdminDaoImpl();
	@Override
	public void deleteSelectedUser(String[] username) {
		adminDao.deleteSelectedUser(username);
		
	}

	@Override
	public List<User> getByDisabledUser() {
		
		return adminDao.getByDisabledUser();
	}

	@Override
	public void disableSelectedUser(String[] username) {
		adminDao.disableSelectedUser(username);
		
	}

	@Override
	public List<User> getByUserToDisable() {
		return adminDao.getByUserToDisable();

	}

	@Override
	public List<String> getDisabledUserId() {
		return adminDao.getDisabledUserId();

	}

	@Override
	public void enableUser(String s) {
		adminDao.enableUser(s);
		
	}
/*
	@Override
	public List<String> getDisabledUserId() {
		return AdminDaoImpl.getDisabledUserId();
	}


	@Override
	public void enableUser(String s) {
		AdminDaoImpl.enableUser(s);
		
	}


	@Override
	public User getByUsername(String s) {
		// TODO Auto-generated method stub
		return AdminDao.getByUsername(s);
	}


	@Override
	public void deleteUser(User u) {
		AdminDao.deleteUser(u);
		
	}


	@Override
	public List<User> getByDisabledUser() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteUser(String s) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteSelectedUser(String[] username) {
		AdminDao.deleteSelectedUser(username);
		
	}


	@Override
	public List<User> getByUserToDisable() {
		return AdminDao.getByUserToDisable();
	}


	@Override
	public void disableSelectedUser(String[] username) {
		AdminDao.disableSelectedUser(username);
		
	}
*/
}
