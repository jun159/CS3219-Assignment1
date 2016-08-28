// @author Luah Bao Jun

package shareddata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Alphabetizer {
	
	private Storage storage;
	private ArrayList<String> results;

	public Alphabetizer() {
		storage = Storage.getInstance();
		results = storage.getResults();
	}
	
	public void sort() {
		Collections.sort(results, String.CASE_INSENSITIVE_ORDER);
		storage.setResults(results);
	}
	
}