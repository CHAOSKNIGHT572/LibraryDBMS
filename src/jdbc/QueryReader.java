package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.tool.ConnectionOperation;

public class QueryReader {
	private static final String GET_READER_BY_ID = "SELECT * FROM reader WHERE ReaderId = ?";
	private static final String GET_READER_BY_NAME = "SELECT ReaderId, Address, Phone FROM reader WHERE ReaderName LIKE ?";
	private static final String GET_READER_BY_PHONE = "SELECT ReaderId, Address, Phone FROM reader WHERE ReaderPhone = ?";

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
			name = "%" + name + "%";
			ps.setString(1, name);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static ResultSet getReaderByPhone(String phone) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(GET_READER_BY_PHONE);
			ps.setString(1, phone);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}