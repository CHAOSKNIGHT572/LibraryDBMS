package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import control.Constant;
import jdbc.tool.ConnectionOperation;

public class UpdateBorrow {
	private static final String BORROW = "INSERT INTO bor_transaction (copy_no, doc_id, lib_id, reader_id, borrow_date_time) VALUES (?,?,?,?,?)";

	public static int borrow(String docId, String libId, String readerId) {
		String copyNo = QueryCopy.getAvailableCopy(docId, libId);
		if (copyNo == null) {
			return Constant.NO_AVAILABLE_DOCUMENT_COPY;
		}
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return Constant.UPDATE_FAILED;
		}
		PreparedStatement ps = null;
		int result = Constant.UPDATE_SUCCESSFUL;
		try {
			ps = conn.prepareStatement(BORROW);
			ps.setString(1, copyNo);
			ps.setString(2, docId);
			ps.setString(3, libId);
			ps.setString(4, readerId);
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ps.setString(5, format.format(new Date()));
			if (ps.executeUpdate() == 1) {
				
			} else {
				result = Constant.UPDATE_FAILED;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = Constant.UPDATE_FAILED;
		}
		ConnectionOperation.close(ps);
		return result;
	}
}
