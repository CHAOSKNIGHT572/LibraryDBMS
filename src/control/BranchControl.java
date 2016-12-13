package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.QueryBranch;
import jdbc.UpdateBranch;
import vo.Branch;

public class BranchControl {
	public static boolean newBranch(Branch branch) {
		return UpdateBranch.newBranch(branch);
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

	public static Branch getBranchById(String id) {
		ResultSet rs = QueryBranch.getBranchById(id);
		if (rs == null) {
			return null;
		}
		Branch lib = null;
		try {
			if (rs.next()) {
				lib = new Branch();
				lib.setId(rs.getString(1));
				lib.setName(rs.getString(2));
				lib.setLocation(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lib;
	}

	public static boolean updateInfo(Branch lib) {
		return UpdateBranch.update(lib);
	}
}
