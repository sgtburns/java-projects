package Market;

import java.util.ArrayList;

import Exceptions.VolumeNotEnoughException;

public class Container<T extends Box<Item>> {
	private String containerCode;
	private float volume;
	private float volumeLeft;
	private String containerSerialNumber;
	ArrayList<T> storage = new ArrayList<>();
	
	public Container() {
		this.containerCode ="";
		this.volume = 0;
		this.containerSerialNumber = "";
		}
	public Container(String code, float volume,String serial) {
		this.containerCode = code;
		this.volume = volume;
		this.volumeLeft = volume;
		
		this.containerSerialNumber = serial;
	}
	
	public void fillContainer(T box) {
		try {
			if(this.volumeLeft - box.getVolume() < 0) {
				throw new VolumeNotEnoughException();
			}
			this.volumeLeft -= box.getVolume();
		} catch (VolumeNotEnoughException e) {
			System.out.println("Container " + this.getContainerCode() + " is full!");
			return;
		}
		storage.add(box);
	}
	
	public ArrayList<T> getContainerStorage(){
		return storage;
	}
	
	public float getVolume() {
		return this.volume;
	}

	public String getContainerSerialNumber() {
		return containerSerialNumber;
	}
	public String getContainerCode() {
		return containerCode;
	}
	
}
