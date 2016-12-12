package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.tool.ConnectionOperation;

public class QueryBorrow {
	private static final String GET_COUNT_BORROW_RESERVE_FOR_READER = "SELECT COUNT(reserve_id) FROM reservation WHERE reader_id=? "
			+ "UNION SELECT COUNT(borrow_id) FROM bor_transaction WHERE reader_id=?";
	private static final String GET_REPEAT_BORROW_RESERVE_FOR_READER = "SELECT borrow_id FROM bor_transaction WHERE doc_id=? AND reader_id=? AND old=0 "
			+ "UNION SELECT reserve_id FROM reservation WHERE doc_id=? AND reader_id=?";

	public static ResultSet getCountBorrowReserveForReader(String readerId) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(GET_COUNT_BORROW_RESERVE_FOR_READER);
			ps.setString(1, readerId);
			ps.setString(2, readerId);
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(ps);
			return null;
		}
	}

	public static ResultSet getRepeatBorrowReserveForReader(String docId, String readerId) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(GET_REPEAT_BORROW_RESERVE_FOR_READER);
			ps.setString(1, docId);
			ps.setString(2, readerId);
			ps.setString(3, docId);
			ps.setString(4, readerId);
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(ps);
			return null;
		}
	}
}
