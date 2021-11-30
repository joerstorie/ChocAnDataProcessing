package team4package;
import java.io.IOException;
import java.util.Scanner;

class OperatorTerminal {
	
	public static void main(String args[]) throws IOException {
		OperatorTerminal ot = new OperatorTerminal();
		while(true) {
			ot.prompt();
		}
	}
	
	Scanner userInput;
	
	OperatorTerminal(){
		userInput = new Scanner(System.in);
	}
	
	public void prompt() {
		boolean invalid = true;
		
		while(invalid) { // Until input is valid, prompt:
			System.out.println("Enter Command. Type \"help\" for reference.");
			String response = userInput.nextLine();
			
			if(response.equals("help")) { // Allows user to be given reference information.
				System.out.println("Please use the convention: [Function] [Person Type]");
				System.out.println("Acceptable functions are: Add, Delete, Edit.");
				System.out.println("Acceptable person types are: Member, Provider.");
				continue;
			}
			// Splitting input string into args
			String[] args = response.split(" ");
			
			if(args.length < 2)
				System.out.println("Command is invalid.");
			else if(!args[0].equals("Add") && !args[0].equals("Delete") && !args[0].equals("Edit")) // args[0] is Function
				System.out.println("Command is invalid.");
			else if(!args[1].equals("Member") && !args[1].equals("Provider")) // args[1] is Person Type
				System.out.println("Command is invalid.");
			else
				selectOption(args[0], args[1]);
		}
	}
	
	private void selectOption(String func, String personType) {
		if(personType.equals("Provider")) {
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
