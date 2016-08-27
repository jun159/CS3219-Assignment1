// @author Luah Bao Jun

package shareddata;

import java.util.ArrayList;
import java.util.HashSet;

public class Storage {

	private static Storage storage;
	
	private HashSet<String> wordsToIgnore;
	private ArrayList<String> titles;
	private ArrayList<String> results;
	private String outputFileName;
	
	public static Storage getInstance() {
		if(storage == null) {
			storage = new Storage();
		}
		
		return storage;
	}
	
	public HashSet<String> getWordsToIgnore() {
		return wordsToIgnore;
	}
	
	public void setWordsToIgnore(HashSet<String> wordsToIgnore) {
		this.wordsToIgnore = wordsToIgnore;
	}
	
	public ArrayList<String> getTitles() {
		return titles;
	}
	
	public void setTitles(ArrayList<String> titles) {
		this.titles = titles;
	}
	
	public ArrayList<String> getResults() {
		return results;
	}
	
	public void setResults(ArrayList<String> results) {
		this.results = results;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}
	
}
