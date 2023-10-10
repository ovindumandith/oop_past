package Fuel.Util;

import java.sql.*;

public class DB {
	
	private static Connection connection;

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {

		if (connection == null || connection.isClosed()) {
			Class.forName("com.mysql.jdbc.Driver");// driver name using this driver we connect to database
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel", "root", "");//database link
		}
		
		return connection;
	}

}
