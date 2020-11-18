package com.ankit.entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.ankit.config.dbConfig;

public class UserService {

	private Connection conn;

	public UserService() throws ClassNotFoundException, SQLException
	{
		conn=dbConfig.connectMySql();
	}
	
	public void saveUser(User user) throws SQLException
	{
		String query=String.format("Insert Into UserData(userid,fname,mname,lname,age,city) Values(%d,'%s','%s','%s',%d,'%s')",
				user.getUserid(),
				user.getFname(),
				user.getMname(),
				user.getLname(),
				user.getAge(),
				user.getCity());
		
		Statement stmt = conn.createStatement();
		stmt.execute(query);
		System.out.println("Saved Successfully");
	}
	
	public void updateUser(User user) throws SQLException
	{
		String query=String.format("Update UserData set fname='%s',mname='%s',lname='%s',age=%d,city='%s' where userid=%d",
				user.getFname(),
				user.getMname(),
				user.getLname(),
				user.getAge(),
				user.getCity(),
				user.getUserid());
		
		Statement stmt = conn.createStatement();
		stmt.execute(query);
		System.out.println("Updated Successfully");
	}
	
	public void deleteUser(User user) throws SQLException
	{
		String query=String.format("Delete from UserData where userid=%d",
				user.getUserid());
		
		Statement stmt = conn.createStatement();
		stmt.execute(query);
		System.out.println("Deleted Successfully");
	}
	
}
