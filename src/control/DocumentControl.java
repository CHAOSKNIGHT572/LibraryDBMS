package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.QueryDocument;
import jdbc.UpdateDocument;
import vo.Book;
import vo.ConferenceProceeding;
import vo.Document;
import vo.JournalIssue;
import vo.JournalVolume;

public class DocumentControl {

	public static boolean newBook(Book book) {
		if (repeatedISBN(book.getIsbn())) {
			return false;
		}
		if(UpdateDocument.newBook(book) == false) {
			return false;
		}
		return true;
	}

	public static boolean newJournalVolume(JournalVolume volume) {

		return true;
	}

	public static boolean newConferenceProceeding(ConferenceProceeding proceeding) {

		return true;
	}

	public static List<Document> getDocumentListByConditions(Document document) {
		List<Document> documentList = new ArrayList<>();

		return documentList;
	}

	public static Document getDocumentById(int documentId) {
		Document document = null;

		return document;
	}

	public static Book getBookById(int documentId) {
		Book book = null;

		return book;
	}

	public static Book getBookByISBN(int isbn) {
		Book book = null;

		return book;
	}

	public static List<JournalIssue> getIssueListByVolumeId(int volumeId) {
		List<JournalIssue> issueList = new ArrayList<>();

		return issueList;
	}

	public static JournalVolume getJournalVolumeById(int documentId) {
		JournalVolume volume = null;

		return volume;
	}

	public static ConferenceProceeding getConferenceProceedingById(int documentId) {
		ConferenceProceeding proceeding = null;

		return proceeding;
	}

	private static boolean repeatedISBN(String isbn) {
		ResultSet rs = QueryDocument.getISBN(isbn);
		boolean result = false;
		try {
			if (rs.next()) {
				result = true;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = true;
		}
		return result;
	}

	public static void main(String[] argv) {
		
	}
}
