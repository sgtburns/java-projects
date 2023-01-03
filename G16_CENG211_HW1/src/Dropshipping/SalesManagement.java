package Dropshipping;

public class SalesManagement {
	private int row;
    private int column;
	private Sales[][] salesArray= new Sales[3][500];

    public SalesManagement(){
        this.row = 0;
        this.column = 0;
    }
    public void addSupplier(Sales[] supplier){
        for(Sales supplierSales : supplier){
            this.salesArray[this.row][this.column] = supplierSales;
            column++;
        }
        
    }
    public void addProductToSupplier(Sales sale){
        this.salesArray[row][column] = sale;
        column++;
    }

    public void changeSupplier(int supplierNumber){
        if(supplierNumber > 3 || supplierNumber <= 0){
            return;
        }
        this.row = supplierNumber - 1;
        this.column = 0;
        for(Sales singleSale: this.salesArray[this.row]){
            if(singleSale != null){
                this.column++;
            }
        }
    }
    public Customer traverseSales() {
    	
    	

    	for (int i =0; i <row ; i++) {
    		
    		for(int j=0; j<column;j++) {
                if(this.salesArray[i][j] != null){
                    Customer customer = new Customer(this.salesArray[i][j].getCustomer());
                    if(!customer.getCustomerId().equals("-1")){
                        customer.incrementCustomerPurchases();
                        System.out.println(customer.toString());
                        Sales currentSales = new Sales(this.salesArray[i][j]); 
                        currentSales.setCustomer(customer);
                        this.salesArray[i][j] = currentSales;
                    }
                }
    		}
    	}
    	int maxCount = Integer.MIN_VALUE;
    	Customer maxCustomer = new Customer();
    	for (int z =0; z<row;z++) {
    		for (int x = 0; x<column ;x++) {
    			
    			if (this.salesArray[z][x] != null) {                    
    				Customer customer = new Customer(this.salesArray[z][x].getCustomer());
    				if(customer.getCustomerPurchases() > maxCount) {
        				maxCustomer = new Customer(customer);
        				maxCount = customer.getCustomerPurchases();
    			}
    			
    			}
    			}
    	}
    	return maxCustomer;
        // return null;
    }

    public Sales[][] getEverySupplier(){
        return this.salesArray.clone();
    }
    public Sales[] getSpecificSupplier(int supplierIndex){
        return this.salesArray[supplierIndex].clone();
    }

    public Sales getSales(int row, int column) {
		return new Sales(salesArray[row][column]);
	}
}
