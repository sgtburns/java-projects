package Dropshipping;

import java.util.StringTokenizer;

public class Product {
	private String id;
	private String title;
	private double rate;
	private int numberOfReviews;
	private double price;

	public Product(){
		this.id = "-1";
	}
	public Product(String id, String title, double rate, int numberOfReviews, double price){
		this.id = id;
		this.title = title;
		this.rate = rate;
		this.numberOfReviews = numberOfReviews;
		this.price = price;
	}
	public Product(Product toCopy){
		if(toCopy.getProductId().equals("-1")){
			this.id = "-1";
		}else {
			this.id = toCopy.id;
			this.title = toCopy.title;
			this.rate = toCopy.rate;
			this.numberOfReviews = toCopy.numberOfReviews;
			this.price = toCopy.price;	
		}
	}
	public Product(String productString){
		StringTokenizer strTokenizer = new StringTokenizer(productString);
		this.id = strTokenizer.nextToken();
		this.title = strTokenizer.nextToken();
		this.rate = Double.parseDouble(strTokenizer.nextToken());
		this.numberOfReviews = Integer.parseInt(strTokenizer.nextToken());
		this.price = Double.parseDouble(strTokenizer.nextToken());

	}

	public String getProductId(){
		return this.id;
	}
	public String getProductTitle(){
		return this.title;
	}
	public double getProductRate(){
		return this.rate;
	}
	public int getProductNumberOfReviews(){
		return this.numberOfReviews;
	}
	public double getProductPrice(){
		return this.price;
	}

	public String toString(){
		return "Id: "+this.getProductId()+"\nTitle: "+this.getProductTitle()+"\nRate: "+this.getProductRate()+"\nNumber of reviews: "+this.getProductNumberOfReviews()+"\nPrice: "+this.getProductPrice();
	}

	public double calculateSalesPrice(){
		double salesPrice = price + ((rate/5 *100)* numberOfReviews);

		return salesPrice;
	}
}
