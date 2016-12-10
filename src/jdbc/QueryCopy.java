package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.tool.ConnectionOperation;

public class QueryCopy {
	private static final String GET_COPY_NUMBER_FOR_DOC_LIB = "SELECT COUNT(copy_no) FROM copy WHERE doc_id=? AND lib_id=?";

	public static int getCopyNumber(String docId, String libId) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return -1;
		}
		int result;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(GET_COPY_NUMBER_FOR_DOC_LIB);
			ps.setString(1, docId);
			ps.setString(2, libId);
			ResultSet rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				result = rs.getInt(1);
			} else {
				result = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = -1;
		}
		ConnectionOperation.close(ps);
		return result;
	}
}
