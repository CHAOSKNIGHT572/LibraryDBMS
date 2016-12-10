package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.tool.ConnectionOperation;

public class QueryChiefEditor {
	private static final String GET_CHIEF_EDITOR_BY_NAME = "SELECT * FROM chief_editior WHERE ce_name=?";
	private static final String GET_CHIEF_EDITOR_BY_PARTIAL_NAME = "SELECT * FROM chief_editior WHERE ce_name LIKE ?";

	public static ResultSet getChiefEditorByName(String name) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(GET_CHIEF_EDITOR_BY_NAME);
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(conn);
			return null;
		}
		ResultSet rs;
		try {
			ps.setString(1, name);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(ps);
			return null;
		}
		return rs;
	}

	public static ResultSet getChiefEditorByPartialName(String name) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(GET_CHIEF_EDITOR_BY_PARTIAL_NAME);
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(conn);
			return null;
		}
		ResultSet rs;
		try {
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(ps);
			return null;
		}
		return rs;
	}
}
