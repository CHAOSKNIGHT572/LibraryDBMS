package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.tool.ConnectionOperation;

public class QueryBranch {
	private static final String GET_BRANCH_BY_PARTIAL_NAME = "SELECT lib_id, name FROM branch WHERE name LIKE ?";
	private static final String GET_BRANCH_BY_ID = "SELECT * FROM branch WHERE lib_id=?";

	public static ResultSet getBranchByPartialName(String name) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		try {
			PreparedStatement ps = conn.prepareStatement(GET_BRANCH_BY_PARTIAL_NAME);
			ps.setString(1, "%" + name + "%");
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(conn);
			return null;
		}
	}

	public static ResultSet getBranchById(String id) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(GET_BRANCH_BY_ID);
			ps.setString(1, id);
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(conn);
			return null;
		}
	}
}
