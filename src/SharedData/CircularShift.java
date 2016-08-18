package SharedData;

import java.util.ArrayList;
import java.util.HashSet;

public class CircularShift {
	
	private static final String TOKEN = " ";
	
	private Storage storage;
	private ArrayList<String> titles;
	private HashSet<String> wordsToIgnore;
	private ArrayList<String> results;
	
	public CircularShift() {
		storage = Storage.getInstance();
		titles = storage.getTitles();
		wordsToIgnore = storage.getWordsToIgnore();
		results = new ArrayList<String>();
	}
	
	public void shift() {
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
		
		storage.setResults(results);
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