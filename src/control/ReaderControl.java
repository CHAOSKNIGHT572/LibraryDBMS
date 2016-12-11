package control;

import jdbc.UpdateBorrow;
import jdbc.UpdateReader;
import vo.Branch;
import vo.Document;
import vo.Reader;

public class ReaderControl {
	public static boolean newReader(Reader reader) {
		return UpdateReader.newReader(reader);
	}

	public static int borrow(Document doc, Branch lib, Reader reader) {
		return UpdateBorrow.borrow(doc.getId(), lib.getId(), reader.getId());
	}

	public static boolean reserve() {
		return true;
	}
}
