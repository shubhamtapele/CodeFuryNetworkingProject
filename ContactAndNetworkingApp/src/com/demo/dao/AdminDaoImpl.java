package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.bean.User;

public class AdminDaoImpl implements AdminDao{	
	
	static Connection conn;
	static PreparedStatement pgetdisableusers, pgetnotdisableusers, pgetbyusername, pdeleteuser, pgetuserbyuname, pgetalluser, premovebyuid, pgetblockedcount, pgetblockedtableuser;
	static int enableFlag=0;
	static int disableFlag=1;
	static {
		conn=DBUtil.getMyConnection();
		try {
			pgetdisableusers=conn.prepareStatement("select* from disable user");
			pgetnotdisableusers=conn.prepareStatement("select* from user details where disableflag=0");
			pgetbyusername=conn.prepareStatement("select * from user details where uname=? ");
			pdeleteuser=conn.prepareStatement("delete from user details where uname=? ");
			pgetuserbyuname=conn.prepareStatement("select uid from user details where uname=?");
			premovebyuid=conn.prepareStatement("remove from user details where uid=?");
			pgetblockedcount=conn.prepareStatement("select count(uemail) from blocked by friend list where uid=?");
			pgetblockedtableuser=conn.prepareStatement("select uname, uid from user details where uid in (select uid from Blocked By Friend List GROUP BY uid having count(uid)>=3);");
			pgetalluser=conn.prepareStatement("select * from user details");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
/*
	@Override
	public List<User> findNonDisabledUser() {
		ResultSet rs=pgetnotdisableusers.executeQuery();        
		List<User> ulist=new ArrayList<>();
		while(rs.next()) { 
			User u=new User(rs.getString(1), null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null);
			ulist.add(u);
		}
		return ulist;
	}

	@Override
	public List<User> findByDisableFlag() throws SQLException {
		ResultSet rs=pgetnotdisableusers.executeQuery();
		List<User> ulist=new ArrayList<>();
		while(rs.next()) {  //Add condition to check disable flag to 1;
			User u=new User();//Getter Methods of Get ID and Username need to be added in User(------)
			ulist.add(u);
		}
		return ulist;
	}
*/
	@Override
	public List<User> getByDisabledUser() {
		List<User> ulist=new ArrayList<>();
		
		ResultSet rs;
		try {
			rs = pgetdisableusers.executeQuery();
			while(rs.next()) {  //Add condition to check disable flag to 1;
			User u=new User();//Getter Methods of Get ID and Username need to be added in User(------)
			ulist.add(u);
			} 
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ulist;
	}

	public List<String> getDisabledUserId() {
		ResultSet rs;
		List<String> ulist=new ArrayList<>();
		try {
			rs = pgetdisableusers.executeQuery();
			while(rs.next()) {  
				
				ulist.add(rs.getString(17));//Add condition to check disable flag to 1;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ulist;
	}


	private User findByUsername(String s) {
		try { 
			pgetbyusername.setString(1, s);
			ResultSet rs=pgetbyusername.executeQuery();
			//List<User> pList=new ArrayList<>();
			User p=null;
			while(rs.next())
			{
			      p=new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), null, rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), null, 0, rs.getString(15), rs.getString(16));
				
			}
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override


	public void enableUser(String s) {
		User u=findByUsername(s);
		u.setDisableFlag(enableFlag);
	}
	
	public void disableUser(String s) {
		User u=findByUsername(s);
		u.setDisableFlag(disableFlag);
	}



	public int getUserByUname(String uname) {
		try {
			pgetuserbyuname.setString(1, uname);
			ResultSet rs = pgetuserbyuname.executeQuery();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;	
	}

	@Override
	public void deleteUser(User u) {
		try { 
			pdeleteuser.setString(1, u.getUemail());
			pdeleteuser.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	@Override
	public User getByUsername(String s) {
		try { 
			pgetbyusername.setString(1, s);
			ResultSet rs=pgetbyusername.executeQuery();
			List<User> pList=new ArrayList<>();
			User p=null;
			while(rs.next())
			{
				p=new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), null, rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), null, 0, rs.getString(15), rs.getString(16));
				
			}
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> getAllUser() {
		try { 
			ResultSet rs=pgetalluser.executeQuery();
			List<User> pList=new ArrayList<>();
			User p=null;
			while(rs.next())
			{
			      p=new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), null, rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), null, 0, rs.getString(15), rs.getString(16));
			      pList.add(p);
			}
			return pList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteSelectedUser(String[] username) {
		for(String s:username) {
			int uid=getUserByUname(s);
			try {
				premovebyuid.setInt(1, uid);
				premovebyuid.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void disableSelectedUser(String[] username) {
		for(String s:username) {
			int uid=getUserByUname(s);
			try {
				int count;
				pgetblockedcount.setInt(1, uid);
				count=pgetblockedcount.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

	@Override
	public List<User> getByUserToDisable() {	
		try {
			ResultSet rs=pgetblockedtableuser.executeQuery();
			List<User> dlist=new ArrayList<>();
			while(rs.next()) {
				dlist.add((User) rs);
			}
			return dlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}



}	