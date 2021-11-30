// Trent Boughner
package team4package;

import java.util.Scanner;

public class ProviderTerminal {
	public static void main(String args[]) {
		ProviderTerminal pt = new ProviderTerminal();
		while(true) {
			pt.prompt();
		}
	}
	
	Scanner userInput;

	
	ProviderTerminal() {
		userInput = new Scanner(System.in);
		DatabaseManager db = new DatabaseManager();
	}
	
	public void prompt() {
		boolean invalid = true;
		
		while(invalid) {
			System.out.println("Enter Command. Type \"help\" for reference.");
			String response = userInput.nextLine();
			
			if(response == "help") { // Allows user to be given reference information.
				System.out.println("Please use the convention: [Report Type] [ID]");
				System.out.println("Acceptable report types are: ");
				System.out.println("ID is only needed for Provider and Member.");
				response = userInput.nextLine();
			}
			// Splitting input string into command line arguments
			String[] args = response.split(" ");
			
			if(args.length < 1) {
				System.out.println("Command is invalid.");
			} 
			else {
				System.out.println("Enter member number: ");
				int memberID = userInput.nextInt();
				int memberIDmatch = db.checkID(memberID);
				
				if (/*fill in*/) {
					System.out.println("Validated");
				}
				else {
					System.out.println("Invalid Number");
				}
			}
		}
	}
}
