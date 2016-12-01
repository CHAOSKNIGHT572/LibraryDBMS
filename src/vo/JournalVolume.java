package vo;

public class JournalVolume extends Document {
	private String volNum;
	private ChiefEditor editor;

	public String getVolNum() {
		return volNum;
	}

	public void setVolNum(String volNum) {
		this.volNum = volNum;
	}

	public ChiefEditor getEditor() {
		return editor;
	}

	public void setEditor(ChiefEditor editor) {
		this.editor = editor;
	}
}
