package SharedData;

import java.util.ArrayList;

public class Output {
	
	private static final String MESSAGE_DIVIDER = "-------------------------------------------";
	private static final String MESSAGE_RESULTS = "\nShared Data Architecture Results:";
	
	public void outputResults(ArrayList<String> results) {
		System.out.println(MESSAGE_RESULTS);
		System.out.println(MESSAGE_DIVIDER);
		
		for(String line : results) {
			System.out.println(line);
		}
		
		System.out.println(MESSAGE_DIVIDER + "\n");
	}
	
}