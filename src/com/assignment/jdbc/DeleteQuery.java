package com.assignment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery {
	private static Statement createStatement;
	private static Connection connection;
	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String pwd="1424";
		
		String q="delete from students where id=2";
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager.getConnection(url, user, pwd);
		 createStatement = connection.createStatement();
			int executeUpdate = createStatement.executeUpdate(q);
			
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