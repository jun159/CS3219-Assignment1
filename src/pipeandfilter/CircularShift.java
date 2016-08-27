// @author Varunica

package pipeandfilter;

import java.util.ArrayList;

public class CircularShift extends Filter {
	
	static ArrayList<String> allShiftedTitles = new ArrayList<String>();
	final static String TOKEN_SPACE = " ";
	static ArrayList<String> titles = new ArrayList<String>();
	static ArrayList<String> ignoreWords = new ArrayList<String>();

	
	@Override
	public void run() {
		
		String title;
		titles = pipeUsed.allLists.get(1);
		ignoreWords = pipeUsed.allLists.get(2);
		
		for(int i=0; i< titles.size(); i++){
			title = titles.get(i);
			circularShift(title, ignoreWords);
		}
		
		pipeUsed.addList(allShiftedTitles);
		
	}


	public static void circularShift(String title, ArrayList<String> ignoreWords) {
		
		String[] wordsInTitle = title.split(TOKEN_SPACE);
		String shiftedTitle;
		int count = 0;
		
		int length = wordsInTitle.length;
		
		for(int i=0; i < length; i++){
			
			for (String ignoreWord : ignoreWords){
				
				if (wordsInTitle[0].equals(ignoreWord)){
					wordsInTitle = shifter(wordsInTitle);
					count = 1;
					break;
				}
				
			}
			
			if (count == 0) {
				shiftedTitle = joinTitle(wordsInTitle);
				allShiftedTitles.add(shiftedTitle);
				wordsInTitle = shifter(wordsInTitle);
			}
			count = 0;
		}
	}

	
	public static String[] shifter(String[] wordsInTitle){
		
		int length = wordsInTitle.length;
		String newTail = wordsInTitle[0];
		
		for(int j=0; j<length; j++){
			if (j<length-1){
				wordsInTitle[j] = wordsInTitle[j+1];
			}
		}
		
		wordsInTitle[length-1] = newTail;
		
		return wordsInTitle;
		
	}
	
	
	private static String joinTitle(String[] wordsInTitle) {
		
		StringBuilder title = new StringBuilder();
			
		for(String word : wordsInTitle) {
			title.append(word + " ");
		}
			
		return title.toString();
	}

}