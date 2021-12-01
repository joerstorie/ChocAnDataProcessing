// Trent Boughner
package team4package;

import java.io.IOException;
import java.util.Scanner;

class Simulator{
	
	Scanner userInput;
	private static DatabaseManager db;
	
	// Creates scanner function that scans in user's input
	Simulator(){
		userInput = new Scanner(System.in);
	}
	
	// Creates instance of simulator and and prompt
	public static void main(String args[]) throws IOException {
		Simulator sim = new Simulator();
		db = DBSetup();
		sim.prompt();
		db.exportDatabase();
		return;
	}
	
	public static DatabaseManager DBSetup() throws IOException {
		DatabaseManager tempDB = DatabaseManager.getInstance();
		tempDB.importDatabase();
		return tempDB;
	}
	
	// Prompts user to choose provider, manager, or operator terminal
	private void prompt() throws IOException {
		boolean ongoing = true;
		while(ongoing) {
			System.out.println("Choose a terminal. Options are: \"Provider\", \"Manager\", \"Operator\"");
			System.out.println("Input \"exit\" to end the simulation. All modifications will be saved.");
			String response = userInput.nextLine();
			String[] args = response.split(" ");
			if(args.length < 1) {
				System.out.println("Please input a choice.");
			} else if(args[0].equals("Provider")) {
				// Open Provider Terminal
				ProviderTerminal pt = new ProviderTerminal();
				pt.prompt();
			} else if(args[0].equals("Manager")) {
				// Open Manager Terminal
				ManagerTerminal mt = new ManagerTerminal();
				mt.prompt();
			} else if(args[0].equals("Operator")) {
				// Open Operator Terminal
				OperatorTerminal ot = new OperatorTerminal();
				ot.prompt();
			} else if(args[0].equals("exit")){
				ongoing = false;
			} else {
				System.out.println("Invalid choice.");
			}
		}
		System.out.println("Simulation complete.");
		return;
	}
}