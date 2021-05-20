package kr.or.ddit.basic.json;

public class sampleVO {
	private int id;
	private String name;
	
	public sampleVO() {}
	
	public sampleVO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
