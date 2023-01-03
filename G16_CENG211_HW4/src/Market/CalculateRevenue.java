package Market;

public class CalculateRevenue {
	private float revenue;
	private float unearnedRevenue;
	
	public CalculateRevenue() {
		this.revenue = 0;
	}

	public CalculateRevenue(float revenue) {
		this.revenue = revenue;
	}
	public void addRevenue(float cost) {
		this.revenue += cost;
	}

	public void addUnearnedRevenue(float price) {
		this.unearnedRevenue += price;
	}
	public void subtractShippedRevenue(float sold) {
		this.unearnedRevenue -= sold;
	}
	public float getRevenue() {
		return this.revenue;
	}

	public float getUnearnedRevenue() {
		return this.unearnedRevenue;
	}
	
}
