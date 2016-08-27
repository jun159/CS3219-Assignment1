// @author Luah Bao Jun

package shareddata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Input {

	private static final String MESSAGE_INPUT_FILE_WORDS = "\nEnter the input file name for words to ignore (Separate each word by new line): ";
	private static final String MESSAGE_INPUT_FILE_TITLES = "Enter the input file name for titles (Separate each title by new line): ";
	private static final String MESSAGE_OUTPUT_FILE = "Enter the output file name: ";
	private static final String MESSAGE_ERROR_FILE = ">> Error: Invalid file name, please try again: ";
	private static final String MESSAGE_ERROR = ">> Error: An error occured when reading the file. Please try again.";
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
		System.out.print(MESSAGE_OUTPUT_FILE);
		storage.setOutputFileName(getFileName());
	}
	
	private HashSet<String> getWordsToIgnore() {
		System.out.print(MESSAGE_INPUT_FILE_WORDS);
		String inputFileName = getFileName();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFileName));
			String word;
			while ((word = br.readLine()) != null) {
				wordsToIgnore.add(word.toLowerCase().replaceAll(REGEX, TOKEN_SPACE).trim());
	        }
		} catch(IOException e) {
			System.out.println(MESSAGE_ERROR);
		}
		
		return wordsToIgnore;
	}
	
	private ArrayList<String> getTitles() {
		System.out.print(MESSAGE_INPUT_FILE_TITLES);
		String inputFileName = getFileName();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFileName));
			String title;
			while ((title = br.readLine()) != null) {
				String[] splitTitle = title.split(TOKEN_SPACE);
				StringBuilder currentTitle = new StringBuilder();
				for(String word : splitTitle) {
					currentTitle.append(formatWord(word.toLowerCase().trim())).append(TOKEN_SPACE);
				}
				titles.add(currentTitle.toString().replaceAll(REGEX, TOKEN_SPACE).trim());
	        }
		} catch(IOException e) {
			System.out.println(MESSAGE_ERROR);
		}
		
		return titles;
	}
	
	private String getFileName() {
		
		boolean isScan = true;
		String fileName = "";
		
		while(isScan) {
			fileName = sc.nextLine();
			if(fileName.isEmpty()) {
				System.out.print(MESSAGE_ERROR_FILE);
			} else if(isFileNameValid(fileName)) {
				isScan = false;
			}
		}
		
		return fileName;
	}
	
	private boolean isFileNameValid(String outputFile) {
		boolean isValid = true;
		
		try{
			new FileWriter(new File(outputFile), true);
		} catch(IOException e) {
			System.out.print(MESSAGE_ERROR_FILE);
			isValid = false;
		}
		
		return isValid;
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