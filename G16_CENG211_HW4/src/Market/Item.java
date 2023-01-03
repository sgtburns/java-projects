package Market;

public abstract class Item {
	private String itemCode;
	private String serialNumber;
	private float volume;
	
	public Item() {
		this.itemCode = "";
		this.serialNumber = "";
		this.volume = 0;
	}
	
	public Item(String itemCode,float volume, String serialNumber) {
		this.itemCode = itemCode;
		this.serialNumber = serialNumber;
		this.volume = volume;
	}
	
	public float getVolume() {
		return this.volume;
	}
	
	public String getItemSerialNumber() {
		return serialNumber;
	}
	public String getItemCode() {
		return itemCode;
	}
}
