package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import control.Constant;
import jdbc.tool.ConnectionOperation;
import vo.Author;
import vo.Book;
import vo.Document;
import vo.Publisher;

public class UpdateDocument {
	private static final String NEW_DOCUMENT = "INSERT INTO `document` (`title`, `type`, `pub_id`, `pub_date`) VALUES (?,?,?,?)";
	private static final String NEW_BOOK = "INSERT INTO book (doc_id, isbn) VALUES (?,?)";

	public static boolean newBook(Book book) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		if (!newDocument(conn, book, Constant.BOOK_TYPE_NO)) {
			ConnectionOperation.close(conn);
			return false;
		}

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(NEW_BOOK);
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(conn);
			return false;
		}
		boolean result = true;
		try {
			ps.setString(1, book.getId());
			ps.setString(2, book.getIsbn());
			if (ps.executeUpdate() != 1) {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(ps);
			return false;
		}
		return result;
	}

	private static boolean newDocument(Connection conn, Document doc, int typeNo) {
		try {
			Publisher publisher = doc.getPublisher();
			ResultSet rs = QueryPublisher.getPublisherByName(publisher.getPubName());
			if (rs.next()) {
				publisher.setPubId(rs.getString(1));
			} else {
				UpdatePublisher.newPublisher(publisher);
			}
			PreparedStatement ps = conn.prepareStatement(NEW_DOCUMENT);
			ps.setString(1, doc.getTitle());
			ps.setInt(2, typeNo);
			ps.setString(3, publisher.getPubId());
			ps.setString(4, doc.getPubDate());
			int result = ps.executeUpdate();
			if (result == 1) {
				String id = ConnectionOperation.getLastInsertIdForConnection(conn);
				if (id == null) {
					return false;
				} else {
					doc.setId(id);
				}
			} else {
				return false;
			}
			if (!UpdateWrite.newWriteRelatonship(doc.getId(), doc.getAuthorList())) {
				return false;
			}
			if (!UpdateDescriptor.newDescriptorForDoc(doc.getId(), doc.getDescriptorList())) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Publisher publisher = new Publisher();
		publisher.setPubName("123");

		Book book = new Book();
		book.setTitle("book1");
		book.setPublisher(publisher);
		book.setPubDate("2012-2-2");
		book.setIsbn("12123");

		Author author = new Author();
		author.setAuName("Author1");
		book.addAuthor(author);
		author = new Author();
		author.setAuName("Author2");
		book.addAuthor(author);

		book.addDescriptor("Des1");
		book.addDescriptor("Des2");

		System.out.println(newBook(book));
		System.out.println(book.getId());
		System.out.println(book.getPublisher().getPubId());
	}
}
