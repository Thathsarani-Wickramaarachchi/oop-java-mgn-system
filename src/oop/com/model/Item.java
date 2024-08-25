package oop.com.model;



public class Item {

	//private int id;
	private String name;
	private String code;
	private String category;
	private String price;
	
	

	
	public Item( String name, String code, String category, String price) {
		super();
		//this.id = id;
		this.name = name;
		this.code = code;
		this.category = category;
		this.price = price;
	}
	
	
	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

	public Item() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price ;
	}
		
}
