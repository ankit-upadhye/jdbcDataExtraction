package com.ankit.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class dbConfig {

	public static  Connection connectMySql() throws ClassNotFoundException, SQLException
	{
		TimeZone timeZone=TimeZone.getTimeZone("Asia/Kolkata");
		TimeZone.setDefault(timeZone);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javafullstack?useUnicode=true&useJDBCComplaintTimeZoneShift=true&useLegacyDatetimeCode=flase&serverTimezone=UTC","root","");
		return conn;
	}
}
