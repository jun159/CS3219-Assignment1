package SharedData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Alphabetizer {
	
	public ArrayList<String> sort(ArrayList<String> results) {
		Collections.sort(results, new Comparator<String>() {
            public int compare(String left, String right) {
                return left.compareTo(right);
            }        
        });;
        
		return results;
	}
	
}