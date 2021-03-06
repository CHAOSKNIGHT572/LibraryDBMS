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
	private static final String GET_BORROW_FOR_READER = "SELECT copy_no, document.doc_id, title, borrow_date_time, "
			+ "DATE_ADD(borrow_date_time, INTERVAL 20 DAY) AS due_date, "
			+ "DATEDIFF(now(), DATE_ADD(borrow_date_time, INTERVAL 20 DAY)) * 30 AS fine "
			+ "FROM bor_transaction, document WHERE bor_transaction.doc_id=document.doc_id AND old=0 AND lib_id=? AND reader_id=?";
	private static final String GET_RESERVE_FOR_READER = "SELECT copy_no, document.doc_id, title, res_date_time FROM reservation, document "
			+ "WHERE reservation.doc_id=document.doc_id AND	lib_id=? AND reader_id=?";

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

	public static ResultSet getBorrowForReader(String libId, String readerId) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(GET_BORROW_FOR_READER);
			ps.setString(1, libId);
			ps.setString(2, readerId);
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(ps);
			return null;
		}
	}

	public static ResultSet getReserveForReader(String libId, String readerId) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(GET_RESERVE_FOR_READER);
			ps.setString(1, libId);
			ps.setString(2, readerId);
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(ps);
			return null;
		}
	}
}
