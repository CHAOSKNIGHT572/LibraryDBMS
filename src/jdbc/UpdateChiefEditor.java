package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.tool.ConnectionOperation;
import vo.ChiefEditor;

public class UpdateChiefEditor {
	private static final String NEW_CHIEF_EDITOR = "INSERT INTO chief_editior (ce_name) VALUES (?)";

	public static boolean newChiefEditor(ChiefEditor editor) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		PreparedStatement ps = null;
		boolean result = true;

		try {
			ps = conn.prepareStatement(NEW_CHIEF_EDITOR);
			ps.setString(1, editor.getCeName());
			if (ps.executeUpdate() == 1) {
				String id = ConnectionOperation.getLastInsertIdForConnection(conn);
				if (id == null) {
					result = false;
				} else {
					editor.setCeId(id);
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
}
