package Market;

import java.util.ArrayList;

import Exceptions.VolumeNotEnoughException;

public class UncountableBox<T extends Item> extends Box<T> {
	private float mass;
	ArrayList<Item> boxStorage = new ArrayList<>();	
	public UncountableBox() {
		super();
		this.mass = 0;
	}
	public UncountableBox(String boxCode, float mass, float volume, String serial) {
		super(boxCode, volume,serial);
		this.mass = mass;
		
	}
	@Override
	public void fillBox(Item item) throws VolumeNotEnoughException {
		float itemMass = ((Uncountable) item).getMass();

			if(this.mass - itemMass < 0 || this.getVolume() - item.getVolume() < 0) {
				throw new VolumeNotEnoughException();
				
			}
			
			boxStorage.add(item);
			this.mass -= itemMass;
			this.setVolumeLeft(this.getVolumeLeft() - item.getVolume());
			
	}
	
	public ArrayList<Item> getList(){
		return boxStorage;
	}
	public float getMass() {
		return this.mass;
	}
}

