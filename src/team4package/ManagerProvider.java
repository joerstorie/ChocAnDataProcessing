//Created by Sean Hurley
package team4package;

import java.util.List;
import java.util.Scanner;
import java.io.IOException;

class ManagerProvider {
	Scanner userInput;
	DatabaseManager db;

	ManagerProvider() throws IOException{
		userInput = new Scanner(System.in);
		db = DatabaseManager.getInstance();
	}
	
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
	
	private Provider newProvider() throws IOException { // builds a new provider and returns it
		int ID = promptInt("ID");
		String name = promptString("Name");
		String streetAddress = promptString("Street Address");
		String city = promptString("City");
		String state = promptString("State");
		String zip = promptString("Zip Code");
		
		return new Provider(ID, name, streetAddress, city, state, zip);
	}
	
	private Provider newProvider(int srcID) throws IOException { // builds a new provider and returns it, special version for edit
		String name = promptString("Name");
		String streetAddress = promptString("Street Address");
		String city = promptString("City");
		String state = promptString("State");
		String zip = promptString("Zip Code");
		
		return new Provider(srcID, name, streetAddress, city, state, zip);
	}
	
	
	public void addProvider() throws IOException {
		System.out.println("Entering provider creation wizard...");
		Provider addme = newProvider();
		db.addProvider(addme);
		System.out.println("Added new provider.");
	}
	
	public void deleteProvider() throws IOException {
		System.out.println("Identify the provider you wish to delete");
		int ID = promptInt("ID");
		if(db.validateProviderID(ID)) { // if provider exists
			System.out.println("Found provider by the ID \"" + ID + "\", deleting...");
			db.deleteProvider(ID);
			System.out.println("Delete successful.");
		} else { // if provider does not exist
			System.out.println("Provider not found.");
		}
	}
	
	public void editProvider() throws IOException {
		System.out.println("Identify the provider you wish to edit");
		int ID = promptInt("ID");
		if(db.validateProviderID(ID)) { // if member exists
			System.out.println("Found provider by the ID \"" + ID + "\"");
			System.out.println("Enter new provider details...");
			Provider replacement = newProvider(ID);
			System.out.println("Deleting old provider...");
			db.deleteProvider(ID);
			System.out.println("Delete successful, adding new provider...");
			db.addProvider(replacement);
			System.out.println("Successfully replaced provider.");
		} else { // if member does not exist
			System.out.println("Provider not found.");
		}
		
	}
	
	public void viewListProvider() throws IOException {
		System.out.println("Provider List:");
		db.displayProviders();
	}
	
}
