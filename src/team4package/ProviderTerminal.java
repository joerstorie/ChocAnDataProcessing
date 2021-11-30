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
			// Splitting input string into args
			String[] args = response.split(" ");
			
			if(args.length < 1) {
				System.out.println("Command is invalid.");
			} 
			else {
				System.out.println("Enter member number: ");
				int memberID = userInput.nextInt();
				boolean memberIDmatch = DatabaseManager(memberID); 
				if .equals(memberID, memberIDmatch) {
					System.out.println("Invalid Number");
					
					/*if (feesOwed != 0) {
						System.out.println("Validated");
					}
					else if (feesOwed > 0) {
						System.out.println("Member Suspended");
					}*/
				}
				else {
					System.out.println("Invalid Number");
				}
			}
		}
	}
}
