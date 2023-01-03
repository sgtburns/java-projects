package Market;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

import Exceptions.BoxAlreadyLoadedException;
import Exceptions.BoxNotFoundException;
import Exceptions.EmptyLineException;
import Exceptions.IllegalLoadException;
import Exceptions.SameSerialException;
import Exceptions.SameStorageTypeException;
import Exceptions.UnknownCommandException;
import Exceptions.UnknownStorageException;
import Exceptions.VolumeNotEnoughException;
import Exceptions.WrongBoxException;
import fileIO.FileIO;

public class ProgramExecuter implements IProgramExecuter{
	// Any other method should be written private as an helper method
	CalculateRevenue rev = new CalculateRevenue();
	ArrayList<Item> itemsList = new ArrayList<Item>();
	ArrayList<Box<Item>> boxList = new ArrayList<Box<Item>>();
	ArrayList<Container<Box<Item>>> containerList = new ArrayList<Container<Box<Item>>>();
	ArrayList<Item> wastebin = new ArrayList<Item>();
	private String serialToLoad;
	private String serialOfHolder;
	private String containerToShip;

	private HashSet<String> serials = new HashSet<String>(); // to check if serials are unique

	public void start() {
		FileIO file = new FileIO();
		try {
			file.readingCsvFile("ExampleCommands.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		selectAction(file.getAllCommands());
	}

	// Parses the commands and calls the corresponding methods
	public void selectAction(ArrayList<String> theArray) {
		for (int i = 0; i < theArray.size(); i++) {
			try {
				if (theArray.get(i) != null) {
					switch (theArray.get(i).charAt(0)) {
						case '1':
							produce(theArray.get(i));
							break;
						case '2':
							load(theArray.get(i));
							break;
						case '3':
							ship(theArray.get(i));
							break;
						case '4':
							showRevenue(theArray.get(i));
							break;
						default:
							throw new UnknownCommandException();
					}
				} else {
					throw new EmptyLineException();
				}
			} catch (UnknownCommandException e) {
				System.out.println("Unknown command!");
			} catch (EmptyLineException e) {
				System.out.println("Empty line!");
			}
		}
	}
	

	// Produces the item, box or container according to the parsed command & subtracts the prod cost & adds unearned revenue
	@Override
	public void produce(String command) {
		StringTokenizer st = new StringTokenizer(command,",");
		st.nextToken();
		String code = st.nextToken();
		String secondToken = st.nextToken();
		String thirdToken = st.nextToken();
		

		try{
		if(code.equals(Codes.CBOX.getCode())) {
			String fourthToken = st.nextToken();
			if(serials.contains(fourthToken)){
				throw new SameSerialException();
			}
			else {
				serials.add(fourthToken);
				CountableBox<Item> box = new CountableBox<Item>(code,Integer.parseInt(secondToken),Float.parseFloat(thirdToken),fourthToken);
				boxList.add(box);
				rev.addRevenue(-Codes.CBOX.getCost() * box.getVolume());
				
				Printer.printProduction(box);
				Printer.printRevenue(rev.getRevenue());
			}

		}
		else if(code.equals(Codes.UBOX.getCode())) {
			String fourthToken = st.nextToken();
			if(serials.contains(fourthToken)){
				throw new SameSerialException();
			}
			else {
				serials.add(fourthToken);
				UncountableBox<Item> box = new UncountableBox<>(code,Float.parseFloat(secondToken),Float.parseFloat(thirdToken),fourthToken);
				boxList.add(box);
				rev.addRevenue(-Codes.UBOX.getCost() * box.getVolume());
				
				Printer.printProduction(box);
				Printer.printRevenue(rev.getRevenue());
			}

			}
		else if(code.equals(Codes.CONTAINER.getCode())) {
			if(serials.contains(thirdToken)){
				throw new SameSerialException();
			}
			else {
				serials.add(thirdToken);
				Container<Box<Item>> container = new Container<>(code,Float.parseFloat(secondToken),thirdToken);
				containerList.add(container);
				rev.addRevenue(-Codes.CONTAINER.getCost() * container.getVolume());
				
				Printer.printProduction(container);
				Printer.printRevenue(rev.getRevenue());
			}



		}
		else {
			if(st.countTokens() == 1) {
				String fourthToken = st.nextToken();
				if(serials.contains(fourthToken)){
					throw new SameSerialException();
				}
				else {
					serials.add(fourthToken);
					Uncountable item = new Uncountable(code, Float.parseFloat(secondToken),
							Float.parseFloat(thirdToken), fourthToken);
					itemsList.add(item);
					Codes itemCode = ItemTypeFinder(item.getItemCode());
					switch (itemCode) {
						case SUGAR:
							rev.addUnearnedRevenue(Codes.SUGAR.getPrice() * item.getVolume());
							rev.addRevenue(-Codes.SUGAR.getCost() * item.getVolume());

							break;
						case FLOUR:
							rev.addUnearnedRevenue(Codes.FLOUR.getPrice() * item.getVolume());
							rev.addRevenue(-Codes.FLOUR.getCost() * item.getVolume());
							break;
						case PASTA:
							rev.addUnearnedRevenue(Codes.PASTA.getPrice() * item.getVolume());
							rev.addRevenue(-Codes.PASTA.getCost() * item.getVolume());
							break;
						case RICE:
							rev.addUnearnedRevenue(Codes.RICE.getPrice() * item.getVolume());
							rev.addRevenue(-Codes.RICE.getCost() * item.getVolume());
							break;
						default:
							break;
					}
					
					Printer.printProduction(item, itemCode);
					Printer.printRevenue(rev.getRevenue());
				}
			}
			else if (st.countTokens() == 0) {
				if (serials.contains(thirdToken)) {
					throw new SameSerialException();
				} else {
					serials.add(thirdToken);
					Countable item = new Countable(code,Float.parseFloat(secondToken),thirdToken);
					itemsList.add(item);

					Codes itemCode = ItemTypeFinder(item.getItemCode());
					switch (itemCode) {
						case WATER:
							rev.addUnearnedRevenue(Codes.WATER.getPrice() * item.getVolume());
							rev.addRevenue(-Codes.WATER.getCost() * item.getVolume());
							break;
						case MILK:
							rev.addUnearnedRevenue(Codes.MILK.getPrice() * item.getVolume());
							rev.addRevenue(-Codes.MILK.getCost() * item.getVolume());
							break;
						case OIL:
							rev.addUnearnedRevenue(Codes.OIL.getPrice() * item.getVolume());
							rev.addRevenue(-Codes.OIL.getCost() * item.getVolume());
							break;
						default:
							break;

					}

					Printer.printProduction(item, itemCode);
					Printer.printRevenue(rev.getRevenue());
				}


			}
			else {
				throw new UnknownCommandException();
			}
		}}
		catch (SameSerialException e) {
			System.out.println("Same serial number!");
		} catch (UnknownCommandException e) {
			System.out.println("Unknown command!");
		}

	}
		
		

	// This method finds the holder unit in the list of corresponding lists, loads them accordingly if there's an exception during loading phase, subtracts unearned revenue from ıskarta list
	@Override
	public void load(String command) {
		StringTokenizer st = new StringTokenizer(command, ",");
		st.nextToken();
		serialToLoad = st.nextToken();
		serialOfHolder = st.nextToken();

		try {
			if ((serialToLoad.charAt(0) == 'B' && serialOfHolder.charAt(0) == 'B') || (serialToLoad.charAt(0) == 'C' && serialOfHolder.charAt(0) == 'C')) {
				throw new SameStorageTypeException();
			}
			if (serialOfHolder.charAt(0) == 'B') {
				Box<Item> foundBox = BoxFinder(serialOfHolder);
				Item foundItem = ItemFinder(serialToLoad);
				if (foundBox == null && serials.contains(serialOfHolder)) {
					throw new BoxAlreadyLoadedException();
				}
				else if (foundBox == null) {
					throw new BoxNotFoundException();
				} 

				if ((foundBox instanceof CountableBox && foundItem instanceof Countable)
						|| (foundBox instanceof UncountableBox && foundItem instanceof Uncountable)) {
					BoxFinder(serialOfHolder).fillBox(ItemFinder(serialToLoad));

					Printer.printLoadItem(serialToLoad, serialOfHolder);
				} 
				else {
					Codes itemType = ItemTypeFinder(foundItem.getItemCode());
					rev.addUnearnedRevenue(-itemType.getPrice()*foundItem.getVolume());
					throw new WrongBoxException();
				}
		}
		else if (serialOfHolder.charAt(0) == 'C') {
			if (serialToLoad.charAt(0) != 'B') {
				throw new IllegalLoadException();
			}
			ContainerFinder(serialOfHolder).fillContainer(BoxFinder(serialToLoad));
			boxList.remove(BoxFinder(serialToLoad));

			Printer.printLoadBox(serialToLoad, serialOfHolder);
		}
		else {
			throw new UnknownStorageException();
		}
	
	} catch (SameStorageTypeException e) {
		System.out.println("Same storage type!");
	} catch (IllegalLoadException e) {
		System.out.println("Container can not store neither Items by themselves nor another container");
	} catch (NullPointerException e) {
		System.out.println("There is no such box!");
	} catch (UnknownStorageException e) {
		System.out.println("Unknown storage command!");
	} catch (WrongBoxException e) {
		System.out.println("Box and item type does not match!");
	} catch (VolumeNotEnoughException e) {
		System.out.println("Box " + serialOfHolder + " is full!");
		Item item = ItemFinder(serialToLoad);
		wastebin.add(item);
		Codes itemCode = ItemTypeFinder(item.getItemCode());
		switch (itemCode) {
			case SUGAR:
				rev.addUnearnedRevenue(-Codes.SUGAR.getPrice()*item.getVolume());
				break;
			case FLOUR:
				rev.addUnearnedRevenue(-Codes.FLOUR.getPrice()*item.getVolume());
				break;
			case PASTA:
				rev.addUnearnedRevenue(-Codes.PASTA.getPrice()*item.getVolume());
				break;
			case RICE:
				rev.addUnearnedRevenue(-Codes.RICE.getPrice()*item.getVolume());
				break;
			case WATER:
				rev.addUnearnedRevenue(-Codes.WATER.getPrice()*item.getVolume());
				break;
			case MILK:
				rev.addUnearnedRevenue(-Codes.MILK.getPrice()*item.getVolume());
				break;
			case OIL:
				rev.addUnearnedRevenue(-Codes.OIL.getPrice()*item.getVolume());
				break;
			default:
				break;
		}
	} catch (BoxAlreadyLoadedException e) {
		System.out.println("Box " + serialOfHolder + " is already loaded!");
		Item item = ItemFinder(serialToLoad);
		wastebin.add(item);
		Codes itemCode = ItemTypeFinder(item.getItemCode());
		switch (itemCode) {
			case SUGAR:
				rev.addUnearnedRevenue(-Codes.SUGAR.getPrice()*item.getVolume());
				break;
			case FLOUR:
				rev.addUnearnedRevenue(-Codes.FLOUR.getPrice()*item.getVolume());
				break;
			case PASTA:
				rev.addUnearnedRevenue(-Codes.PASTA.getPrice()*item.getVolume());
				break;
			case RICE:
				rev.addUnearnedRevenue(-Codes.RICE.getPrice()*item.getVolume());
				break;
			case WATER:
				rev.addUnearnedRevenue(-Codes.WATER.getPrice()*item.getVolume());
				break;
			case MILK:
				rev.addUnearnedRevenue(-Codes.MILK.getPrice()*item.getVolume());
				break;
			case OIL:
				rev.addUnearnedRevenue(-Codes.OIL.getPrice()*item.getVolume());
				break;
			default:
				break;
		}
	} catch (BoxNotFoundException e) {
		System.out.println("Box " + serialOfHolder + " is not found!");
	}
	}
	
	
	// ships the container and adds each item's revenue to the revenue
	@Override
	public void ship(String command) {
		StringTokenizer st = new StringTokenizer(command, ",");
		st.nextToken();
		containerToShip = st.nextToken();
		ArrayList<Box<Item>> contArrayList = ContainerFinder(containerToShip).getContainerStorage();

		float shippedRevenue = 0;

		for (int i = 0; i < contArrayList.size(); i++) {
			ArrayList<Item> arrayListOfBox = contArrayList.get(i).getList();
			for (int j = 0; j < arrayListOfBox.size(); j++) {
				String s = arrayListOfBox.get(j).getItemCode();
				float volume = arrayListOfBox.get(j).getVolume();
				Codes code = ItemTypeFinder(s);
				rev.addRevenue(volume * code.getPrice());
				shippedRevenue += volume * code.getPrice();
			}
		}

		Printer.printShipment(containerToShip, rev.getRevenue());
		rev.subtractShippedRevenue(shippedRevenue);
		containerList.remove(ContainerFinder(containerToShip));

	}

	// Calls the Printer class static methods to print the revenue
	@Override
	public void showRevenue(String command) {
		StringTokenizer st = new StringTokenizer(command, ",");
		st.nextToken();
		String com = st.nextToken();
		try {
			if (com.equals("1")) {
				Printer.printUnearnedRevenue(rev.getUnearnedRevenue());
			} 
			else if (com.equals("2")) {
				Printer.printTotalRevenue(rev.getRevenue());
			}
			else {
				throw new UnknownCommandException();
			}
			
		} catch (UnknownCommandException e) {
			System.out.println("Wrong command!");
		}		
	}
	/*                              *
	 * 								*
	 * 								*
	 * 								*
	 * HELPER METHODS FROM NOW ON	*
	 * 								*
	 * 								*
	 *    							*
	 * 								*/
	 
	private Item ItemFinder(String serialCode) {
		for(int i = 0; i < itemsList.size(); i++) {
			if (itemsList.get(i).getItemSerialNumber().equals(serialCode)) {
				return itemsList.get(i);
			}
		}
		return null;
	}
		
	private Box<Item> BoxFinder(String serialCode) {
		for(int i = 0; i < boxList.size(); i++) {
			if (boxList.get(i).getBoxSerialNumber().equals(serialCode)) {
				return boxList.get(i);
			}
		}
		return null;
	}
	private Container<Box<Item>> ContainerFinder(String serialCode) {
		for(int i = 0; i < containerList.size(); i++) {
			if (containerList.get(i).getContainerSerialNumber().equals(serialCode)) {
				return containerList.get(i);
			}
		}
		return null;
		
	}
	private Codes ItemTypeFinder(String s) {
		if(s.equals(Codes.MILK.getCode())) {
			return (Codes.MILK);
		}
		else if(s.equals(Codes.WATER.getCode())) {
			return(Codes.WATER);
		}
		else if(s.equals(Codes.OIL.getCode())) {
			return(Codes.OIL);
		}
		else if(s.equals(Codes.SUGAR.getCode())) {
			return (Codes.SUGAR);
		}
		else if(s.equals(Codes.FLOUR.getCode())) {
			return (Codes.FLOUR);
		}
		else if(s.equals(Codes.PASTA.getCode())) {
			return (Codes.PASTA);
		}
		else if(s.equals(Codes.RICE.getCode())) {
			return (Codes.RICE);
		}
		return null;
	}

}

