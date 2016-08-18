package SharedData;

import java.util.ArrayList;
import java.util.HashSet;

public class MasterControl {
	
	private Input input;
	private CircularShift circularShift;
	private Alphabetizer alphabetizer;
	private Output output;
	
	public MasterControl() {
		input = new Input();
		circularShift = new CircularShift();
		alphabetizer = new Alphabetizer();
		output = new Output();
	}
	
	public void execute() {
		ArrayList<String> titles = input.getTitles();
		HashSet<String> wordsToIgnore = input.getWordsToIgnore();
		ArrayList<String> results = circularShift.processCircularShift(titles, wordsToIgnore);
		results = alphabetizer.sort(results);
		output.outputResults(results);
	}
	
}