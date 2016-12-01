package vo;

public class Reservation {
	private String resNum;
	private String resDateTime;
	private String resStatus;
	private Document document;
	private Branch branch;
	private Reader reader;

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public String getResNum() {
		return resNum;
	}

	public String getResDateTime() {
		return resDateTime;
	}

	public String getResStatus() {
		return resStatus;
	}
}
