package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.tool.ConnectionOperation;
import jdbc.tool.ResultSetOperation;

public class QueryAuthor {
	private static final String GET_AUTHOR_BY_NAME = "SELECT * FROM author WHERE author_name=?";
	private static final String GET_AUTHOR_BY_PARTIAL_NAME = "SELECT * FROM author WHERE author_name LIKE ?";

	public static ResultSet getAuthorByName(String name) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(GET_AUTHOR_BY_NAME);
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(conn);
			return null;
		}
		try {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(ps);
			return null;
		}
	}

	public static ResultSet getAuthorByPartialName(String name) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(GET_AUTHOR_BY_PARTIAL_NAME);
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(conn);
			return null;
		}
		try {
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(ps);
			return null;
		}
	}

	public static void main(String[] args) {
		ResultSetOperation.display(getAuthorByName("2232"), 2);
		ResultSetOperation.display(getAuthorByPartialName("2"), 2);
	}
}
