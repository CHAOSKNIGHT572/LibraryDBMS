package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import jdbc.QueryReader;
import jdbc.UpdateBorrow;
import jdbc.UpdateReader;
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
		return list;
	}

	public static boolean updateInfo(Reader reader) {
		// TODO Auto-generated method stub
		return false;
	}
}
