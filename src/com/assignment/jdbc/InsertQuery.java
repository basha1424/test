package com.assignment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String pwd="1424";
		Connection con=null;
		Statement stm=null;
		int i=0;
		String q="insert into students values (1,'basha','shaik','shaik@gmail.com')";
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(url, user, pwd);
				stm = con.createStatement();
			    i=stm.executeUpdate(q);
			    System.out.println("executed");
			  
			} catch (SQLException |ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				try {
					
					if(stm!=null) {
						stm.close();
					}
					if(con!=null) {
						con.close();
					}
					
				} catch (SQLException e2) {
				
				}
			}
	}

}