package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.tool.ConnectionOperation;
import vo.Branch;

public class UpdateBranch {
	private static final String NEW_BRANCH = "INSERT INTO branch (name, location) VALUES (?,?)";
	private static final String UPDATE = "UPDATE branch SET name=?, location=? WHERE lib_id=?";

	public static boolean newBranch(Branch branch) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		PreparedStatement ps = null;
		boolean result = true;
		try {
			ps = conn.prepareStatement(NEW_BRANCH);
			ps.setString(1, branch.getName());
			ps.setString(2, branch.getLocation());
			if (ps.executeUpdate() == 1) {
				String id = ConnectionOperation.getLastInsertIdForConnection(conn);
				if (id == null) {
					result = false;
				} else {
					branch.setId(id);
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

	public static boolean update(Branch lib) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		PreparedStatement ps = null;
		boolean result = false;
		try {
			ps = conn.prepareStatement(UPDATE);
			ps.setString(1, lib.getName());
			ps.setString(2, lib.getLocation());
			ps.setString(3, lib.getId());
			if (ps.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionOperation.close(conn);
		return result;
	}
}
