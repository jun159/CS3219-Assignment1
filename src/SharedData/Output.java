package SharedData;

import java.util.ArrayList;

public class Output {
	
	private static final String MESSAGE_DIVIDER = "-------------------------------------------";
	private static final String MESSAGE_RESULTS = "\nShared Data Architecture Results:";
	
	private Storage storage;
	private ArrayList<String> results;
	
	public Output() {
		storage = Storage.getInstance();
		results = storage.getResults();
	}
	
	public void output() {
		System.out.println(MESSAGE_RESULTS);
		System.out.println(MESSAGE_DIVIDER);
		
		for(String line : results) {
			System.out.println(line);
		}
		
		System.out.println(MESSAGE_DIVIDER + "\n");
	}
	
}