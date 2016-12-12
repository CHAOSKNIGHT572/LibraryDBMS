package control;

import vo.Author;
import vo.Book;
import vo.Branch;
import vo.ChiefEditor;
import vo.ConferenceProceeding;
import vo.Copy;
import vo.JournalVolume;
import vo.Publisher;
import vo.Reader;

public class Test {
	public static void main(String[] args) {
		Branch branch = new Branch();
		branch.setName("NJIT Library");
		branch.setLocation("NJIT");
		BranchControl.newBranch(branch);

		Copy copy = new Copy();
		for (int i = 1; i < 10; ++i) {
			Book book = addBook(i);
			copy.setBranch(branch);
			copy.setDocument(book);
			copy.setPosition(i + "A1");
			CopyControl.newCopy(copy);
		}

		JournalVolume volume = addJournalVolume();
		ConferenceProceeding proceeding = addConferenceProceeding();

		for (int i = 1; i < 3; ++i) {
			copy.setBranch(branch);
			copy.setDocument(volume);
			copy.setPosition(i + "A2");
			CopyControl.newCopy(copy);

			copy.setBranch(branch);
			copy.setDocument(proceeding);
			copy.setPosition(i + "A3");
			CopyControl.newCopy(copy);
		}

		Reader reader = new Reader();
		reader.setName("Surc");
		reader.setType("Stu");
		reader.setAddress("Rm 801A, 155 Oak Hall, 07103, Newark, NY");
		reader.setPhoneNum("8328360699");
		ReaderControl.newReader(reader);

		System.out.println(ReaderControl.borrow(volume, branch, reader) == Constant.SUCCESSFUL);
		System.out.println(ReaderControl.reserve(proceeding, branch, reader) == Constant.SUCCESSFUL);
		System.out.println(ReaderControl.borrow(proceeding, branch, reader) == Constant.SUCCESSFUL);
		System.out.println(ReaderControl.reserve(volume, branch, reader) == Constant.SUCCESSFUL);
	}

	private static Book addBook(int index) {
		Book book = new Book();
		book.setTitle("CS631Phase" + index);
		book.setIsbn("123234" + index);
		book.setPubDate("2012-2-2");

		Publisher publisher = new Publisher();
		publisher.setPubName("CS631Group");
		book.setPublisher(publisher);

		Author author = new Author();
		author.setAuName("YD");
		book.addAuthor(author);
		author = new Author();
		author.setAuName("TS");
		book.addAuthor(author);

		book.addDescriptor("CS631");
		book.addDescriptor("Database");
		book.addDescriptor("Project");
		DocumentControl.newBook(book);
		return book;
	}

	private static JournalVolume addJournalVolume() {
		JournalVolume volume = new JournalVolume();
		volume.setTitle("CS631PhaseJV1");
		volume.setPubDate("2012-2-2");
		volume.setVolNum("1");

		Publisher publisher = new Publisher();
		publisher.setPubName("CS631Group");
		volume.setPublisher(publisher);

		Author author = new Author();
		author.setAuName("YD");
		volume.addAuthor(author);
		author = new Author();
		author.setAuName("TS");
		volume.addAuthor(author);

		volume.addDescriptor("CS631");
		volume.addDescriptor("Database");
		volume.addDescriptor("Project");

		ChiefEditor editor = new ChiefEditor();
		editor.setCeName("surc");
		volume.setEditor(editor);

		DocumentControl.newJournalVolume(volume);
		return volume;
	}

	private static ConferenceProceeding addConferenceProceeding() {
		ConferenceProceeding proceeding = new ConferenceProceeding();
		proceeding.setTitle("CS631PhaseCP1");
		proceeding.setPubDate("2012-2-2");

		proceeding.setConEditor("surc");
		proceeding.setConLocation("NJIT");
		proceeding.setConDate("2010-10-10");

		Publisher publisher = new Publisher();
		publisher.setPubName("CS631Group");
		proceeding.setPublisher(publisher);

		Author author = new Author();
		author.setAuName("YD");
		proceeding.addAuthor(author);
		author = new Author();
		author.setAuName("TS");
		proceeding.addAuthor(author);

		proceeding.addDescriptor("CS631");
		proceeding.addDescriptor("Database");
		proceeding.addDescriptor("Project");

		DocumentControl.newConferenceProceeding(proceeding);
		return proceeding;
	}
}
