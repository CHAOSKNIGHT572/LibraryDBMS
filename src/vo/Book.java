package vo;

public class Book extends Document {
	private String isbn;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		String toStr = super.toString();
		if (isbn != null) {
			toStr += ", " + isbn;
		}
		toStr += " - Book";
		return toStr;
	}
}
