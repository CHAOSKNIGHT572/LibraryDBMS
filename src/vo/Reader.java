package vo;

public class Reader {
	private String id;
	private String type;
	private String name;
	private String address;
	private String phoneNum;
	private int borNum;
	private int resNum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getBorNum() {
		return borNum;
	}

	public int getResNum() {
		return resNum;
	}

	@Override
	public String toString() {
		return name + "," + phoneNum;
	}
}
