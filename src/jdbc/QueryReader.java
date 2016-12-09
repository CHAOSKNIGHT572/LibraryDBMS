package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Reader;

public class QueryReader {
	private static final String GET_READER_BY_ID = "SELECT * FROM reader WHERE ReaderId = ?";
	private static final String GET_READER_BY_NAME = "SELECT ReaderId, Address, Phone FROM reader WHERE ReaderName LIKE ?";
	private static final String GET_READER_BY_PHONE = "SELECT ReaderId, Address, Phone FROM reader WHERE ReaderPhone = ?";

	public static ResultSet getReaderById(String readerId) {
		Connection conn;
		if ((conn = ConnectionBuilder.getConnection()) == null) {
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
		if ((conn = ConnectionBuilder.getConnection()) == null) {
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
		if ((conn = ConnectionBuilder.getConnection()) == null) {
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

	// This is a test.
	public static void main(String[] args) {
		Reader reader = new Reader();
		reader.setId("3");
		reader.setName("RS");
		// reader.setType("");
		// reader.setAddress("");
		reader.setPhoneNum("3333333333");
		//
		// ResultSet rs = readerBasicInfo(reader);
		ResultSet rs = getReaderById("3");
		try {
			while (rs.next()) {
				for (int i = 1; i < 1; ++i) {
					System.out.print(rs.getString(i));
					System.out.print(',');
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}