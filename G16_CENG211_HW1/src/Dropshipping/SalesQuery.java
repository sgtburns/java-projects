
package Dropshipping;

public class SalesQuery {

    public SalesQuery(){

    }

    public void printMostProfitable(Supplier _supplier){
        double mostProfit = 0;
        Product mostProfitable = new Product();
        for(Product eachProduct: _supplier.getProductArray()){
            if(eachProduct != null){
                double profit = eachProduct.calculateSalesPrice() - eachProduct.getProductPrice();
                if(profit > mostProfit){
                    mostProfit = profit;
                    mostProfitable = new Product(eachProduct);
                }
            }
        }
        System.out.println("The most profitable product is : "+mostProfitable.getProductTitle()+"  =>  "+ mostProfit+"TL Profit");
    }

    public void printMostExpensive(Supplier _supplier){
        double max = 0;
        Product mostExpensive = new Product();
        for(Product eachProduct: _supplier.getProductArray()){
            if(eachProduct != null){
                if(eachProduct.calculateSalesPrice() > max){
                    max = eachProduct.calculateSalesPrice();
                    mostExpensive = new Product(eachProduct);
                }
            }
        }
        System.out.println("Tho most expensive product is : "+mostExpensive.getProductTitle()+"  =>  "+max +"TL");

    }

    public void printMostPurchasingCustomer(SalesManagement _salesManagement){
    	Customer mostPurchasingCustomer = new Customer(_salesManagement.traverseSales());
        System.out.println("The most purchasing customer is : " + mostPurchasingCustomer.toString()+"  "); //@Todo
    }

    public void printTotalProtit(Supplier _supplier){
        double totalProfit = 0;
        for(Product eachProduct: _supplier.getProductArray()){
            if(eachProduct != null){
                totalProfit += eachProduct.calculateSalesPrice() - eachProduct.getProductPrice();
            }
        }
        System.out.println("The total profit of all sales is : " + totalProfit+"TL Profit");
    }

    public void printLeastProfitableOfS1(SalesManagement _salesManagement){
        double leastProfit = Double.MAX_VALUE;
        Sales[] supplier1 = _salesManagement.getSpecificSupplier(1);
        Product leastProfitable = new Product();
        for(Sales eachSales: supplier1){
            if(eachSales != null && !eachSales.getId().equals("-1")){
                double profit = eachSales.getSalesPrice() - eachSales.getProduct().getProductPrice();
                if (profit < leastProfit){
                    leastProfit = profit;
                    leastProfitable = eachSales.getProduct();
                }
            }
        }
        System.out.println("Least profitable product is : "+ leastProfitable.getProductTitle()+ "  =>  "+ leastProfit+ "TL");
    }
}
