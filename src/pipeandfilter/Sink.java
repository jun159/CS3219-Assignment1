// @author Varunica

package pipeandfilter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Sink extends Filter {
	
	private static final String MESSAGE_OUTPUT = ">>> Output is saved in file: %1$s";
	private ArrayList<String> sortedShiftedTitles = new ArrayList<String>();
	private String outputFileName;
	
	public Sink() {
		//System.out.println(allLists);
	}
	
	@Override
	public void run() {
		sortedShiftedTitles = pipeUsed.allLists.get(4);
		outputFileName = pipeUsed.allLists.get(0).get(0);
		
		/*for(String element : sortedShiftedTitles){
			System.out.println(element);
		} */
		sink();
	}
	
	public void sink() {		
		PrintWriter writer = getFileWriter();
		int size = sortedShiftedTitles.size();
		
		for(int i = 0; i < size; i++) {
			String line = sortedShiftedTitles.get(i);
			if(i != (size - 1)) {
				writer.println(line.trim()); 
			} else {
				writer.print(line.trim()); 
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