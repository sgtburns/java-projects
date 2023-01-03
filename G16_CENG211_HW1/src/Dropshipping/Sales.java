package Dropshipping;

public class Sales {
	private String id;
	private Customer customer;// a
	private Product product;
	private String salesDate;
	private double salesPrice;

	public Sales(){
		this.id = "-1";
	}

	public Sales(String id, Customer customer, Product product, String salesDate, double salesPrice ){
		this.id = id;
		this.customer = customer;// a
		this.product = new Product(product);
		this.salesDate = salesDate;
		this.salesPrice = salesPrice;
	}
	public Sales(Sales toCopy){
		if(toCopy == null || toCopy.id == null || toCopy.product == null || toCopy.salesDate == null || toCopy.salesPrice == 0){
			System.out.println("Wonk");
			System.exit(0);
		}else {

			this.id = toCopy.id;
			this.customer = toCopy.customer;
			this.product = new Product(toCopy.product);
			this.salesDate = toCopy.salesDate;
			this.salesPrice = toCopy.salesPrice;
		}
	}

	public String getId(){
		return this.id;
	}
	public Customer getCustomer(){
		if(this.customer != null){
			return this.customer;
		}
		return new Customer();
	}
	public Product getProduct(){
		if(this.product != null){
			return new Product(this.product);
		}
		return new Product();
	}
	public String getSalesDate(){
		return this.salesDate;
	}
	public double getSalesPrice(){
		return this.salesPrice;
	}

	public void setCustomer(Customer _customer){
		this.customer = new Customer(_customer);
	}

	public String toString(){
		return "Id: "+this.getId()+"\nCustomer: "+this.getCustomer()+"\nProduct: "+this.getProduct()+"\nSale Date: "+this.getSalesDate()+"\nSale Price: "+this.getSalesPrice();
	}
}
