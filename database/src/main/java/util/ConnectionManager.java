package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
	private static String PASSWORD_KEY = "db.password";
	private static  String USERNAME_KEY = "db.username";
	private static String URL_KEY = "db.url";
	private ConnectionManager() {
		
	}
	public static Connection open() {
		try {
			return DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
					PropertiesUtil.get(USERNAME_KEY),
					PropertiesUtil.get(PASSWORD_KEY));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}static{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Class not founted");
		}
	}
	
}
