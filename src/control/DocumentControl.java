package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import jdbc.QueryDocument;
import jdbc.UpdateDocument;
import vo.Document;
import vo.Book;
import vo.JournalVolume;
import vo.Publisher;
import vo.ConferenceProceeding;
import vo.JournalIssue;

public class DocumentControl {
	public static int newBook(Book book) {
		if (repeatedISBN(book.getIsbn())) {
			return Constant.REPEATED_ISBN;
		}
		if (UpdateDocument.newBook(book) == false) {
			return Constant.EXCEPTION;
		}
		return Constant.SUCCESSFUL;
	}

	public static int newJournalVolume(JournalVolume volume) {
		if (UpdateDocument.newJournalVolume(volume) == false) {
			return Constant.EXCEPTION;
		}
		return Constant.SUCCESSFUL;
	}

	public static int newConferenceProceeding(ConferenceProceeding proceeding) {
		if (UpdateDocument.newConferenceProceeding(proceeding) == false) {
			return Constant.EXCEPTION;
		}
		return Constant.SUCCESSFUL;
	}

	public static List<Document> getDocumentListByConditions(Document document, String libId) {
		List<Document> list = new LinkedList<>();
		ResultSet rs = QueryDocument.getDocumentByMultiCondition(document, libId);
		if (rs != null) {
			try {
				int type;
				Document doc;
				Publisher pub;
				while (rs.next()) {
					type = rs.getInt(1);
					if (type == Constant.TYPE_BOOK) {
						doc = new Book();
					} else if (type == Constant.TYPE_JOURNAL_VOLUME) {
						doc = new JournalVolume();
					} else if (type == Constant.TYPE_CONFERENCE_PROCEEDING) {
						doc = new ConferenceProceeding();
					} else {
						continue;
					}
					doc.setId(rs.getString(2));
					doc.setTitle(rs.getString(3));
					pub = new Publisher();
					pub.setPubName(rs.getString(4));
					doc.setPublisher(pub);
					list.add(doc);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public static List<Document> getDocumentListByName(String partTitle) {
		List<Document> list = new LinkedList<>();
		ResultSet rs = QueryDocument.getDocumentByPartialTitle(partTitle);
		if (rs != null) {
			try {
				int type;
				Document doc;
				while (rs.next()) {
					type = rs.getInt(3);
					if (type == Constant.TYPE_BOOK) {
						doc = new Book();
					} else if (type == Constant.TYPE_JOURNAL_VOLUME) {
						doc = new JournalVolume();
					} else if (type == Constant.TYPE_CONFERENCE_PROCEEDING) {
						doc = new ConferenceProceeding();
					} else {
						continue;
					}
					doc.setId(rs.getString(1));
					doc.setTitle(rs.getString(2));
					list.add(doc);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public static List<JournalIssue> getIssueListByVolumeId(int volumeId) {
		List<JournalIssue> issueList = new ArrayList<>();

		return issueList;
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
}
