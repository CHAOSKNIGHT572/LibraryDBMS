package control;

import jdbc.UpdateBranch;
import vo.Branch;

public class BranchControl {
	public static void newBranch(Branch branch) {
		UpdateBranch.newBranch(branch);
	}
}
