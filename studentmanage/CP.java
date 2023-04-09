package com.studentmanage;

import java.sql.Connection;
import java.sql.DriverManager;





public class CP {
	
	static Connection con;
	
	public static Connection createC ()
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/studenttable";
			String username = "root";
			String password ="Aniket@1234";
			con = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return con;
	}

}
