package team4package;

import java.util.Scanner;
import java.io.IOException;

class ManagerTerminal {
	
	public static void main(String args[]) throws IOException {
		ManagerTerminal mt = new ManagerTerminal();
		while(true) {
			mt.prompt();
		}
	}
	
	Scanner userInput;
	
	ManagerTerminal(){
		userInput = new Scanner(System.in);
	}
	
	public void prompt() throws IOException {
		boolean invalid = true;
		
		while(invalid) { // Until input is valid, prompt:
			System.out.println("Enter Command. Type \"help\" for reference.");
			String response = userInput.nextLine();
			
			if(response.equals("help")) { // Allows user to be given reference information.
				System.out.println("Please use the convention: [Report Type] [ID]");
				System.out.println("Acceptable report types are: Provider, Member, Summary, EFT. Input * to log all.");
				System.out.println("ID is only needed for report types Provider and Member.");
				response = userInput.nextLine();
			}
			 // Splitting input string into args
			String[] args = response.split(" ");
			
			if(args.length < 1) {
				System.out.println("Command is invalid.");
			} else {
				String reportType = args[0];
				if(reportType.equals("Provider") || reportType.equals("Member")) {
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
					boolean completed = selectOption(reportType, parsedID);
					if(completed) {
						System.out.println("Report created.");
						break;
					} else {
						System.out.println("No " + reportType + " was found with this ID.");
					}
				} else if(reportType.equals("Summary") || reportType.equals("EFT") || reportType.equals("*")) {
					selectOption(reportType);
					System.out.println("Report(s) created.");
					break;
				} else {
					System.out.println("Please double check your report type entry.");
				}
			}
		}
	}
	
	private boolean selectOption(String reportType, int ID) throws IOException {
		ReportController control = new ReportController();
		boolean verified = false;
		
		switch (reportType) {
		
		case "Member":
			verified = control.checkMemID(ID);
			if(verified) {
				control.createMemberReport(ID);
				return true;
			} else {
				return false;
			}
			
			
		case "Provider":
			verified = control.checkProvID(ID);
			if(verified) {
				control.createProviderReport(ID);
				return true;
			} else {
				return false;
			}
			
		}
		return false;
	}
	
	private void selectOption(String reportType) throws IOException {
		ReportController control = new ReportController();
		
		switch (reportType) {
		
		case "Summary":
			control.createSummaryReport();
			break;
			
		case "EFT":
			control.createEFTDataLog();
			break;
			
		case "*":
			control.createReports();
			break;
		}
		
	}

}
