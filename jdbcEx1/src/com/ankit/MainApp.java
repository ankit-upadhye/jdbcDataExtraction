package com.ankit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ankit.config.dbConfig;

public class MainApp {

	static Connection conn;
	
	public static void main(String[] args) {
		
		try 
		{
			conn=dbConfig.connectmysql();
			
			if(conn==null)
			{
				System.out.println("Failed");
			}
			else
			{
				System.out.println("Connected");
			}
			
			String query ="Select empid,join_date,empname,salary,deptname From viewEpmloyee";
			
			Statement stmt= conn.createStatement();
			ResultSet R=stmt.executeQuery(query);
			
			while(true)
			{
				if(R.next()==false)
				{
					break;
				}
				else
				{
					System.out.println(String.format("%10d %20s %20s %10.2f %20s",
							R.getInt("empid"),
							R.getString("join_date"),
							R.getString("empname"),
							R.getFloat("salary"),
							R.getString("deptname")
							));
				}
			}
			
		}
		catch (ClassNotFoundException e) 
		{
			 System.out.println("Exception is"+e);
		}
		catch (SQLException e) 
		{
			System.out.println("Exception is"+e);
		}	

	}

}
