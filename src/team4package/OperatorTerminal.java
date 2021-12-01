//Created by Sean Hurley
package team4package;
import java.io.IOException;
import java.util.Scanner;

class OperatorTerminal {
	
	Scanner userInput;
	
	OperatorTerminal(){
		userInput = new Scanner(System.in);
	}
	
	public void prompt() throws IOException{
		boolean invalid = true;
		
		while(invalid) { // Until input is valid, prompt:
			System.out.println("Enter Command. Type \"help\" for reference.");
			String response = userInput.nextLine();
			
			if(response.equals("help")) { // Allows user to be given reference information.
				System.out.println("Please use the convention: [Function] [Person Type]");
				System.out.println("Acceptable functions are: Add, Delete, Edit, ViewList.");
				System.out.println("Acceptable person types are: Member, Provider.");
				System.out.println("Enter \"exit\" to exit.");
				continue;
			}
			// Splitting input string into args
			String[] args = response.split(" ");
			
			if(!args[0].isEmpty() && args[0].equals("exit")) {
				invalid = false;
				continue;
			}
			
			if(args.length < 2)
				System.out.println("Command is invalid.");
			else if(!args[0].equals("Add") && !args[0].equals("Delete") && !args[0].equals("Edit") && !args[0].equals("ViewList")) // args[0] is Function
				System.out.println("Command is invalid.");
			else if(!args[1].equals("Member") && !args[1].equals("Provider")) // args[1] is Person Type
				System.out.println("Command is invalid.");
			else
				selectOption(args[0], args[1]);
		}
	}
	
	void selectOption(String func, String personType) throws IOException{
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
			case "ViewList":
				controller.viewListProvider();
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
			case "ViewList":
				controller.viewListMember();
				break;
			}
		}
	}
}
