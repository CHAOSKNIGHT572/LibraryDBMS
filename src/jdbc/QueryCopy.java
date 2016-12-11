package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.tool.ConnectionOperation;

public class QueryCopy {
	private static final String GET_COPY_NUMBER_FOR_DOC_LIB = "SELECT COUNT(copy_no) FROM copy WHERE doc_id=? AND lib_id=?";
	private static final String GET_AVAILABLE_COPY = "SELECT copy_no FROM copy WHERE doc_id=? AND lib_id=? AND available=1";

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

	public static String getAvailableCopy(String docId, String libId) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		String result = null;
		try {
			ps = conn.prepareStatement(GET_AVAILABLE_COPY);
			ps.setString(1, docId);
			ps.setString(2, libId);
			ResultSet rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				String copyNo = rs.getString(1);
				if (copyNo != null) {
					if (UpdateCopy.setBorrowMark(docId, libId, copyNo)) {
						result = copyNo;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionOperation.close(ps);
		return result;
	}
}
