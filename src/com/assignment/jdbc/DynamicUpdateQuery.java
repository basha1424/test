package com.assignment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicUpdateQuery {
	private static Connection connection;
	private static Statement createStatement;
	public static void main(String[]args) {
		
			String url="jdbc:mysql://localhost:3306/student";
			String user="root";
			String pwd="1424";
			Scanner sc=new Scanner(System.in);
			System.out.println("enter id");
			int id = sc.nextInt();
			System.out.println("enter fname");
			 String fname = sc.next();
				System.out.println("enter lname");
				 String lname = sc.next();
				 System.out.println("enter email"); 
				 String email = sc.next();
String q="update students set id="+id+ ","+" fname="+"'"+fname+"' ,"+"lname="+"'"+lname+"',"+"email="+"'"+email+"'where id ="+id;
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
