//Created by Sean Hurley
package team4package;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class ManagerProvider {
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
	
	ManagerProvider() throws IOException{
		userInput = new Scanner(System.in);
		db = DatabaseManager.getInstance();
		setProviders();
		setMembers();
	}
	
	
	public void addProvider() {
		
	}
	
	public void deleteProvider() {
		
	}
	
	public void editProvider() {
		
	}
	
	public void viewListProvider() throws IOException {
		System.out.println("Provider List:");
		db.displayProviders();
				
	}
	
}
