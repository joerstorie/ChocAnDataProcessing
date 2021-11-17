package team4package;
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
			int validInput = 1;
			
			if(args.length < 1)
				System.out.println("Command is invalid.");
			else if(args[0] != "Add" && args[0] != "Delete" && args[0] != "Edit") // args[0] is Function
				System.out.println("Command is invalid.");
			else if(args[1] != "Member" && args[1] != "Provider") // args[1] is Person Type
				System.out.println("Command is invalid.");
			else
				selectOption(args[0], args[1]);
		}
	}
	
	private void selectOption(String func, String personType) {
		if(personType == "Provider") {
			ManagerProvider controller = new ManagerProvider();
			switch(func) {
			case "Add":
				controller.addProvider();
				break;
			case "Delete":
				controller.deleteProvider();
				break;
			case "Edit":
				controller.editProvider();
				break;
			}
		} else { //personType == "Member"
			ManagerMember controller = new ManagerMember();
			switch(func) {
			case "Add":
				controller.addMember();
				break;
			case "Delete":
				controller.deleteMember();
				break;
			case "Edit":
				controller.editMember();
				break;
			}
		}
	}
}
