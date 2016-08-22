package SharedData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Input {

	private static final String MESSAGE_OUTPUT_FILE = "Enter the output file name: ";
	private static final String MESSAGE_OUTPUT_FILE_EMPTY = "Invalid file name, please try again: ";
	private static final String MESSAGE_WORDS_TO_IGNORE = "\nEnter words to ignore, separated by each line (Terminate input by entering empty line): ";
	private static final String MESSAGE_TITLE = "Enter titles, separated by each line (Terminate input by entering empty line): ";
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
		storage.setOutputFileName(getOutputFileName());
	}
	
	private String getOutputFileName() {
		System.out.print(MESSAGE_OUTPUT_FILE);
		String outputFile;
		
		while((outputFile = sc.nextLine()).isEmpty()) {
			System.out.print(MESSAGE_OUTPUT_FILE_EMPTY);
		}
		
		return outputFile;
	}
	
	private HashSet<String> getWordsToIgnore() {
		System.out.println(MESSAGE_WORDS_TO_IGNORE);
		String input = sc.nextLine();
		
		while (!input.isEmpty()) {
			wordsToIgnore.add(input.toLowerCase().replaceAll(REGEX, TOKEN_SPACE).trim());
            input = sc.nextLine();
        }
		
		return wordsToIgnore;
	}
	
	private ArrayList<String> getTitles() {
		System.out.println(MESSAGE_TITLE);
		String input = sc.nextLine();
		
		while (!input.isEmpty()) {
			String[] splitTitle = input.split(TOKEN_SPACE);
			StringBuilder currentTitle = new StringBuilder();
			for(String word : splitTitle) {
				currentTitle.append(formatWord(word.toLowerCase().trim())).append(TOKEN_SPACE);
			}
			titles.add(currentTitle.toString().trim());
			input = sc.nextLine();
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