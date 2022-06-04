package com.assignment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicSelectQuery {

	private static Connection connection;
	private static Statement createStatement;
	private static ResultSet executeQuery3;

	public static void main(String[] args) {
	
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="1424";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id what you want");
		 int id = sc.nextInt();
		String q="select * from students where id="+id;
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			createStatement = connection.createStatement();
			  executeQuery3 = createStatement.executeQuery(q);
			 while(executeQuery3.next()) {
				 System.out.println("id : "+executeQuery3.getInt(1));
				 System.out.println("fname : "+executeQuery3.getString(2));
				 System.out.println("lname : "+executeQuery3.getString(3));
				 System.out.println("email : "+executeQuery3.getString(4));
			 }
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(createStatement!=null) {
					createStatement.close();
				}if(connection !=null) {
					connection.close();
				}
			} catch (Exception e2) {
			}
		}
	}
}