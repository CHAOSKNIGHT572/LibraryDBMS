package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import vo.Author;
import vo.Document;
import vo.Publisher;
import vo.Book;

//[Query] regard to document

public class DocumentInfo {

	//get docid by type in isbn
	public static ResultSet getBookInfo(Book book) {
			Connection conn;
			if ((conn = ConnectionBuilder.getConnection()) == null) {
				return null;
			}
			PreparedStatement ps = null;
			String sqlString = "";
			if (book.getIsbn() != null) {
				sqlString = "SELECT document.DocId, Title FROM document, book WHERE book.DocId = document.DocId AND ISBN = " + book.getIsbn();
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
	
	// get where documents are available by type in DocId
	public static ResultSet getDocWhere(Document doc) {
		Connection conn;
		if ((conn = ConnectionBuilder.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		
		String sqlString = "";
		if (doc.getId() != null) {
		sqlString = "SELECT Title, copy.DocId, CopyNo, copy. Position, branch.Name, branch.Location" + 
		" FROM (document JOIN copy ON document.DocId = copy.DocId) JOIN branch ON branch.LibId = copy.LibId WHERE document.DocId = 1" + 
		" WHERE document.DocId = " + doc.getId();
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
	
	
	
//Get detailed document info
	public static ResultSet getDocInfo(Document doc) {
		Connection conn;
		if ((conn = ConnectionBuilder.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		///**/
		String selfm = "SELECT document.DocId, Title, Type, publisher.pubName, author.AName, PDate FROM document";
		String where = " WHERE";
		
		if (doc.getPublisher() != null) { //if there is a publisher name

			selfm += ", publisher";
			where += " document.PublisherId = publisher.PublisherId AND publisher.PubName LIKE '%"
					+ doc.getPublisher().getPubName() + "'% AND";
		}

		if (doc.getAuthorList().size() != 0) { // if there is a list of authors
			String authors = "";
			List<Author> authorslist = doc.getAuthorList();
			for (Author author : authorslist) {
				authors += "'" + author.getAuName() + "',";
			}
			String authorswoc = authors.substring(0, authors.length() - 1);

			selfm += ", author, writes";
			where += " author.AName IN (" + authorswoc + ") AND document.DocId = writes.DocId"
					+ " AND writes.AuthorId = author.AuthorId AND";

		}
		if (doc.getDescriptorList().size() != 0) { //if there is a list of descriptor
			String descriptors = "";
			List<String> descriptorslist = doc.getDescriptorList();
			for (String descriptor : descriptorslist) {
				descriptors += descriptor;
			}
			selfm += ", descriptor";
			where += " D_value IN (" + descriptors + ") AND document.DocId = descriptor.DocId";
		}
		if (doc.getId() != null) { //if there is a docid
			where += " DocId = " + doc.getId() + " AND";
		}
		if (doc.getTitle() != null) { //if there is a title
			where += " Title = " + doc.getTitle() + " AND";
		}
		if (doc.getPubDate() != null) { //if there is a publisher date
			where += " PDate = " + doc.getPubDate() + " AND";
		}
		
		String sqlString = "";
	
		if (where.endsWith("AND") == true) { // if the sql statement ends with AND
			where = where.substring(0, where.length() - 4);
			sqlString = selfm + where;
		}
		else {
			sqlString = selfm;
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
	//This is a test
	public static void main(String[] args) {
//		Publisher publisher = new Publisher();
//		publisher.setPubName("RS");
//		Author author = new Author();
//		author.setAuName("");
//		Document document = new Document();
//		document.setPublisher(publisher);
//		document.addAuthor(author);
		Book book = new Book();
		book.setIsbn("123456789");
		
		//ResultSet rs = getDocInfo(document);
		ResultSet rs = getBookInfo(book);
		
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
