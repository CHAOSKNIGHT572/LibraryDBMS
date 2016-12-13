package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.tool.ConnectionOperation;

public class QueryReader {
	private static final String GET_READER_BY_ID = "SELECT * FROM reader WHERE reader_id = ?";
	private static final String GET_READER_BY_NAME = "SELECT reader_id, reader_name, phone FROM reader WHERE reader_name LIKE ?";

	public static ResultSet getReaderById(String readerId) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(GET_READER_BY_ID);
			ps.setString(1, readerId);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static ResultSet getReaderByName(String name) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(GET_READER_BY_NAME);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}