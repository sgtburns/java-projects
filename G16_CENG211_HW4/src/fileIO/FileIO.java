package fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {
	private boolean i= true;
	private	String line;
	private ArrayList<String> allCommands =new ArrayList<String>();
	
	public void readingCsvFile(String path) throws IOException,FileNotFoundException {
		
		
		
		try {
		BufferedReader br= new BufferedReader(new FileReader(path));
		
		
		
		while (i) {
			this.line = br.readLine();
			if (this.line == null || this.line.equals("")) {
				i = false;
				allCommands.trimToSize();

			} else {
				allCommands.add(line);
			}

		}
		br.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		
	}
		catch(IOException e) {
			System.out.println("IO exception.");
			System.exit(0);
			
	}

}
public ArrayList<String> getAllCommands(){
		return allCommands;
}

}