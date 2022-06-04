package com.assignment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateQuery {

	private static Statement createStatement;
	private static Connection connection;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String pwd="1424";
		
		String q="update students set  fname='basha12', lname='shaik12', email='shaik12@gmail.com' where id=8";
	
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
				// TODO: handle exception
			}
		}
	}
}