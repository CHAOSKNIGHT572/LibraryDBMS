package jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Copy;
import vo.Document;

public class updatedoc {
	//delete copy
			public static ResultSet deletecopy(Copy copy) {
				Connection conn;
				if ((conn = ConnectionBuilder.getConnection()) == null) {
					return null;
				}
				PreparedStatement ps = null;
				
				String sqlString = "DELETE FROM copy WHERE CopyNo = " + copy.getCpId();
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
	//delete doc
		public static ResultSet deletedoc(Document doc) {
			Connection conn;
			if ((conn = ConnectionBuilder.getConnection()) == null) {
				return null;
			}
			PreparedStatement ps = null;
			
			String sqlString = "DELETE FROM document WHERE DocId = " + doc.getId();
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
	
	//add new copy
	public static ResultSet newcopy(Copy copy) {
		Connection conn;
		if ((conn = ConnectionBuilder.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		String sqlString = "INSERT INTO copy VALUES(?, ?, ?, ?)";
		
		System.out.println(sqlString);
		try {
			ps = conn.prepareStatement(sqlString);
			ps.setString(0, copy.getCpId());
			ps.setString(1, copy.getDocument().getId());
			ps.setString(2, copy.getBranch().getId());
			//can't find getposition function in copy

			
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
		
	
	
	//add new doc
	public static ResultSet newdoc(Document doc) {
		Connection conn;
		if ((conn = ConnectionBuilder.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		
		String sqlString = "INSERT INTO document VALUES(?, ?, ?, ?, ?)";
		
		System.out.println(sqlString);
		try {
			ps = conn.prepareStatement(sqlString);
			ps.setString(0, doc.getId());
			ps.setString(1, doc.getTitle());
			ps.setString(3, doc.getPublisher().getPubId());
			ps.setString(4, doc.getPubDate());

			
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
