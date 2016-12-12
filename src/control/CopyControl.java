package control;

import jdbc.UpdateCopy;
import vo.Copy;

public class CopyControl {
	public static int newCopy(Copy copy) {
		if (!UpdateCopy.newCopy(copy.getDocument().getId(), copy.getBranch().getId(), copy.getPosition())) {
			return Constant.EXCEPTION;
		}
		return Constant.SUCCESSFUL;
	}
}
