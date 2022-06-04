package com.assignment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.sql.Statement;

public class ExecuteTrue {
	private static Statement createStatement;
	private static Connection connection;
	private static boolean execute ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String pwd="1424";
		
		String q="select * from students";
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager.getConnection(url, user, pwd);
		 createStatement = connection.createStatement();
			boolean execute  = createStatement.execute(q);
			System.out.println(execute);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(createStatement!=null) {
					createStatement.close();
				}
				if( connection!=null) {
					 connection.close();
				}
			} catch (Exception e2) {
			
			}
		}
	}
}