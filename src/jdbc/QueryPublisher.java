package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.tool.ConnectionOperation;
import jdbc.tool.ResultSetOperation;

public class QueryPublisher {
	private static final String GET_PUBLISHER_BY_PARTIAL_NAME = "SELECT pub_id, pub_name FROM publisher WHERE pub_name LIKE ?";
	private static final String GET_PUBLISHER_BY_NAME = "SELECT pub_id, pub_name FROM publisher WHERE pub_name=?";

	public static ResultSet getPublisherByPartialName(String name) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(GET_PUBLISHER_BY_PARTIAL_NAME);
			name = "%" + name + "%";
			ps.setString(1, name);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	public static ResultSet getPublisherByName(String name) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(GET_PUBLISHER_BY_NAME);
			ps.setString(1, name);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	public static void main(String[] args) {
		ResultSetOperation.display(getPublisherByPartialName("123"), 2);
		ResultSetOperation.display(getPublisherByName("ab123ba"), 2);
	}
}
