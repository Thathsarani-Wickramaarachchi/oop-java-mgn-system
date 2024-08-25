package oop.com.model;



public class deliveryReq {

	private String nicnum;
	
	private String address;
	
	private String contactNo;
	
	private String email;
	
	private String dldate;
	
	public deliveryReq() {
		
	}
	

	public deliveryReq(String nicnum,String address, String contactNo, String email,String dldate) {
		super();
		this.nicnum=nicnum;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.dldate=dldate;
	}


	public String getNicnum() {
		return nicnum;
	}


	public void setNicnum(String nicnum) {
		this.nicnum = nicnum;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDldate() {
		return dldate;
	}


	public void setDldate(String dldate) {
		this.dldate = dldate;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Override
	public String toString() {
		return "Customer NIC No= " +nicnum + "\n" + "Customer Address=" + address + "\n" +"Customer Contact Number=" + contactNo + "\n" + " Customer Email=" + email+"\n"+"Deleivery Date="+dldate; 
	}
	*/
	
}
