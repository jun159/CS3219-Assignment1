package SharedData;

import java.util.ArrayList;
import java.util.HashSet;

public class CircularShift {
	
	private static final String TOKEN = " ";
	
	public ArrayList<String> processCircularShift(ArrayList<String> titles,
			HashSet<String> wordsToIgnore) {
		ArrayList<String> results = new ArrayList<String>();
		
		for(String title : titles) {
			String head = title.split(TOKEN)[0].toLowerCase().trim();
			if(!wordsToIgnore.contains(head)) {
				results.add(title);
			}
			
			while(true) {
				String[] current = shiftWords(title.split(TOKEN));
				String resultTitle = formatTitle(current);
				String currentHead = current[0].toLowerCase().trim();
				
				if(!currentHead.equals(head)) {
					if(!wordsToIgnore.contains(currentHead)) {
						results.add(resultTitle);
					}
				} else {
					break;
				}
				
				title = resultTitle;
			} 
		}
		
		return results;
	}
	
	private String formatTitle(String[] current) {
		String title = "";
		
		for(String word : current) {
			title += word + " ";
		}
		
		return title;
	}
	
	private String[] shiftWords(String[] shifted) {
		String[] current = new String[shifted.length];
		int length = shifted.length;
		
		for(int i = 0; i < length; i++) {
			current[(i + 1) % length] = shifted[i];
		}
		
		return current;
	}
}