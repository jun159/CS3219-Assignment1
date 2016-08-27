// @author Luah Bao Jun

import java.util.Scanner;

public class Main {
	
	private static final String MESSAGE_WELCOME = "Welcome to KWIC system.";
	private static final String MESSAGE_ARCHITECTURE = "\n\nPlease select the architecture of your choice, either '1' or '2':\n"
			+ "1. Shared Data Architecture\n"
			+ "2. Pipe and Filter Architecture\n"
			+ "Enter your choice: ";
	private static final String MESSAGE_ARCHITECTURE_INVALID = ">> Error: You have entered an invalid response. ";
	private static final String MESSAGE_CONTINUE = "Would you like to continue using the system? (y/n): ";
	private static final String MESSAGE_CONTINUE_INVALID = ">> Error: You have entered an invalid response. Please enter either 'y' or 'n'.";
	private static final String MESSAGE_EXIT = "Thank you for using KWIC system.";
	private static final String MESSAGE_EXECUTION = "Total execution time: ";
	private static final String MESSAGE_UNIT = " ms";
	private static final String ARCHITECTURE_SHARED_DATA = "1";
	private static final String ARCHITECTURE_ADT = "2";
	private static final String OPTION_YES = "y";
	private static final String OPTION_NO = "n";
	
	private Scanner sc;
	
	public Main() {
		sc = new Scanner(System.in);
	}
	
	public void execute() {
		System.out.print(MESSAGE_WELCOME);
		while(!isSelectArchitectureValid()) {
			System.out.print(MESSAGE_ARCHITECTURE_INVALID);
		}
	}
	
	private boolean isSelectArchitectureValid() {
		System.out.print(MESSAGE_ARCHITECTURE);
		String architecture = sc.nextLine();
		long startTime = System.currentTimeMillis();
		long endTime = 0;
		boolean isValid = true;
		
		if (architecture.equals(ARCHITECTURE_SHARED_DATA)) {
			shareddata.MasterControl masterControl = new shareddata.MasterControl();
			masterControl.execute();
			endTime = System.currentTimeMillis();
			System.out.println(MESSAGE_EXECUTION + (endTime - startTime) + MESSAGE_UNIT + "\n");
			selectContinueProgram();
		} else if (architecture.equals(ARCHITECTURE_ADT)) {
			// TODO - Insert MasterControl from another architecture
			endTime = System.currentTimeMillis();
			System.out.println(MESSAGE_EXECUTION + (endTime - startTime) + MESSAGE_UNIT + "\n");
			selectContinueProgram();
		} else {
			isValid = false;
		}
		
		return isValid;
	}
	
	private void selectContinueProgram() {
		System.out.print(MESSAGE_CONTINUE);
		String cont = sc.nextLine();
		
		if(cont.equals(OPTION_YES)) {
			while(!isSelectArchitectureValid()) {
				System.err.print(MESSAGE_ARCHITECTURE_INVALID);
			}
		} else if(cont.equals(OPTION_NO)) {
			System.out.println(MESSAGE_EXIT);
			System.exit(0);
		} else {
			System.out.println(MESSAGE_CONTINUE_INVALID);
			selectContinueProgram();
		}
	}

	public static void main(String[] args) {	
		Main main = new Main();
		main.execute();
	}
	
}
