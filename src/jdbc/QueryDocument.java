package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jdbc.tool.ConnectionOperation;
import vo.Author;
import vo.Document;

//[Query] regard to document

public class QueryDocument {
	private static final String GET_BOOK_BY_ISBN = "SELECT document.DocId, Title FROM document, book WHERE book.DocId = document.DocId AND ISBN = ?";
	private static final String GET_ISBN = "SELECT isbn FROM book WHERE isbn = ?";
	
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
		String selfm = "SELECT document.DocId, Title, Type, publisher.pubName, author.AName, PDate FROM document, publisher, author, writes";
		String where = " WHERE document.PublisherId = publisher.PublisherId AND document.DocId = writes.DocId AND writes.AuthorId = author.AuthorId";

		// if there is a publisher name
		if (doc.getPublisher() != null) {
			where += " AND PubName LIKE '%" + doc.getPublisher().getPubName() + "%'";
		}
		// if there is a list of authors
		if (doc.getAuthorList().size() != 0) {
			String authors = "";
			List<Author> authorslist = doc.getAuthorList();
			for (Author author : authorslist) {
				authors += "'" + author.getAuName() + "',";
			}
			where += " AND author.AName IN (" + authors.substring(0, authors.length() - 1) + ")";
		}
		// if there is a list of descriptor
		if (doc.getDescriptorList().size() != 0) {
			String descriptors = "";
			List<String> descriptorslist = doc.getDescriptorList();
			for (String descriptor : descriptorslist) {
				descriptors += "'" + descriptor + "',";
			}
			selfm += ", descriptor";
			where += " AND D_value IN (" + descriptors.substring(0, descriptors.length() - 1)
					+ ") AND document.DocId = descriptor.DocId";
		}
		// if there is a docid
		if (doc.getId() != null) {
			where += " AND DocId = " + doc.getId();
		}
		// if there is a title
		if (doc.getTitle() != null) {
			where += " AND Title = " + doc.getTitle();
		}
		// if there is a publisher date
		if (doc.getPubDate() != null) {
			where += " AND PDate = " + doc.getPubDate();
		}
		String sqlString = selfm + where;
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
}
