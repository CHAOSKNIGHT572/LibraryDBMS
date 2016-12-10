package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.tool.ConnectionOperation;
import vo.Author;

public class UpdateAuthor {
	private static final String NEW_AUTHOR = "INSERT INTO author (author_name) VALUES (?)";

	public static boolean newAuthor(Author author) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(NEW_AUTHOR);
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(conn);
			return false;
		}
		boolean result = true;
		try {
			ps.setString(1, author.getAuName());
			if (ps.executeUpdate() == 1) {
				String id = ConnectionOperation.getLastInsertIdForConnection(conn);
				if (id == null) {
					result = false;
				} else {
					author.setAuId(id);
				}
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

	public static void main(String[] args) {
		Author author = new Author();
		author.setAuName("2832");
		System.out.println(newAuthor(author));
		System.out.println(author.getAuId());
	}
}
