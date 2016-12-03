package control;

import java.util.ArrayList;
import java.util.List;

import vo.Reader;

public class ReaderControl {
	public static boolean newReader(Reader reader) {
		// TODO: Add a new reader to database.
		return true;
	}

	public static Reader getReaderById(int id) {
		Reader reader = null;
		// TODO: Return a reader searched by id.
		return reader;
	}
	
	public static List<Reader> getReaderByName(String Name) {
		List<Reader> readerList = new ArrayList<>();
		//TODO: Return a list of reader with the Name requested.
		return readerList;
	}
	
	public static boolean updateInfo(Reader reader) {
		//TODO: Update the reader Information.
		return true;
	}
}
