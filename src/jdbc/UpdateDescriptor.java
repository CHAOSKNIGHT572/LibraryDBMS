package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.tool.ConnectionOperation;

public class UpdateDescriptor {
	private static final String NEW_DESCRIPTOR_FOR_DOC = "INSERT INTO descriptor (doc_id, descriptor_value) VALUES (?,?)";

	public static boolean newDescriptorForDoc(String docId, List<String> descriptorList) {
		Connection conn;
		if ((conn = ConnectionOperation.getConnection()) == null) {
			return false;
		}
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(NEW_DESCRIPTOR_FOR_DOC);
			ps.setString(1, docId);
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectionOperation.close(conn);
			return false;
		}
		boolean result = true;
		for (String descriptor : descriptorList) {
			try {
				ps.setString(2, descriptor);
				if (ps.executeUpdate() != 1) {
					result = false;
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				result = false;
				break;
			}
		}
		ConnectionOperation.close(ps);
		return result;
	}
	
	public static void main(String[] args) {
		List<String> descriptorList = new ArrayList<>();
		descriptorList.add("Des1");
		descriptorList.add("Des2");
		newDescriptorForDoc("1", descriptorList);
	}
}
