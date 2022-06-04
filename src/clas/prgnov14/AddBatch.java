package clas.prgnov14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class AddBatch {
	private static Connection con;
	private static Statement stm;

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String pwd="1424";
		String q1="insert into students values (12,'a','a1','a@gmail.com')";
		String q2="insert into students values (13,'b','b1','b@gmail.com')";
		String q3="insert int students values (14,'c','c1','c@gmail.com')";
		String q4="insert into students values (15,'d','d1','d@gmail.com')";
//		String q5="insert into students values (?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			con.setAutoCommit(false);
			stm = con.createStatement();
			stm.executeUpdate(q1);
			stm.executeUpdate(q2);
			stm.executeUpdate(q3);
			stm.executeUpdate(q4);
//			stm.executeLargeUpdate(q5);
			con.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stm!=null) {
					stm.close();
				}if(con!=null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
