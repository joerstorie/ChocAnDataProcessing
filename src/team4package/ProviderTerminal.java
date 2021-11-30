// Trent Boughner
package team4package;

import java.io.IOException;
import java.util.Scanner;

public class ProviderTerminal {
	DatabaseManager db;
	public static void main(String args[]) throws IOException {
		ProviderTerminal pt = new ProviderTerminal();
		while(true) {
			pt.prompt();
		}
	}
	
	Scanner userInput;
	
	ProviderTerminal() throws IOException {
		userInput = new Scanner(System.in);
		db = DatabaseManager.getInstance();
	}
	
	public void prompt() {
		boolean invalid = true;
		
		while(invalid) {
			System.out.println("Enter Command. Type \"help\" for reference.");
			String response = userInput.nextLine();
			
			if(response.equals("help")) { // Allows user to be given reference information.
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
				boolean verified = db.validateMemberID(memberID);
				
				if (verified) {
					System.out.println("Validated");
				}
				else {
					System.out.println("Invalid Number");
				}
			}
		}
	}
}
