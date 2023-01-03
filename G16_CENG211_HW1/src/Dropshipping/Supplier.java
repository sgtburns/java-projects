package Dropshipping;

public class Supplier {
	private Product[] productArray;
	private int index;
	
	public Supplier(){
		this.productArray = new Product[500];
	}
	
	public Supplier(Supplier _inputSupplier){
		for(this.index = 0; this.index < _inputSupplier.getProductArray().length; this.index++){
			this.productArray[this.index] = new Product(_inputSupplier.getProductArray()[this.index]);
			this.index++;
		}
	}

	public void addProduct(Product product){
		this.productArray[this.index] = new Product(product);
		this.index++;
	}

	public int getMemberCount(){
		return this.index;
	}


	public Product[] getProductArray(){
		return this.productArray;
	}
	
}
