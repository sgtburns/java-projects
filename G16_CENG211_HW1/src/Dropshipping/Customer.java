package Dropshipping;

public class Customer {
	private String id;
	private String name;
	private String email;
	private String country;
	private String address;
	private int numberOfPurchases =0;

	public Customer(){
		this.id = "-1";
	}
	public Customer(String id, String name, String email, String country, String address){
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.address = address;
	}
	public Customer(Customer toCopy){
		if(toCopy == null || toCopy.id == null || toCopy.email == null || toCopy.country == null || toCopy.address == null){
			this.id = "-1";
		}else {
			this.id = toCopy.id;
			this.name = toCopy.name;
			this.email = toCopy.email;
			this.country = toCopy.country;
			this.address = toCopy.address;
		}
	}
	public int getCustomerPurchases() {
		return this.numberOfPurchases;
	}
	

	public String getCustomerId(){
		return this.id;
	}
	public String getCustomerName(){
		return this.name;
	}
	public String getCustomerEmail(){
		return this.email;
	}
	public String getCustomerCountry(){
		return this.country;
	}
	public String getCustomerAddress(){
		return this.address;
	}
	
	public void incrementCustomerPurchases() {
		this.numberOfPurchases = this.numberOfPurchases+ 1;
	}
	

	public String toString(){
		return "Id: "+this.getCustomerId()+"\nName: "+this.getCustomerName()+"\nEmail: "+this.getCustomerEmail()+"\nCountry: "+this.getCustomerCountry()+"\nAddress: "+this.getCustomerAddress()+"\nNumber Of Purchases: "+this.getCustomerPurchases();
	}


	
}
