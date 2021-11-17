package team4package;
import java.util.Arrays;
import java.util.Scanner;


class OperatorTerminal {
	Scanner userInput;
	
	OperatorTerminal(){
		userInput = new Scanner(System.in);
	}
	
	public void prompt() {
		boolean invalid = true;
		
		while(invalid) { // Until input is valid, prompt:
			System.out.println("Enter Command. Type \"help\" for reference.");
			String response = userInput.nextLine();
			
			if(response == "help") { // Allows user to be given reference information.
				System.out.println("Please use the convention: [Function] [Person Type]");
				System.out.println("Acceptable functions are: Add, Delete, Edit.");
				System.out.println("Acceptable person types are: Member, Provider.");
				response = userInput.nextLine();
			}
			 // Splitting input string into args
			String[] args = response.split(" ");
			
			if(args.length < 1) {
				System.out.println("Command is invalid.");
			} else {
				String function = args[0];
				
				switch(function) {
				case "Add":
					break;
				case "Delete":
					break;
				case "Edit":
					break;
				default:
					System.out.println("Command is invalid.");
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
