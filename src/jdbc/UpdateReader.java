package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.tool.ConnectionOperation;
import vo.Reader;

public class UpdateReader {
	private static final String NEW_READER = "INSERT INTO reader (reader_name, type, address, phone) VALUES (?,?,?,?)";
	private static final String UPDATE = "UPDATE reader SET reader_name=?, type=?, address=?, phone=? WHERE reader_id=?";

	public static boolean newReader(Reader reader) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		PreparedStatement ps = null;
		boolean result = true;
		try {
			ps = conn.prepareStatement(NEW_READER);
			ps.setString(1, reader.getName());
			ps.setString(2, reader.getType());
			ps.setString(3, reader.getAddress());
			ps.setString(4, reader.getPhoneNum());
			if (ps.executeUpdate() == 1) {
				String id = ConnectionOperation.getLastInsertIdForConnection(conn);
				if (id == null) {
					result = false;
				} else {
					reader.setId(id);
				}
			} else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		ConnectionOperation.close(ps);
		return result;
	}

	public static boolean update(Reader reader) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		PreparedStatement ps = null;
		boolean result = false;
		try {
			ps = conn.prepareStatement(UPDATE);
			ps.setString(1, reader.getName());
			ps.setString(2, reader.getType());
			ps.setString(3, reader.getAddress());
			ps.setString(4, reader.getPhoneNum());
			ps.setString(5, reader.getId());
			if (ps.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionOperation.close(conn);
		return result;
	}
}
