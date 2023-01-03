package Market;

public class Printer {
    public Printer() {
        super();
    }

    public static void printProduction(Item item, Codes code) {
        String nameOfProduct = code.toString();
        float volumeOfProduct = item.getVolume();
        String serialOfProduct = item.getItemSerialNumber();

        if (item instanceof Countable) {
            switch (nameOfProduct) {
                case "MILK":
                    System.out.println(volumeOfProduct+ "liter of box of" + nameOfProduct.toLowerCase() + " has been produced with the serial number" + serialOfProduct +"\n");
                    break;
                case "WATER":
                    System.out.println(volumeOfProduct+ "liter of box of" + nameOfProduct.toLowerCase() + " has been produced with the serial number" + serialOfProduct +"\n");
                    break;
                case "OIL":
                    System.out.println(volumeOfProduct+ "liter of box of" + nameOfProduct.toLowerCase() + " has been produced with the serial number" + serialOfProduct +"\n");
                    break;
                default:
                    break;
            }
        }
        else {
            float massOfProduct = ((Uncountable) item).getMass();
            switch (nameOfProduct) {
                case "SUGAR":
                    System.out.println(massOfProduct+ "kilogram of" + nameOfProduct.toLowerCase() + " has been produced with the serial number" + serialOfProduct +"\n");
                    break;
                case "FLOUR":
                    System.out.println(massOfProduct+ "kilogram of" + nameOfProduct.toLowerCase() + " has been produced with the serial number" + serialOfProduct +"\n");
                    break;
                case "PASTA":
                    System.out.println(massOfProduct+ "kilogramof" + nameOfProduct.toLowerCase() + " has been produced with the serial number" + serialOfProduct +"\n");
                    break;
                case "RICE":
                    System.out.println(massOfProduct+ "kilogram of" + nameOfProduct.toLowerCase() + " has been produced with the serial number" + serialOfProduct +"\n");
                    break;
                default:
                    break;
            }
        }

        
    }

    public static void printProduction(Box<Item> box) {
        String boxSerial = box.getBoxSerialNumber();
        float boxVolume = box.getVolume();

        if (box instanceof CountableBox) {
            int boxNum = ((CountableBox<Item>) box).getNumber();
            System.out.println(boxVolume + " liter of number box has been produced with capacity of " + boxNum
                    + " with the serial number " + boxSerial +"\n");
        } else {
            float boxMass = ((UncountableBox<Item>) box).getMass();
            System.out.println(boxVolume + " liter of mass box has been produced with capacity of " + boxMass
                    + "kg with the serial number " + boxSerial +"\n");
        }
    }
    
    public static void printProduction(Container<Box<Item>> cont) {
        float contVolume = cont.getVolume();
        String contSerial = cont.getContainerSerialNumber();

        System.out.println(contVolume + " liters of container has been produced with the serial number " + contSerial +"\n");
    }

    public static void printLoadItem(String itemSer, String boxSer) {
        System.out.println("Item " + itemSer + " has been placed in the box " + boxSer +"\n");
    }

    public static void printLoadBox(String boxSer, String contSer) {
        System.out.println("Box " + boxSer + " has been placed in the container " + contSer +"\n");
    }

    public static void printShipment(String contSer, float revenue) {
        System.out.println("Container " + contSer + " has been shipped");
        System.out.println("Revenue: " + revenue + "TL" +"\n");
    }

    public static void printRevenue(float revenue) {
        System.out.println("Revenue: " + revenue + "TL" +"\n");
    }
    
    public static void printTotalRevenue(float revenue) {
        System.out.println("Total Revenue: " + revenue + "TL" +"\n");
    }

    public static void printUnearnedRevenue(float revenue) {
        System.out.println("Unearned Revenue: " + revenue + "TL" +"\n");
    }
}
