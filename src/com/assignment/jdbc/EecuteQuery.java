package com.assignment.jdbc;
import java.sql.*;
public class EecuteQuery {

	public static void main(String[] args) {

		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String pwd="1424";
		Connection con=null;
		Statement stm=null;
		ResultSet rst=null;
		String q="select * from students";
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(url, user, pwd);
				stm = con.createStatement();
			    rst= stm.executeQuery(q);
			    while (rst.next()) {
					System.out.println(rst.getInt(1));
					System.out.println(rst.getString(2));
					System.out.println(rst.getString(3));
					System.out.println(rst.getString(4));
				}
				
			} catch (SQLException |ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(rst!=null) {
						rst.close();
					}
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
