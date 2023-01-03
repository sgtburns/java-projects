package Market;

public class Uncountable extends Item{
	private float mass;
	
	public Uncountable() {
		super();
		this.mass = 0;
	}
	public Uncountable(String itemCode,float mass,float volume, String serialNumber) {
		super(itemCode,volume,serialNumber);
		this.mass = mass;
	}
	
	public float getMass() {
		return this.mass;
	}
}
