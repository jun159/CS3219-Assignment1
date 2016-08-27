package SharedData;

public class MasterControl {
	
	public void execute() {
		Input input = new Input();
		input.input();
		
		CircularShift circularShift = new CircularShift();
		circularShift.shift();
		
		Alphabetizer alphabetizer = new Alphabetizer();
		alphabetizer.sort();
		
		Output output = new Output();
		output.output();
	}
	
}