package com.assignment.jdbc;
import java.sql.*;
import java.util.Scanner;
public class PreparedStatement {
	private static Connection con;
	private static java.sql.PreparedStatement prstmt;
	private static ResultSet rst;
	private static java.sql.PreparedStatement pstmt;
	private static boolean e;
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String pwd="1424";
		Scanner sc=new Scanner(System.in);
//		System.out.println("enter Email");
//		String email = sc.next();
		String q="select * from students where email like ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pwd);
				pstmt = con.prepareStatement(q);
				System.out.println("enter Email");

			pstmt.setString(1,"%"+ sc.next());
			ResultSet rst = pstmt.executeQuery();
//			e = pstmt.execute();
//			System.out.println();
//				rst = prstmt.getResultSet();
				while(rst.next()) {
					System.out.println(rst.getInt(1));
					System.out.println(rst.getString(2)+rst.getString(3));
					System.out.println(rst.getString(4));
		}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			   try {
			if(rst!=null) {
				  rst.close();
				   }
				   if(prstmt!=null) {
					   prstmt.close();
				   }if(con!=null) {
					   con.close();
				   }
				   }catch (SQLException e) {
				e.printStackTrace();
				}
		}
	}
}