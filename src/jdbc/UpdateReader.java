package jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.tool.ConnectionOperation;
import vo.Reader;


public class UpdateReader {
	//delete reader
	public static ResultSet deletereader(Reader reader) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		
		String sqlString = "DELETE FROM reader WHERE ReaderId = " + reader.getId();
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sqlString);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	//update address
		public static ResultSet updateReaderPh(Reader reader) {
			Connection conn;
			if ((conn = ConnectionOperation.getConnection()) == null) {
				return null;
			}
			PreparedStatement ps = null;
			
			String sqlString = "UPDATE reader SET PhoneNum = " + reader.getPhoneNum() + " WHERE ReaderId = " + reader.getId();
			ResultSet rs = null;
			try {
				ps = conn.prepareStatement(sqlString);
				rs = ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return rs;
		}
	//update address
	public static ResultSet updateReaderAdr(Reader reader) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		
		String sqlString = "UPDATE reader SET Address = " + reader.getAddress() + " WHERE ReaderId = " + reader.getId();
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sqlString);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	//update # of Reserved Books by readerId
	public static ResultSet updateReaderNRB(Reader reader) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		
		String sqlString = "UPDATE reader SET NumResBooks = " + reader.getResNum() + " WHERE ReaderId = " + reader.getId();
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sqlString);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	//update # of Borrowed Books by ReaderId
	public static ResultSet updateReaderNBB(Reader reader) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		
		String sqlString = "UPDATE reader SET NumBorBooks = " + reader.getBorNum() + " WHERE ReaderId = " + reader.getId();
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sqlString);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	//update ReaderName by readerId
	public static ResultSet updateReaderName(Reader reader) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		
		String sqlString = "UPDATE reader SET ReaderName = '" + reader.getName() + "' WHERE ReaderId = " + reader.getId();
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sqlString);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	
	public static ResultSet newreader(Reader reader) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		
		String sqlString = "INSERT INTO reader VALUES(?, ?, ?, ?, ?, ?)";
		
		
		
		System.out.println(sqlString);
		try {
			ps = conn.prepareStatement(sqlString);
			ps.setString(0, reader.getId());
			ps.setString(1, reader.getName());
			ps.setString(2, reader.getType());
			ps.setInt(3, reader.getBorNum());
			ps.setInt(4, reader.getResNum());
			ps.setString(5, reader.getPhoneNum());
			
		} catch (SQLException e) {
			if (ps != null) {
				System.out.println(ps);
				System.out.println();
			}
		}
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sqlString);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
}

