package team4package;

import java.util.Scanner;

public class ProviderTerminal {
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
				System.out.println("ID is only needed for report types Provider and Member.");
				response = userInput.nextLine();
			}
			 // Splitting input string into args
			String[] args = response.split(" ");
			
			if(args.length < 1) {
				System.out.println("Command is invalid.");
			} 
			else {
				int memberID;
				int serviceID;
				//** implement search ChocAn Data Center
				//memberIDmatch = ChocAnDataCenter(memberID); searches for matching code and then
				if 
			}
		}
	}
}
