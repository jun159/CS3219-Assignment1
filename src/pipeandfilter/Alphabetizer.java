// @author Varunica

package pipeandfilter;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer extends Filter {

	static ArrayList<String> sortedShiftedTitles = new ArrayList<String>();
	static ArrayList<String> allShiftedTitles = new ArrayList<String>();
	
	@Override
	public void run() {
		
		allShiftedTitles = pipeUsed.allLists.get(3);
		sort(allShiftedTitles);
		sortedShiftedTitles = allShiftedTitles;
		pipeUsed.addList(sortedShiftedTitles);

	}

	public static void sort(ArrayList<String> allShiftedTitles) {
		
		Collections.sort(allShiftedTitles, String.CASE_INSENSITIVE_ORDER);
		
		/* alternative method, if required 
		Collections.sort(allShiftedTitles, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            return s1.compareToIgnoreCase(s2);
	        }
	    });
	    */
	}

}

