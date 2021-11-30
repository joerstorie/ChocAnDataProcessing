// Trent Boughner
package team4package;

import java.io.IOException;
import java.util.Scanner;

public class ProviderTerminal {
	DatabaseManager db;
	
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
				System.out.println("Enter \"Directory\" to receive a list of services offered.");
				System.out.println("Enter \"Service\" to apply a service to a member.");
				response = userInput.nextLine();
			}
			// Splitting input string into command line arguments
			String[] args = response.split(" ");
			
			if(args.length < 1) {
				System.out.println("Please input a command.");
			} else if(args[0].equals("Directory")) {
				
			} else if(args[0].equals("Service")) {
				System.out.println("Enter member ID:");
				int memberID = userInput.nextInt();
				boolean verified = db.validateMemberID(memberID);
				if (verified) {
					System.out.println("Member ID Validated");
					applyService(memberID);
				}
				else {
					System.out.println("Invalid Number. Please check your input and try again.");
				}
			}
		}
	}
	
	private void applyService(int memberID) {
		
	}
}
