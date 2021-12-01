// Riley Parker
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
	
	ProviderTerminal() throws IOException { // Declares input scanner and connects to database instance
		userInput = new Scanner(System.in);
	}
	
	public void prompt() throws IOException {
		db = DatabaseManager.getInstance();
		
		int serviceID;
		while(true) { // While user has not input "exit"
			System.out.println("Enter Command. Type \"help\" for reference.");
			String response = userInput.nextLine();
			
			if(response.equals("help")) { // Allows user to be given reference information.
				System.out.println("Enter \"Directory\" to receive a list of services offered.");
				System.out.println("Enter \"Service\" to apply a service to a member.");
				response = userInput.nextLine();
			}
			
			if(response.equals("exit")) { // Allows user to exit terminal
				break;
			}
			// Splitting input string into command line arguments
			String[] args = response.split(" ");
			
			if(args.length < 1) {
				System.out.println("Please input a command.");
			} else if(args[0].equals("Directory")) {	// Displays list of service types in alphabetical order
				System.out.println("\nProvider Directory");
				db.exportProviderDirectory();
			} else if(args[0].equals("Service")) { // Begins service logging process
				System.out.println("Enter member ID:");
				int memberID = userInput.nextInt();
				boolean verified = db.validateMemberID(memberID); // Checks if memberID refers to existing member
				if (verified) {
					System.out.println("Member ID Validated");
					applyService(memberID); // Continues process in separate function
				} else {
					System.out.println("Invalid Number. Please check your input and try again.");
					userInput.nextLine();
				}
			}
		}
		System.out.println("Exiting the terminal."); // Ending terminal use
	}
	
	public String convertDate(String in) { // Converts from format requested in requirements to java's parsing format
		String[] args = in.split("-");
		if(args.length < 2)
			return in; //safety, retry entering
		return args[2] + "-" + args[0] + "-" + args[1];
	}
	
	private void applyService(int memberID) throws IOException { //returns ID if successful or -1 if cancelled
		System.out.println("Please input the date of service using the format \"mm-dd-yyyy\"");
		userInput.nextLine();
		boolean invalid = true;
		
		LocalDate date = LocalDate.parse("1970-01-01"); // Default date
		while(invalid) {
			String response = userInput.nextLine();
			try {
				date = LocalDate.parse(convertDate(response));  // Repeatedly attempts to parse user's date input
				invalid = false;
			} catch (DateTimeParseException e) {
				System.out.println("Please use the requested format- \"mm-dd-yyyy\""); // Requests format again
			}
		}
		int servCode = 1;
		String servName = "No Service Found"; // Default
		boolean confirmed = false;
		while(!confirmed) {
			System.out.println("Please enter a service code.");
			boolean invalidCode = true;
			
			while(invalidCode) { // Repeatedly checks service codes
				boolean failing = true;
				while(failing) {
					try {
						servCode = userInput.nextInt();
						failing = false;
					} catch (InputMismatchException ime) { // Handles case where it's not an integer
						System.out.println("Please input a numeric code.");
					}
				}
				servName = db.getServiceName(servCode);
				if(!servName.equals("No Service Found")){ // If service type was found with this code
					invalidCode = false;
				} else {
					System.out.println("No service found. Input a new service code."); // Request again and repeat
				}
			}
			
			// Confirming service choice, choosing new option, or allowing user to cancel the service creation
			System.out.println(servName);
			System.out.println("Input \"confirm\" to confirm your service selection, enter to input a new code, or \"exit\" to exit");
			userInput.nextLine();
			String response = userInput.nextLine();
			if(response.equals("confirm")) {
				confirmed = true; // Exits top loop
			} else if(response.equals("exit")) {
				System.out.println("Process cancelled."); // Returns to terminal "home" (top of prompt)
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
			try { // Repeatedly receives and checks provider ID's for matches
				provID = userInput.nextInt();
				validated = db.validateProviderID(provID);
			} catch (InputMismatchException ime) {
				System.out.println("Only numeric inputs are allowed.");
			}
		}

		LocalDateTime curDTime = LocalDateTime.now();
		
		// Allows users to input any comments if they wish
		Service newService = new Service(db.getServices().size() + 1, servCode, provID, memberID, date, curDTime);
		System.out.println("Add any comments or press enter to skip. Only the first 100 characters will be used.");
		userInput.nextLine();
		String response = userInput.nextLine();
		if(response.length() > 100) { // Limits comments to 100 chars
			response = response.substring(0, 99);
		}
		newService.addComments(response); // Updates comments
		
		
		boolean verified = createVerificationForm(newService);
		if(!verified) { // Only happens if a cancel occurs in the form.
			System.out.println("Process Cancelled.");
			return;
		}
		
		// Records service after verification
		System.out.println("Service has been recorded.");
		newService.logService();
	}
	
	
	private boolean promptStringMatch(String item, String match) { // prompts user to match the string
		boolean invalid = true;
		String response = " ";
		while(invalid) { 
			System.out.println("Enter " + item + ", or \"exit\" to cancel: ");
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
