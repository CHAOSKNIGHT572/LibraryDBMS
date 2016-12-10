package jdbc.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionOperation {
	private static final String GET_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";

	public static Connection getConnection() {
		try {
			Class.forName(DBConstant.DRIVER_NAME);
			Connection conn = DriverManager.getConnection(DBConstant.PATH, DBConstant.USER, DBConstant.PASS);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("No Driver!");
		} catch (SQLException e) {
			System.out.println("Cannot connect to DBMS");
		}
		return null;
	}

	public static String getLastInsertIdForConnection(Connection conn) {
		try {
			PreparedStatement ps = conn.prepareStatement(GET_LAST_INSERT_ID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String lastInsertId = rs.getString(1);
				return lastInsertId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(ResultSet rs) {
		if (rs == null) {
			return;
		}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement ps) {
		if (ps == null) {
			return;
		}
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn) {
		if (conn == null) {
			return;
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
