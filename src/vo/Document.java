package vo;

import java.util.ArrayList;
import java.util.List;

public class Document {
	protected String id;
	protected String title;
	protected String pubDate;
	protected int copyNum;
	protected List<String> descriptorList;
	protected Publisher publisher;
	protected List<Author> authorList;

	public Document() {
		descriptorList = new ArrayList<>();
		authorList = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		descriptorList.add(descriptor);
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void addAuthor(Author author) {
		authorList.add(author);
	}
}
