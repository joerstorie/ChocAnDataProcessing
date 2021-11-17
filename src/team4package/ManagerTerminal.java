package team4package;

import java.util.Scanner;
import team4package.ReportController;

class ManagerTerminal {
	Scanner userInput;
	
	ManagerTerminal(){
		userInput = new Scanner(System.in);
	}
	
	public void prompt() {
		boolean invalid = true;
		
		while(invalid) { // Until input is valid, prompt:
			System.out.println("Enter Command. Type \"help\" for reference.");
			String response = userInput.nextLine();
			
			if(response == "help") { // Allows user to be given reference information.
				System.out.println("Please use the convention: [Report Type] [ID]");
				System.out.println("Acceptable report types are: Provider, Member, Summary, EFT.");
				System.out.println("ID is only needed for report types Provider and Member.");
				response = userInput.nextLine();
			}
			 // Splitting input string into args
			String[] args = response.split(" ");
			
			if(args.length < 1) {
				System.out.println("Command is invalid.");
			} else {
				String reportType = args[0];
				if(reportType == "Provider" || reportType == "Member") {
					int parsedID;
					if(args.length < 2) {
						System.out.println("Please supply an ID.");
						continue;
					}
					else {
						String ID = args[1];
						try {
							parsedID = Integer.parseInt(ID);
						} catch (NumberFormatException nfe) {
							System.out.println("Please supply a valid ID (Must be numeric).");
							continue;
						}
					}
					selectOption(reportType, parsedID);
					break;
				} else if(reportType == "Summary" || reportType == "EFT") {
					selectOption(reportType);
					break;
				}
			}
		}
	}
	
	private void selectOption(String reportType, int ID) {
		
	}
	
	private void selectOption(String reportType) {
		
	}
}
