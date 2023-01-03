package Market;

import java.util.ArrayList;

import Exceptions.VolumeNotEnoughException;

public abstract class Box<T extends Item>{
	private String boxCode;
	private String boxSerialNumber;
	private float volume;
	private float volumeLeft;
	
	public Box(){
		this.boxCode = "";
		this.boxSerialNumber = "";
		this.volume = 0;
		this.volumeLeft = 0;
	}
	
	public Box(String boxCode, float volume ,String boxSerialNumber) {
		this.boxCode = boxCode;
		this.boxSerialNumber = boxSerialNumber;
		this.volume = volume;
		this.volumeLeft = volume;
	}
	
	public float getVolume() {
		return this.volume;
	}
	public String getBoxCode() {
		return this.boxCode;
	}

	public String getBoxSerialNumber() {
		return this.boxSerialNumber;
	}
	public float getVolumeLeft() {
		return this.volumeLeft;
	}
	public void setVolumeLeft(float volume) {
		this.volumeLeft = volume;
	}
	public abstract void fillBox(T item) throws VolumeNotEnoughException;
	
	public abstract ArrayList<Item> getList();
	
	
}
