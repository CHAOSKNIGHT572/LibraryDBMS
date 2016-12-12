package vo;

public class ConferenceProceeding extends Document {
	private String conDate;
	private String conEditor;
	private String conLocation;

	public String getConDate() {
		return conDate;
	}

	public void setConDate(String conDate) {
		this.conDate = conDate;
	}

	public String getConEditor() {
		return conEditor;
	}

	public void setConEditor(String conEditor) {
		this.conEditor = conEditor;
	}

	public String getConLocation() {
		return conLocation;
	}

	public void setConLocation(String conLocation) {
		this.conLocation = conLocation;
	}

	@Override
	public String toString() {
		String toStr = super.toString();
		toStr += " - Proceeding";
		return toStr;
	}
}
