package SharedData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Output {
	
	private static final String MESSAGE_OUTPUT = ">>> Output is saved in \"%1$s\"";
	private Storage storage;
	private ArrayList<String> results;
	private String outputFileName;
	
	public Output() {
		storage = Storage.getInstance();
		outputFileName = storage.getOutputFileName();
		results = storage.getResults();
	}
	
	public void output() {		
		PrintWriter writer = getFileWriter();
		int size = results.size();
		
		for(int i = 0; i < size; i++) {
			String line = results.get(i);
			if(i != (size - 1)) {
				writer.println(line); 
			} else {
				writer.print(line); 
			}
		}
		
		writer.flush();
		writer.close(); 
		
		System.out.println(String.format(MESSAGE_OUTPUT, outputFileName));
	}
	
	private PrintWriter getFileWriter() {
		try {
			File oldFile = new File(outputFileName);
			if(oldFile.exists()) {
				oldFile.delete();
			}
			File newFile = new File(outputFileName);
			return new PrintWriter(new FileWriter(newFile, true), true);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}