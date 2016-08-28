// @author Luah Bao Jun

import java.util.Scanner;

public class Main {
	
	private static final String MESSAGE_WELCOME = "Welcome to KWIC system.";
	private static final String MESSAGE_ARCHITECTURE = "\n\nPlease select the architecture of your choice, either '1' or '2':\n"
			+ "1. Shared Data Architecture\n"
			+ "2. Pipe and Filter Architecture\n"
			+ "Enter your choice: ";
	private static final String MESSAGE_ARCHITECTURE_INVALID = ">> Error: You have entered an invalid response. ";
	private static final String MESSAGE_EXIT = "Thank you for using KWIC system.";
	private static final String MESSAGE_EXECUTION = "Total execution time: ";
	private static final String MESSAGE_UNIT = " ms";
	private static final String ARCHITECTURE_SHARED_DATA = "1";
	private static final String ARCHITECTURE_ADT = "2";
	
	private Scanner sc;
	
	public Main() {
		sc = new Scanner(System.in);
	}
	
	public void execute() {
		System.out.print(MESSAGE_WELCOME);
		while(!isSelectArchitectureValid()) {
			System.out.print(MESSAGE_ARCHITECTURE_INVALID);
		}
		System.out.println(MESSAGE_EXIT);
	}
	
	private boolean isSelectArchitectureValid() {
		System.out.print(MESSAGE_ARCHITECTURE);
		String architecture = sc.nextLine();
		long startTime = System.currentTimeMillis();
		long endTime = 0;
		boolean isValid = true;
		
		if (architecture.equals(ARCHITECTURE_SHARED_DATA) || architecture.equals(ARCHITECTURE_ADT)) {
			if (architecture.equals(ARCHITECTURE_SHARED_DATA)) {
				shareddata.MasterControl masterControl = new shareddata.MasterControl();
				masterControl.execute();
			} else if (architecture.equals(ARCHITECTURE_ADT)) {
				pipeandfilter.MasterControl masterControl = new pipeandfilter.MasterControl();
				masterControl.execute();
			}
			
			endTime = System.currentTimeMillis();
			System.out.println(MESSAGE_EXECUTION + (endTime - startTime) + MESSAGE_UNIT + "\n");
		} else {
			isValid = false;
		}
		
		return isValid;
	}

	public static void main(String[] args) {	
		Main main = new Main();
		main.execute();
	}
	
}
