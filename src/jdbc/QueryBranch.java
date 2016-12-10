package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.tool.ConnectionOperation;

public class QueryBranch {
	private static final String GET_BRANCH_BY_NAME = "SELECT * FROM branch WHERE name=?";

	public static ResultSet getBranchByName(String name) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return null;
		}
		try {
			PreparedStatement ps = conn.prepareStatement(GET_BRANCH_BY_NAME);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs == null) {
				ConnectionOperation.close(conn);
			}
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(conn);
			return null;
		}
	}
}
