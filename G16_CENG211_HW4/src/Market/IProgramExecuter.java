package Market;

import java.util.ArrayList;

public interface IProgramExecuter {
	public void load(String command);
	
	public void ship(String command);
	
	public void produce(String command);
	
	public void showRevenue(String command);
	
	public void start();
	
	public void selectAction(ArrayList<String> theArray);
}
