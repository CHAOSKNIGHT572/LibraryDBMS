package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Reader;

public class QueryReader {
	public static ResultSet readerFullInfo(Reader reader) {
		Connection conn;
		if ((conn = ConnectionBuilder.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		

		String sqlString = "";

		if (reader.getId() != null && reader.getName() != null && reader.getPhoneNum() != null) { 
			//Type in id, name and phone number, get full info about reader and borrow info.
			sqlString = "SELECT bor_transaction.ReaderId, ReaderName, PhoneNum, BorNumber, bor_transaction.DocId, CopyNo, Title, branch.Name, Location" + 
		", BorDateTime, RetDateTime, DueDate" + //SELECT
			 " FROM ((bor_transaction JOIN reader ON bor_transaction.readerId = reader.readerId)" + 
    			" JOIN document ON document.DocId = bor_transaction.DocId)" + 
        			" JOIN branch ON branch.LibId = bor_transaction.LibId" + //FROM
		" WHERE reader.ReaderId = " + reader.getId();//WHERE
		}
		else {
			sqlString = "SELECT * FROM reader";
		}

		System.out.println(sqlString);

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
	

	
	public static ResultSet readerBasicInfo(Reader reader) {
		Connection conn;
		if ((conn = ConnectionBuilder.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		
		String sel = "SELECT"; 
		String fm = " FROM reader";
		String where = " WHERE";
		String sqlString = "";
		if (reader.getId() == null && reader.getName() != null && reader.getPhoneNum() == null) { //Type in name, get phone# and reader id;
			sel += " ReaderId, Address, PhoneNum";
			where += " ReaderName = " + "'" + reader.getName() + "'";
			sqlString = sel + fm + where;
		}
		else if (reader.getId() == null && reader.getName() == null && reader.getPhoneNum() != null) { //Type in phone#, get name and reader id;
			sel += " ReaderId, ReaderName, Address";
			where += " PhoneNum = " + reader.getPhoneNum();
			sqlString = sel + fm + where;
		}
		else if (reader.getId() != null && reader.getName() == null && reader.getPhoneNum() == null){
			sel += " *";
			where += " ReaderId = " + reader.getId();
			sqlString = sel + fm + where;
		}
		else {
			sel += " *";
			sqlString = sel + fm;
		}
		
		
		
	/*	
		if (where.endsWith("AND") == true) {
			where = where.substring(0, where.length() - 4);
			QUERY_STR_2 = sel + fm + where;
		}
		*/
		System.out.println(sqlString);
/*
		try {
			ps = conn.prepareStatement(QUERY_STR_2);
			ps.setString(0, "sjdlfj");
			ps.setInt(1, 4);
			ResultSet rs = ps.executeQuery();

		} catch (SQLException e) {
			if (ps != null) {
				System.out.println(ps);
				System.out.println();
			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("No Connection Started");
		}
		*/
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sqlString);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		/*try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("No Connection Started");
		}
		*/
		return rs;
	}
	
	
	
//This is a test.
	public static void main(String[] args) {
		Reader reader = new Reader();
		reader.setId("3");
		reader.setName("RS");
//		reader.setType("");
//		reader.setAddress("");
		reader.setPhoneNum("3333333333");
//		
//		ResultSet rs = readerBasicInfo(reader);
		ResultSet rs = readerFullInfo(reader);
		try {
			while(rs.next()){
				for(int i = 1; i < 1; ++i){
					System.out.print(rs.getString(i));
					System.out.print(',');
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}