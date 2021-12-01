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
	
	public void prompt() {
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
			} else if(args[0].equals("Service")) {
				System.out.println("Enter member ID:");
				int memberID = userInput.nextInt();
				boolean verified = db.validateMemberID(memberID);
				if (verified) {
					System.out.println("Member ID Validated");
					//create service record
					applyService(memberID);
					// create verification form
					
					
				}
				else {
					System.out.println("Invalid Number. Please check your input and try again.");
					userInput.nextLine();
				}
			}
		}
		System.out.println("Exiting the terminal.");
	}
	
	private void applyService(int memberID) {
		System.out.println("Please input the date of service using the format \"yyyy-mm-dd\"");
		boolean invalid = true;
		LocalDate date = LocalDate.parse("1970-01-01");
		while(invalid) {
			String response = userInput.nextLine();
			try {
				date = LocalDate.parse(response);
				invalid = false;
			} catch (DateTimeParseException e) {
				System.out.println("Please use the requested format- \"yyyy-mm-dd\"");
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
				if(servName != "No Service Found") {
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
		
		Service newService = new Service(servCode, provID, memberID, date, curDTime);
		newService.logService();
		// Adds to database (final change)
		db.addService(newService);
		
		System.out.println("Service Fee: $" + newService.getFee() + "\n");
		newService.getFee();
		

	}
}
