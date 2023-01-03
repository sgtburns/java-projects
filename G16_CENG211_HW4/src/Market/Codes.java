package Market;

public enum Codes {
	MILK("M1",5,11),
	WATER("W1",1,3),
	OIL("O1",20,45),
	SUGAR("S1",13,25),
	FLOUR("F1",5,12),
	PASTA("P1",12,28),
	RICE("R1",16,32),
	CBOX("B1",2,0),
	UBOX("B2",3,0),
	CONTAINER("C1",1,0);
	
	private final String CODE;
	private final int COST;
	private final int PRICE;
	private Codes(String Code,int cost,int price){
		this.CODE = Code;
		this.COST = cost;
		this.PRICE = price;
	}
	
	public int getCost() {
		return COST;
	}
	public int getPrice() {
		return PRICE;
	}
	public String getCode() {
		return CODE;
	}
}
 