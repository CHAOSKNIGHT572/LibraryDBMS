package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import jdbc.tool.ConnectionOperation;
import vo.Publisher;

public class UpdatePublisher {
	private static final String NEW_PUBLISHER = "INSERT INTO `publisher` (`pub_name`, `address`) VALUES (?, ?)";

	public static boolean newPublisher(Publisher publisher) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(NEW_PUBLISHER);
		} catch (SQLException e1) {
			e1.printStackTrace();
			ConnectionOperation.close(conn);
			return false;
		}
		boolean result = true;
		try {
			ps.setString(1, publisher.getPubName());
			if (publisher.getAddress() == null) {
				ps.setNull(2, Types.VARCHAR);
			} else {
				ps.setString(2, publisher.getAddress());
			}
			if(result = ps.executeUpdate() == 1) {
				String id = ConnectionOperation.getLastInsertIdForConnection(conn);
				if(id == null){
					result = false;
				} else {
					publisher.setPubId(id);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(ps);
			result = false;
		}
		return result;
	}
}
