package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.tool.ConnectionOperation;
import vo.Document;

//[Query] regard to document

public class QueryDocument {
	private static final String GET_BOOK_BY_ISBN = "SELECT document.DocId, Title FROM document, book WHERE book.DocId = document.DocId AND ISBN = ?";
	private static final String GET_ISBN = "SELECT isbn FROM book WHERE isbn = ?";
	private static final String GET_DOCUMENT_BY_PARTIAL_TITLE = "SELECT doc_id, title, type FROM document WHERE title LIKE ?";

	// get docid by type in isbn
	public static ResultSet getBookByISBN(String isbn) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(GET_BOOK_BY_ISBN);
			ps.setString(1, isbn);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}

	public static ResultSet getISBN(String isbn) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(GET_ISBN);
			ps.setString(1, isbn);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}

	// Get detailed document info
	public static ResultSet getDocumentByMultiCondition(Document doc) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		String selfm = "SELECT DISTINCT document.`type`, document.doc_id, document.title, publisher.pub_name FROM publisher, document";
		String where = " WHERE publisher.pub_id = document.pub_id";

		// if there is a publisher name
		if (doc.getPublisher() != null) {
			where += " AND pub_name LIKE '%" + doc.getPublisher().getPubName() + "%'";
		}
		// if there is a list of authors
		if (!doc.getAuthorList().isEmpty()) {
			String authorName = doc.getAuthorList().get(0).getAuName();
			selfm += ", `write`, author";
			where += " AND document.doc_id=`write`.doc_id AND `write`.author_id=author.author_id AND author.author_name LIKE '%"
					+ authorName + "%'";
		}
		// if there is a list of descriptor
		if (!doc.getDescriptorList().isEmpty()) {
			String descriptor = doc.getDescriptorList().get(0);
			selfm += ", descriptor";
			where += " AND document.doc_id = descriptor.doc_id AND descriptor_value LIKE '%" + descriptor + "%'";
		}
		// if there is a title
		if (doc.getTitle() != null) {
			where += " AND title LIKE '%" + doc.getTitle() + "%'";
		}
		String sqlString = selfm + where;
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

	public static ResultSet getDocumentByPartialTitle(String partTitle) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(GET_DOCUMENT_BY_PARTIAL_TITLE);
			ps.setString(1, "%" + partTitle + "%");
			rs = ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(ps);
			return null;
		}
	}
}
