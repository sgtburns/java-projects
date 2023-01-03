package DropshippingApp;

import java.io.FileNotFoundException;
import java.io.IOException;

import Dropshipping.ProgramExecuter;

public class DropshippingApp {

	public static void main(String[] args) throws FileNotFoundException, IOException { 
		String[] paths = {
				"Customers.csv",
				"S1_Products.csv",
				"S1_Sales.csv",
				"S2_Products.csv",
				"S2_Sales.csv",
				"S3_Products.csv",
				"S3_Sales.csv"
		}; 
		
		ProgramExecuter executer = new ProgramExecuter(paths);		
		executer.start();
	}

}
