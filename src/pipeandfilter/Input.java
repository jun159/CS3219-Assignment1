// @author Varunica

package pipeandfilter;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Input extends Filter{
	
	private static final String MESSAGE_INPUT_FILE_WORDS = "\nEnter the input file name for words to ignore \n>> Ensure file is in src folder and separate each word by new line: ";
	private static final String MESSAGE_INPUT_FILE_TITLES = "Enter the input file name for titles \n>> Ensure file is in src folder and separate each title by new line: ";
	private static final String MESSAGE_OUTPUT_FILE = "Enter the output file name: ";
	private static final String MESSAGE_ERROR_FILE = ">> Error: Invalid file name, please try again: ";
	private static final String REGEX = "\\s+";
	
	private Scanner sc;
	static ArrayList<String> titlesList = new ArrayList<String>();
	static ArrayList<String> ignoreWordsList = new ArrayList<String>();
	static String outputFileName;
	static ArrayList<String> outputFileList = new ArrayList<String>();
	
	public Input(){
		
	}
	
	@Override
	public void run() {
		
		sc = new Scanner(System.in);
		ignoreWordsList = getIgnoreWords();
		titlesList = getTitles();
		outputFileName = getFileName(false);
		
		outputFileList.add(outputFileName);
		pipeUsed.addList(outputFileList);
		pipeUsed.addList(titlesList);
		pipeUsed.addList(ignoreWordsList);
		
	}
	
	private ArrayList<String> getIgnoreWords() {
		ArrayList<String> ignoreWords = new ArrayList<String>();
		System.out.print(MESSAGE_INPUT_FILE_WORDS);
		String inputFileName = getFileName(true);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFileName));
			String word;
			while ((word = br.readLine()) != null) {
				ignoreWords.add(word.toLowerCase().replaceAll(REGEX, " ").trim());
	        }
		} catch(IOException e) {
			System.out.println(MESSAGE_ERROR_FILE);
			return null;
		}
		
		return ignoreWords;
	}
	
	private ArrayList<String> getTitles() {
		ArrayList<String> titles = new ArrayList<String>();
		System.out.print(MESSAGE_INPUT_FILE_TITLES);
		String inputFileName = getFileName(true);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFileName));
			String title;
			while ((title = br.readLine()) != null) {
				String[] splitTitle = title.split(" ");
				StringBuilder currentTitle = new StringBuilder();
				for(String word : splitTitle) {
					currentTitle.append(formatWord(word.toLowerCase().trim())).append(" ");
				}
				titles.add(currentTitle.toString().replaceAll(REGEX, " ").trim());
	        }
		} catch(IOException e) {
			System.out.println(MESSAGE_ERROR_FILE);
			return null;
		}
		
		return titles;
	}
	
	private String getFileName(boolean isInput) {
		
		if(!isInput) {
			System.out.print(MESSAGE_OUTPUT_FILE);
		}
		
		boolean isInvalid = true;
		String fileName = "";
		
		while(isInvalid) {
			fileName = sc.nextLine();
			if(fileName.isEmpty()) {
				System.out.print(MESSAGE_ERROR_FILE);
			} else if(isFileNameValid(fileName, isInput)) {
				isInvalid = false;
			} else {
				System.out.print(MESSAGE_ERROR_FILE);
			}
		}
		
		return fileName;
	}
	
	private boolean isFileNameValid(String fileName, boolean isInput) {
		File file = new File(fileName);
		boolean isValid = true;
		
		if(isInput) {
			if(!(file.exists() && !file.isDirectory())) { 
			    isValid = false;
			}
		} else {
			try{
				new FileWriter(file, true);
			} catch(IOException e) {
				System.out.print(MESSAGE_ERROR_FILE);
				isValid = false;
			}
		}
		
		return isValid;
	}
	
	private String formatWord(String word) {
		if(ignoreWordsList.contains(word)) {
			word = word.toLowerCase();
		} else if(word.length() > 0) {
			word = Character.toString(word.charAt(0)).toUpperCase() + word.substring(1);
		}
		
		return word;
	}
}