package com.assignment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class ResultsetMetaData {

	private static Statement createStatement;
	private static Connection connection;
	private static boolean execute;
	private static ResultSet resultSet;
	private static ResultSetMetaData metaData;

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
			metaData = resultSet.getMetaData();
			int n = metaData.getColumnCount();
			for(int i=1;i<=n;i++) {
				System.out.println(n);
			System.out.println(metaData.getColumnName(i));
			System.out.println(metaData.getColumnTypeName(i));
			System.out.println(metaData.getSchemaName(i));
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
