package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.tool.ConnectionOperation;
import vo.Author;

public class UpdateWrite {
	private static final String NEW_WRITE_RELATIONSHIP = "INSERT INTO `write` (doc_id, author_id) VALUES (?,?)";

	public static boolean newWriteRelatonship(String docId, List<Author> authorList) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(NEW_WRITE_RELATIONSHIP);
			ps.setString(1, docId);
		} catch (SQLException e1) {
			e1.printStackTrace();
			ConnectionOperation.close(conn);
			return false;
		}
		boolean result = true;
		for (Author author : authorList) {
			ResultSet rs = QueryAuthor.getAuthorByName(author.getAuName());
			try {
				if (rs != null && rs.next()) {
					author.setAuId(rs.getString(1));
				} else {
					UpdateAuthor.newAuthor(author);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				ConnectionOperation.close(rs);
				return false;
			}
			try {
				ps.setString(2, author.getAuId());
				if (ps.executeUpdate() != 1) {
					result = false;
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				result = false;
				break;
			}
		}
		ConnectionOperation.close(ps);
		return result;
	}

	public static void main(String[] args) {
		List<Author> authorList = new ArrayList<>();
		Author author = new Author();
		author.setAuName("aaaa");
		authorList.add(author);
		author = new Author();
		author.setAuName("bbbb");
		authorList.add(author);
		System.out.println(newWriteRelatonship("4", authorList));
	}
}
