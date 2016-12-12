package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.QueryBranch;
import jdbc.UpdateBranch;
import vo.Branch;

public class BranchControl {
	public static void newBranch(Branch branch) {
		UpdateBranch.newBranch(branch);
	}

	public static List<Branch> getBranchByName(String name) {
		List<Branch> list = new LinkedList<>();
		ResultSet rs = QueryBranch.getBranchByPartialName(name);
		if (rs != null) {
			try {
				while (rs.next()) {
					Branch branch = new Branch();
					branch.setId(rs.getString(1));
					branch.setName(rs.getString(2));
					list.add(branch);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
