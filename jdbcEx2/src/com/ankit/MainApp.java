package com.ankit;

import java.sql.SQLException;

import com.ankit.entity.User;
import com.ankit.entity.UserService;

public class MainApp {

	public static void main(String[] args) {
		
		User obj1= new User(101,"Aditi","Abhaykumar","Upadhye",13,"Sangli");
		
		UserService uservice;
		try {
			uservice = new UserService();
			//uservice.saveUser(obj1);
			//uservice.updateUser(obj1);
			uservice.deleteUser(obj1);
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println("Exception is:"+e);
		}
		catch (SQLException e)
		{
			System.out.println("Exception is:"+e);	
		}

	}

}
