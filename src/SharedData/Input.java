package SharedData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Input {

	private static final String MESSAGE_TITLE = "Enter a list of titles (Use comma to separate each title): ";
	private static final String MESSAGE_WORDS_TO_IGNORE = "Enter a list of words to ignore (Use comma to separate each word): ";
	private static final String TOKEN = ",";
	
	private Scanner sc;
	private ArrayList<String> titles;
	private HashSet<String> wordsToIgnore;
	
	public Input() {
		sc = new Scanner(System.in);
		titles = new ArrayList<String>();
		wordsToIgnore = new HashSet<String>();
	}

	public ArrayList<String> getTitles() {
		System.out.print(MESSAGE_TITLE);
		String[] titleArray = sc.nextLine().split(TOKEN);
		for(String title : titleArray) {
			titles.add(title.replaceAll("\\s+", " ").trim());
		}
		
		return titles;
	}
	
	public HashSet<String> getWordsToIgnore() {
		System.out.print(MESSAGE_WORDS_TO_IGNORE);
		String[] wordsToIgnoreArray = sc.nextLine().split(TOKEN);
		for(String wordToIgnore : wordsToIgnoreArray) {
			wordsToIgnore.add(wordToIgnore.toLowerCase().replaceAll("\\s+", " ").trim());
		}
		
		return wordsToIgnore;
	}
	
}