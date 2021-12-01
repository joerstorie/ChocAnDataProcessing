package team4package;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

class ProviderController{
	Scanner userInput;
	DatabaseManager db;
	private List<Provider> providers;
	private List<Member> members;
	
	private void setMembers() {
		members = db.getMembers();
	}
	private void setProviders() {
		providers = db.getProviders();
	}
	
	ProviderController() throws IOException{
		db = DatabaseManager.getInstance();
		userInput = new Scanner(System.in);
		setProviders();
		setMembers();
	}
	// the current date and time, the date the service was provided, member name and number, 
	// service code, and fee to be paid
	
	private String promptString(String item) {
		boolean invalid = true;
		String response;
		while(invalid) {
			System.out.println("Enter " + item + ": ");
			response = userInput.nextLine();
			if(response.isEmpty()) {
				System.out.println("Please supply a valid " + item + " (Must not be blank).");
				continue;
			}else {
				return response;
			}
		}
		return (String) null; //shouldn't get here
	}
	
	private int promptInt(String item) {
		boolean invalid = true;
		String response;
		String[] args;
		while(invalid) {
			System.out.println("Enter " + item + ": ");
			response = userInput.nextLine();
			args = response.split(" ");
			if(args[0].isEmpty()) {
				System.out.println("Please supply a valid " + item + " (Must not be blank).");
				continue;
			}else {
				try {
					return Integer.parseInt(args[0]);
				} catch (NumberFormatException nfe) {
					System.out.println("Please supply a valid " + item + " (Must be numeric).");
					continue;
				}
			}
		}
		return (Integer) null; //shouldn't get here
	}
	

	
	public void createVerificationForm() throws IOException {

		String curDateTime;
		String dateOfService;
		String name;
		int number;
		int serviceCode;
		String fee;
		while(true) {
		
			curDateTime = promptString("Current Date and Time");
			dateOfService = promptString("Date the Service was Provided");
			name = promptString("Member Name");
			number = promptInt("Member Number");
			serviceCode = promptInt("Service Code");
			fee = promptString("Fee to be Paid");
			
			System.out.println("Current Date and Time: " + curDateTime);
			System.out.println("Date the Service was Provided: " + dateOfService);
			System.out.println("Member Name: " + name);
			System.out.println("Member Number: " + number);
			System.out.println("Service Code: " + serviceCode);
			System.out.println("Fee: " + fee);
			System.out.println("Looks good? (y/n)");
			String verify = promptString("Response");
			if(verify.equals("y"))
				break;

		}
		
		//export strings or int to file if necessary
	}
	
	public boolean checkMemID(int ID) {
		return db.validateMemberID(ID);
	}
	
}
