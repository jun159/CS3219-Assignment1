// @author Luah Bao Jun

package shareddata;

import java.util.ArrayList;
import java.util.HashSet;

public class CircularShift {
	
	private static final String TOKEN_SPACE = " ";
	
	private Storage storage;
	private HashSet<String> wordsToIgnore;
	private ArrayList<String> titles;
	private ArrayList<String> results;
	
	public CircularShift() {
		storage = Storage.getInstance();
		wordsToIgnore = storage.getWordsToIgnore();
		titles = storage.getTitles();
		results = new ArrayList<String>();
	}
	
	public void shift() {
		for(String title : titles) {
			String[] splitTitle = title.split(TOKEN_SPACE);
			String head = splitTitle[0].toLowerCase().trim();
			int size = splitTitle.length;
			int headIndex = 0;
			
			if(!wordsToIgnore.contains(head)) {
				results.add(title);
			}
			
			while(true) {
				String[] current = shiftWords(title.split(TOKEN_SPACE));
				String resultTitle = formatTitle(current);
				String currentHead = current[0].toLowerCase().trim();
				
				if((++headIndex % size) != 0) {
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
	
	private String[] shiftWords(String[] shifted) {
		String[] current = new String[shifted.length];
		int length = shifted.length;
		
		for(int i = 0; i < length; i++) {
			current[(i + 1) % length] = shifted[i];
		}
		
		return current;
	}
	
	private String formatTitle(String[] current) {
		StringBuilder title = new StringBuilder();
		
		for(String word : current) {
			title.append(word).append(TOKEN_SPACE);
		}
		
		return title.toString();
	}
}