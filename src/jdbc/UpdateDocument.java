package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import control.Constant;
import jdbc.tool.ConnectionOperation;
import vo.Book;
import vo.ChiefEditor;
import vo.ConferenceProceeding;
import vo.Document;
import vo.JournalVolume;
import vo.Publisher;

public class UpdateDocument {
	private static final String NEW_DOCUMENT = "INSERT INTO `document` (`title`, `type`, `pub_id`, `pub_date`) VALUES (?,?,?,?)";
	private static final String NEW_BOOK = "INSERT INTO book (doc_id, isbn) VALUES (?,?)";
	private static final String NEW_JOURNAL_VOLUME = "INSERT INTO journal_volume (doc_id, jv_editor) VALUES (?,?)";
	private static final String NEW_CONFERENCE_PROCEEDING = "INSERT INTO proceeding (doc_id, cp_date, cp_location, cp_editor) VALUES (?,?,?,?)";

	public static boolean newBook(Book book) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		if (!newDocument(conn, book, Constant.TYPE_BOOK)) {
			ConnectionOperation.close(conn);
			return false;
		}
		boolean result = true;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(NEW_BOOK);
			ps.setString(1, book.getId());
			ps.setString(2, book.getIsbn());
			if (ps.executeUpdate() != 1) {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		ConnectionOperation.close(ps);
		return result;
	}

	public static boolean newJournalVolume(JournalVolume volume) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		if (!newDocument(conn, volume, Constant.TYPE_JOURNAL_VOLUME)) {
			ConnectionOperation.close(conn);
			return false;
		}
		PreparedStatement ps = null;
		boolean result = true;
		try {
			ChiefEditor editor = volume.getEditor();
			ResultSet rs = QueryChiefEditor.getChiefEditorByName(editor.getCeName());
			if (rs != null && rs.next()) {
				editor.setCeId(rs.getString(1));
			} else {
				UpdateChiefEditor.newChiefEditor(editor);
			}
			ps = conn.prepareStatement(NEW_JOURNAL_VOLUME);
			ps.setString(1, volume.getId());
			ps.setString(2, editor.getCeId());
			if (ps.executeUpdate() != 1) {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		ConnectionOperation.close(ps);
		return result;
	}

	public static boolean newConferenceProceeding(ConferenceProceeding proceeding) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		if (!newDocument(conn, proceeding, Constant.TYPE_CONFERENCE_PROCEEDING)) {
			ConnectionOperation.close(conn);
			return false;
		}
		PreparedStatement ps = null;
		boolean result = true;
		try {
			ps = conn.prepareStatement(NEW_CONFERENCE_PROCEEDING);
			ps.setString(1, proceeding.getId());
			ps.setString(2, proceeding.getConDate());
			ps.setString(3, proceeding.getConLocation());
			ps.setString(4, proceeding.getConEditor());
			if (ps.executeUpdate() != 1) {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		ConnectionOperation.close(ps);
		return result;
	}

	private static boolean newDocument(Connection conn, Document doc, int typeNo) {
		try {
			Publisher publisher = doc.getPublisher();
			ResultSet rs = QueryPublisher.getPublisherByName(publisher.getPubName());
			if (rs != null && rs.next()) {
				publisher.setPubId(rs.getString(1));
			} else {
				if (!UpdatePublisher.newPublisher(publisher)) {
					return false;
				}
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
}
