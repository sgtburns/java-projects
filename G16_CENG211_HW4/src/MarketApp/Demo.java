package MarketApp;

import Market.ProgramExecuter;

public class Demo {
	//We had subtracted the items that are produced but could not be sold because of Box is full exception and thrown them in wastebin.
	//The production cost is still added to the revenue as negative value but there is no unearned or earned revenue by them
	public static void main(String[] args) {
		ProgramExecuter exec = new ProgramExecuter();
		exec.start();
	}
}