package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import control.Constant;
import jdbc.tool.ConnectionOperation;

public class UpdateBorrow {
	private static final String BORROW = "INSERT INTO bor_transaction (copy_no, doc_id, lib_id, reader_id, borrow_date_time) VALUES (?,?,?,?,?)";
	private static final String RESERVE = "INSERT INTO reservation (copy_no, doc_id, lib_id, reader_id, res_date_time) VALUES (?,?,?,?,?)";
	private static final String RETURN_DOCUMENT = "UPDATE bor_transaction SET return_date_time = NOW(), old = '1' WHERE doc_id=? AND reader_id=? AND old = '0'";
	private static final String REMOVE_RESERVE = "DELETE FROM reservation WHERE doc_id=? AND reader_id=?";

	public static int borrow(String docId, String libId, String readerId) {
		int checkResult;
		if ((checkResult = basicCheck(docId, readerId)) != Constant.SUCCESSFUL) {
			return checkResult;
		}
		String copyNo = QueryCopy.getAvailableCopy(docId, libId);
		if (copyNo == null) {
			return Constant.NO_AVAILABLE_DOCUMENT_COPY;
		}
		return borrowSpecific(copyNo, docId, libId, readerId);
	}

	public static int reserve(String docId, String libId, String readerId) {
		int checkResult;
		if ((checkResult = basicCheck(docId, readerId)) != Constant.SUCCESSFUL) {
			return checkResult;
		}
		String copyNo = QueryCopy.getAvailableCopy(docId, libId);
		if (copyNo == null) {
			return Constant.NO_AVAILABLE_DOCUMENT_COPY;
		}
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return Constant.EXCEPTION;
		}
		PreparedStatement ps = null;
		int result = Constant.SUCCESSFUL;
		try {
			ps = conn.prepareStatement(RESERVE);
			ps.setString(1, copyNo);
			ps.setString(2, docId);
			ps.setString(3, libId);
			ps.setString(4, readerId);
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ps.setString(5, format.format(new Date()));
			if (ps.executeUpdate() == 1) {

			} else {
				result = Constant.EXCEPTION;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = Constant.EXCEPTION;
		}
		ConnectionOperation.close(ps);
		return result;
	}

	private static int basicCheck(String docId, String readerId) {
		ResultSet rs = QueryBorrow.getCountBorrowReserveForReader(readerId);
		if (rs == null) {
			return Constant.EXCEPTION;
		}
		int sum = 0;
		try {
			while (rs.next()) {
				sum += rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return Constant.EXCEPTION;
		}
		if (sum == 10) {
			return Constant.CHECK_COUNT_FAILED;
		}
		rs = QueryBorrow.getRepeatBorrowReserveForReader(docId, readerId);
		try {
			if (rs == null) {
				return Constant.EXCEPTION;
			} else if (rs.next()) {
				return Constant.CHECK_REPEAT_FAILED;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return Constant.EXCEPTION;
		}
		return Constant.SUCCESSFUL;
	}

	public static void main(String[] args) {
		System.out.println(basicCheck("1", "1"));
	}

	public static boolean returnDocument(String copyNo, String libId, String docId, String readerId) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		PreparedStatement ps = null;
		boolean result = false;
		try {
			ps = conn.prepareStatement(RETURN_DOCUMENT);
			ps.setString(1, docId);
			ps.setString(2, readerId);
			if (ps.executeUpdate() == 1) {
				if (UpdateCopy.changeBorrowMark("1", docId, libId, copyNo)) {
					result = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionOperation.close(ps);
		return result;
	}

	public static boolean borrowReservedDocument(String copyNo, String libId, String docId, String readerId) {
		if (borrowSpecific(copyNo, docId, libId, readerId) == Constant.SUCCESSFUL) {
			if (removeReserve(docId, readerId)) {
				return true;
			}
		}
		return false;
	}

	private static boolean removeReserve(String docId, String readerId) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		PreparedStatement ps = null;
		boolean result = false;
		try {
			ps = conn.prepareStatement(REMOVE_RESERVE);
			ps.setString(2, docId);
			ps.setString(4, readerId);
			if (ps.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionOperation.close(ps);
		return result;
	}

	private static int borrowSpecific(String copyNo, String docId, String libId, String readerId) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return Constant.EXCEPTION;
		}
		PreparedStatement ps = null;
		int result = Constant.SUCCESSFUL;
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
				result = Constant.EXCEPTION;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = Constant.EXCEPTION;
		}
		ConnectionOperation.close(ps);
		return result;
	}
}
