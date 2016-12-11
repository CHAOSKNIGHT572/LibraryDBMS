package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.tool.ConnectionOperation;

public class UpdateCopy {
	private static final String NEW_COPY = "INSERT INTO copy (copy_no, doc_id, lib_id, position) VALUES (?,?,?,?)";
	private static final String SET_BORROW_MARK = "UPDATE copy SET available = '0' WHERE copy_no = ? AND doc_id = ? AND lib_id = ?";

	public static boolean newCopy(String docId, String libId, String position) {
		int currentCopyNum = QueryCopy.getCopyNumber(docId, libId);
		if (currentCopyNum == -1) {
			currentCopyNum = 0;
		}
		++currentCopyNum;
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		PreparedStatement ps = null;
		boolean result = true;
		try {
			ps = conn.prepareStatement(NEW_COPY);
			ps.setInt(1, currentCopyNum);
			ps.setString(2, docId);
			ps.setString(3, libId);
			ps.setString(4, position);
			if (ps.executeUpdate() != -1) {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		ConnectionOperation.close(ps);
		return result;
	}

	public static boolean setBorrowMark(String docId, String libId, String copyNo) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		PreparedStatement ps = null;
		boolean result = true;
		try {
			ps = conn.prepareStatement(SET_BORROW_MARK);
			ps.setString(1, copyNo);
			ps.setString(2, docId);
			ps.setString(3, docId);
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
