package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import jdbc.QueryBorrow;
import jdbc.QueryReader;
import jdbc.UpdateBorrow;
import jdbc.UpdateReader;
import jdbc.tool.ConnectionOperation;
import vo.Reader;

public class ReaderControl {
	public static boolean newReader(Reader reader) {
		return UpdateReader.newReader(reader);
	}

	public static int borrow(String docId, String libId, String readerId) {
		return UpdateBorrow.borrow(docId, libId, readerId);
	}

	public static int reserve(String docId, String libId, String readerId) {
		return UpdateBorrow.reserve(docId, libId, readerId);
	}

	public static Reader getReaderById(String id) {
		ResultSet rs = QueryReader.getReaderById(id);
		if (rs == null) {
			return null;
		}
		try {
			if (rs.next()) {
				Reader reader = new Reader();
				reader.setId(rs.getString(1));
				reader.setName(rs.getString(2));
				reader.setAddress(rs.getString(4));
				reader.setPhoneNum(rs.getString(5));
				return reader;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Reader> getReaderByName(String name) {
		ResultSet rs = QueryReader.getReaderByName(name);
		List<Reader> list = new LinkedList<>();
		if (rs != null) {
			try {
				while (rs.next()) {
					Reader reader = new Reader();
					reader.setId(rs.getString(1));
					reader.setName(rs.getString(2));
					reader.setPhoneNum(rs.getString(3));
					list.add(reader);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		ConnectionOperation.close(rs);
		return list;
	}

	public static boolean updateInfo(Reader reader) {
		return UpdateReader.update(reader);
	}

	public static List<String[]> getBorrowedDocuments(String libId, String readerId) {
		ResultSet rs = QueryBorrow.getBorrowForReader(libId, readerId);
		List<String[]> list = new LinkedList<>();
		if (rs == null) {
			return null;
		}
		try {
			String[] rowData;
			while (rs.next()) {
				rowData = new String[6];
				for (int i = 0; i < 5; ++i) {
					rowData[i] = rs.getString(i + 1);
				}
				int fine = rs.getInt(6);
				if (fine <= 0) {
					rowData[5] = "0";
				} else {
					rowData[5] = "$" + fine / 100 + "." + fine % 100;
				}
				list.add(rowData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean returnDocument(String copyNo, String libId, String docId, String readerId) {
		return UpdateBorrow.returnDocument(copyNo, libId, docId, readerId);
	}

	public static List<String[]> getReservedDocuments(String libId, String readerId) {
		ResultSet rs = QueryBorrow.getReserveForReader(libId, readerId);
		List<String[]> list = new LinkedList<>();
		if (rs == null) {
			return null;
		}
		try {
			String[] rowData;
			while (rs.next()) {
				rowData = new String[4];
				for (int i = 0; i < 4; ++i) {
					rowData[i] = rs.getString(i + 1);
				}
				list.add(rowData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean borrowReservedDocument(String copyNo, String libId, String docId, String readerId) {
		return UpdateBorrow.borrowReservedDocument(copyNo, libId, docId, readerId);
	}
}
