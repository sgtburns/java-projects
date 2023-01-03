package Market;

import java.util.ArrayList;

import Exceptions.VolumeNotEnoughException;

public class CountableBox<T extends Item> extends Box<T> {
	private int number;
	private int spaceLeft;
	ArrayList<Item> boxStorage = new ArrayList<>();	
	public CountableBox() {
		super();
		this.number = 0;
	}
	public CountableBox(String boxCode, int num, float volume, String serial) {
		super(boxCode, volume,serial);
		this.number = num;
		this.spaceLeft = num;
		
	}
	@Override
	public void fillBox(Item item) throws VolumeNotEnoughException {
		float itemVolume = item.getVolume();
		if (spaceLeft == 0 || this.getVolume() - itemVolume < 0) {
			throw new VolumeNotEnoughException();
		}
		boxStorage.add(item);
		spaceLeft--;
		this.setVolumeLeft(this.getVolumeLeft() - itemVolume);
	}
	
	public ArrayList<Item> getList(){
		return boxStorage;
	}
	public int getNumber() {
		return this.number;
	}
}