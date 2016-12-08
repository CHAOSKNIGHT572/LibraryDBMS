package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilder {
	public static Connection getConnection() {
		try {
			Class.forName(DBConstant.DRIVER_NAME);
			Connection conn = DriverManager.getConnection(
					DBConstant.PATH, DBConstant.USER, DBConstant.PASS);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("No Driver!");
		} catch (SQLException e) {
			System.out.println("Cannot connect to DBMS");
		}
		return null;
	}
}
