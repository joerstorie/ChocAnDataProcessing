//Created by Sean Hurley
package team4package;

import java.util.List;
import java.util.Scanner;
import java.io.IOException;

class ManagerMember {
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
	
	ManagerMember() throws IOException{
		userInput = new Scanner(System.in);
		db = DatabaseManager.getInstance();
		setProviders();
		setMembers();
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
	
	private Member newMember() { // builds a new member and returns it
		int ID = promptInt("ID");
		String name = promptString("Name");
		String streetAddress = promptString("Street Address");
		String city = promptString("City");
		String state = promptString("State");
		String zip = promptString("Zip Code");
		
		return new Member(ID, name, streetAddress, city, state, zip);
	}
	
	
	public void addMember() throws IOException {
		System.out.println("Creating new member...");
		Member addme = newMember();
		db.addMember(addme);
	}
	
	public void deleteMember() {
		
	}
	
	public void editMember() {
		//find member to replace
		System.out.println("Enter new member details...");
		Member replacement = newMember();
		//replace with replacement
		
	}
	
}
