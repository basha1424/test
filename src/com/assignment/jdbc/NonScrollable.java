package com.assignment.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class NonScrollable {
	private static Statement createStatement;
	private static Connection connection;
	private static boolean execute;
	private static ResultSet resultSet;

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/student";
		String user = "root";
		String pwd = "1424";

		String q = "select * from students";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pwd);
			createStatement = connection.createStatement();
			boolean execute = createStatement.execute(q);
			System.out.println(execute);
			resultSet = createStatement.getResultSet();
			resultSet.afterLast();
			while (resultSet.previous()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (createStatement != null) {
					createStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {

			}
		}
	}
}
