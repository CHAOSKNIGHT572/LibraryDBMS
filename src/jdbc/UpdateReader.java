package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.tool.ConnectionOperation;
import vo.Reader;

public class UpdateReader {
	private static final String NEW_READER = "INSERT INTO reader (reader_name, type, address, phone) VALUES (?,?,?,?)";

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
}
