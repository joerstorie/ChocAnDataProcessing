// Trent Boughner
package team4package;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class ProviderTerminal {
	DatabaseManager db;
	
	Scanner userInput;
	
	ProviderTerminal() throws IOException {
		userInput = new Scanner(System.in);
		db = DatabaseManager.getInstance();
	}
	
	public void prompt() throws IOException {
		
		int serviceID;
		while(true) {
			System.out.println("Enter Command. Type \"help\" for reference.");
			String response = userInput.nextLine();
			
			if(response.equals("help")) { // Allows user to be given reference information.
				System.out.println("Enter \"Directory\" to receive a list of services offered.");
				System.out.println("Enter \"Service\" to apply a service to a member.");
				response = userInput.nextLine();
			}
			
			if(response.equals("exit")) {
				break;
			}
			// Splitting input string into command line arguments
			String[] args = response.split(" ");
			
			if(args.length < 1) {
				System.out.println("Please input a command.");
			} else if(args[0].equals("Directory")) {	
				System.out.println("\nProvider Directory");
				db.exportProviderDirectory();
			} else if(args[0].equals("Service")) {
				System.out.println("Enter member ID:");
				int memberID = userInput.nextInt();
				boolean verified = db.validateMemberID(memberID);
				if (verified) {
					System.out.println("Member ID Validated");
					applyService(memberID);
				} else {
					System.out.println("Invalid Number. Please check your input and try again.");
					userInput.nextLine();
				}
			}
		}
		System.out.println("Exiting the terminal.");
	}
	
	private String convertDate(String in) {
		String[] args = in.split("-");
		if(args.length < 2)
			return in; //safety, retry entering
		return args[2] + "-" + args[0] + "-" + args[1];
	}
	
	private void applyService(int memberID) throws IOException { //returns ID if successful or -1 if cancelled
		System.out.println("Please input the date of service using the format \"mm-dd-yyyy\"");
		userInput.nextLine();
		boolean invalid = true;
		
		LocalDate date = LocalDate.parse("1970-01-01");
		while(invalid) {
			String response = userInput.nextLine();
			try {
				date = LocalDate.parse(convertDate(response));
				invalid = false;
			} catch (DateTimeParseException e) {
				System.out.println("Please use the requested format- \"mm-dd-yyyy\"");
			}
		}
		int servCode = 1;
		String servName = "No Service Found";
		boolean confirmed = false;
		while(!confirmed) {
			System.out.println("Please enter a service code.");
			boolean invalidCode = true;
			
			while(invalidCode) {
				boolean failing = true;
				while(failing) {
					try {
						servCode = userInput.nextInt();
						failing = false;
					} catch (InputMismatchException ime) {
						System.out.println("Please input a numeric code.");
					}
				}
				servName = db.getServiceName(servCode);
				if(!servName.equals("No Service Found")){
					invalidCode = false;
				} else {
					System.out.println("No service found. Input a new service code.");
				}
			}
			
			System.out.println(servName);
			System.out.println("Input \"confirm\" to confirm your service selection, enter to input a new code, or \"exit\" to exit");
			userInput.nextLine();
			String response = userInput.nextLine();
			if(response.equals("confirm")) {
				confirmed = true;
			} else if(response.equals("exit")) {
				System.out.println("Process cancelled.");
				userInput.nextLine();
				return;
			} else {
				System.out.println("Input a new code.");
			}
		}
		
		int provID = 1;
		boolean validated = false;
		while(!validated) {
			System.out.println("Please input provider ID.");
			try {
				provID = userInput.nextInt();
				validated = db.validateProviderID(provID);
			} catch (InputMismatchException ime) {
				System.out.println("Only numeric inputs are allowed.");
			}
		}

		LocalDateTime curDTime = LocalDateTime.now();
		
		Service newService = new Service(db.getServices().size() + 1, servCode, provID, memberID, date, curDTime);
		System.out.println("Add any comments or press enter to skip. Only the first 100 characters will be used.");
		userInput.nextLine();
		String response = userInput.nextLine();
		if(response.length() > 100) {
			response = response.substring(0, 99);
		}
		newService.addComments(response);
		
		
		boolean verified = createVerificationForm(newService);
		if(!verified) {
			System.out.println("Process Cancelled.");
			return;
		}
		
		System.out.println("Service has been recorded.");
		newService.logService();
	}
	
	private boolean promptStringMatch(String item, String match) { // prompts user to match the string
		boolean invalid = true;
		String response = " ";
		while(invalid) {
			System.out.println("Enter " + item + ": ");
			response = userInput.nextLine();
			if(!response.equals(match)) {
				System.out.println("Please enter the matching " + item + ".");
				continue;
			}else if(response.equals("exit")) {
				return false;
			} else {
				break;
			}
		}
		return true; // safety
	}
	
	private boolean createVerificationForm(Service compare) throws IOException {
			
		compare.print();
		System.out.println("\nVerify the service by matching the details.");
		System.out.println("Current Date and Time: " + LocalDateTime.now().toString() + ".");

		if(!promptStringMatch("Date the Service was Provided", compare.getDate().toString())) {
			return false;
		}
		if(!promptStringMatch("Member Name", compare.getMemberName())) {
			return false;
		}
		if(!promptStringMatch("Member Number", String.valueOf(compare.getMemberID()))) {
			return false;
		}
		if(!promptStringMatch("Service Code", String.valueOf(compare.getServiceID()))) {
			return false;
		}
		if(!promptStringMatch("Fee to be Paid", "$" + String.valueOf(compare.getFee()))) {
			return false;
		}
		return true;

	}
}
