package com.assignment.jdbc;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;
public class PrepareStatementInsert {
	private static Connection connection;
	private static java.sql.PreparedStatement prepareStatement;
	private static ResultSet executeQuery;
	private static int nextInt;
	public static void main(String[] args) {
			String url="jdbc:mysql://localhost:3306/student";
			String user="root";
			String pwd="1424";
			String q="insert into students values (?,?,?,?)";
			Scanner sc=new Scanner(System.in);
			System.out.println("enter no of records");
			int n = sc.nextInt();
			try {
//				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, pwd);
				prepareStatement= connection.prepareStatement(q);
		
				for (int i=1;i<=n;i++) {
					System.out.println("enter "+i+"record id");
					prepareStatement.setInt(1, sc.nextInt());	
					System.out.println("enter "+i+"record fname");
					prepareStatement.setString(2, sc.next());
					System.out.println("enter "+i+"record lname");
					prepareStatement.setString(3, sc.next());
					System.out.println("enter "+i+"record email");
					prepareStatement.setString(4, sc.next());
					prepareStatement.executeUpdate();
					System.out.println("no of rows affected"+n);
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}finally {
				try {
					if(prepareStatement!=null) {
						prepareStatement.close();
					}
				}catch(SQLException e){
					
				}
			}
	}
}