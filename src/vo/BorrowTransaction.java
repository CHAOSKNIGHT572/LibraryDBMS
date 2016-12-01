package vo;

public class BorrowTransaction {
	private String borNum;
	private String borDateTime;
	private String retDateTime;
	private String dueDate;
	private String fineAmount;
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

	public String getBorNum() {
		return borNum;
	}

	public String getBorDateTime() {
		return borDateTime;
	}

	public String getRetDateTime() {
		return retDateTime;
	}

	public String getDueDate() {
		return dueDate;
	}

	public String getFineAmount() {
		return fineAmount;
	}
}
