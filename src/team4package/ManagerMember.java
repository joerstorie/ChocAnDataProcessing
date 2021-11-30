//Created by Sean Hurley
package team4package;

import java.util.List;
import java.util.Scanner;
import java.io.IOException;

class ManagerMember {
	Scanner userInput;
	DatabaseManager db;

	ManagerMember() throws IOException{
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
	
	private Member newMember() { // builds a new member and returns it
		int ID = promptInt("ID");
		String name = promptString("Name");
		String streetAddress = promptString("Street Address");
		String city = promptString("City");
		String state = promptString("State");
		String zip = promptString("Zip Code");
		
		return new Member(ID, name, streetAddress, city, state, zip);
	}
	
	private Member newMember(int srcID) { // builds a new member and returns it, special version for edit
		String name = promptString("Name");
		String streetAddress = promptString("Street Address");
		String city = promptString("City");
		String state = promptString("State");
		String zip = promptString("Zip Code");
		
		return new Member(srcID, name, streetAddress, city, state, zip);
	}
	
	
	public void addMember() throws IOException {
		System.out.println("Entering member creation wizard...");
		Member addme = newMember();
		db.addMember(addme);
	}
	
	public void deleteMember() throws IOException {
		System.out.println("Identify the member you wish to delete");
		int ID = promptInt("ID");
		if(db.validateMemberID(ID)) { // if member exists
			System.out.println("Found member by the ID \"" + ID + "\", deleting...");
			db.deleteMember(ID);
			System.out.println("Delete successful.");
		} else { // if member does not exist
			System.out.println("Member not found.");
		}
	}
	
	public void editMember() throws IOException {
		System.out.println("Identify the member you wish to edit");
		int ID = promptInt("ID");
		if(db.validateMemberID(ID)) { // if member exists
			System.out.println("Found member by the ID \"" + ID);
			System.out.println("Enter new member details...");
			Member replacement = newMember(ID);
			System.out.println("Deleting old member...");
			db.deleteMember(ID);
			System.out.println("Delete successful, adding new member...");
			db.addMember(replacement);
			System.out.println("Successfully replaced member.");
		} else { // if member does not exist
			System.out.println("Member not found.");
		}
		
	}
	
	public void viewListMember() throws IOException {
		System.out.println("Member List:");
		db.displayMembers();
	}
	
}
