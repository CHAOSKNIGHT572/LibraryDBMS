package vo;

import java.util.ArrayList;
import java.util.List;

public class Document {
	protected String docId;
	protected String title;
	protected String pubDate;
	protected int copyNum;
	protected List<String> descriptorList;
	protected Publisher publisher;
	protected Author author;
	
	public Document() {
		descriptorList = new ArrayList<>();
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public int getCopyNum() {
		return copyNum;
	}

	public void setCopyNum(int copyNum) {
		this.copyNum = copyNum;
	}

	public List<String> getDescriptorList() {
		return descriptorList;
	}

	public void addDescriptor(String descriptor) {
		this.descriptorList.add(descriptor);
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
