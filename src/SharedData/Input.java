package SharedData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Input {

	private static final String MESSAGE_WORDS_TO_IGNORE = "Enter a list of words to ignore (Use comma to separate each word): ";
	private static final String MESSAGE_TITLE = "Enter a list of titles (Use comma to separate each title): ";
	private static final String TOKEN_COMMA = ",";
	private static final String TOKEN_SPACE = " ";
	private static final String REGEX = "\\s+";
	
	private Scanner sc;
	private Storage storage;
	private HashSet<String> wordsToIgnore;
	private ArrayList<String> titles;
	
	public Input() {
		sc = new Scanner(System.in);
		storage = Storage.getInstance();
		wordsToIgnore = new HashSet<String>();
		titles = new ArrayList<String>();
	}
	
	public void input() {
		storage.setWordsToIgnore(getWordsToIgnore());
		storage.setTitles(getTitles());
	}
	
	private HashSet<String> getWordsToIgnore() {
		System.out.print(MESSAGE_WORDS_TO_IGNORE);
		String[] wordsToIgnoreArray = sc.nextLine().split(TOKEN_COMMA);
		for(String wordToIgnore : wordsToIgnoreArray) {
			wordsToIgnore.add(wordToIgnore.toLowerCase().replaceAll(REGEX, TOKEN_SPACE).trim());
		}
		
		return wordsToIgnore;
	}
	
	private ArrayList<String> getTitles() {
		System.out.print(MESSAGE_TITLE);
		String[] titleArray = sc.nextLine().replaceAll(REGEX, TOKEN_SPACE).split(TOKEN_COMMA);
		for(String title : titleArray) {
			String[] splitTitle = title.split(TOKEN_SPACE);
			StringBuilder currentTitle = new StringBuilder();
			for(String word : splitTitle) {
				currentTitle.append(formatWord(word.toLowerCase().trim())).append(TOKEN_SPACE);
			}
			titles.add(currentTitle.toString().trim());
		}
		
		return titles;
	}
	
	private String formatWord(String word) {
		if(wordsToIgnore.contains(word)) {
			word = word.toLowerCase();
		} else if(word.length() > 0) {
			word = Character.toString(word.charAt(0)).toUpperCase() + word.substring(1);
		}
		
		return word;
	}
}