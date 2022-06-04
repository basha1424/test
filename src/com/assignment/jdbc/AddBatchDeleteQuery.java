package com.assignment.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBatchDeleteQuery {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String pwd="1424";
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		PreparedStatement pstmt=null;
		int n=0;
		System.out.println("how many records you update");
		 n=sc.nextInt();
		String q1="update students set  fname=?,lname=?,email=? where id=?";

		try {
			con = DriverManager.getConnection(url, user, pwd);
			 pstmt=con.prepareStatement(q1);
			 for(int i=1;i<=n;i++) {
				 System.out.println("enter id :"+i+" record id");
				 pstmt.setInt(4, sc.nextInt());
				 System.out.println("enter fname :"+i+" record fname");
				 pstmt.setString(1, sc.next());
				 System.out.println("enter lname :"+i+" record lname");
				 pstmt.setString(2,sc.next());
				 System.out.println("enter email :"+i+" record email");
				 pstmt.setString(3, sc.next());
				
				 pstmt.addBatch();
				 }
			 int[] executeBatch = pstmt.executeBatch();
			 for (int i : executeBatch) {
				 System.out.println(i);
				
			}
				System.out.println("how many rescords you want to delete");
				 n=sc.nextInt();
					String q2="delete from students where id=?";
					 pstmt=con.prepareStatement(q2);
					 for(int i=1;i<=n;i++) {
						 System.out.println("enter id :"+i+" record id");
						 pstmt.setInt(1, sc.nextInt());
						 pstmt.addBatch();
						 }
					 int[] executeBatch2 = pstmt.executeBatch();
					 for (int i : executeBatch2) {
						System.out.println(i);
					}
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}if(con!=null) {
					con.close();
				}
			} catch (Exception e2) {
			}
		}
	}
}