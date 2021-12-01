//Jake Silvey
package team4package;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

class ProviderReport {
	DatabaseManager db;
	private Provider provider;
	//Accesses Database
	ProviderReport(Provider src) throws IOException{
		db = DatabaseManager.getInstance();
		provider = src;
	}
	//Creates and populates report
	public void saveReport() throws IOException {
		String name = provider.getName();
		FileWriter fw = new FileWriter(name.replace(" ", "") + ".txt");
		PrintWriter pw = new PrintWriter(fw);
		pw.print("Provider Report\n\n");
		pw.print("Provider Name: " + name + "\n");
		int ID = provider.getID();
		pw.print("Provider ID: " + ID + "\n");
		String address = provider.getAddress();
		pw.print(address + "\n");
		String city = provider.getCity();
		pw.print(city + "\n");
		String state = provider.getState();
		pw.print(state + "\n");
		String zip = provider.getZip();
		pw.print(zip + "\n\n");
		LocalDateTime atm = LocalDateTime.now();
		//Searches through all services to gather information for the report
		ArrayList<Service> services = provider.getServices();
		for (int i = 0; i < services.size(); i++) {
			Service curService = services.get(i);
			LocalDate date = curService.getDate();
			pw.print("Date of Service: " + date + "\n");
			pw.print("Current Date/Time: " + atm + "\n");
			//Uses 'fetch' function to get member by their ID
			Member curMember = db.fetchMemberByID(curService.getMemberID());
			pw.print("Member Name: " + curMember.getName() + "\n");
			pw.print("Member ID: " + curMember.getID() + "\n");
			pw.print("Service ID: " + curService.getServiceID() + "\n");
			pw.print("Service Fee: " + curService.getFee() + "\n\n");
		}
		//Prints service quantity and provider fees
		pw.print("Total Service Quantity: " + provider.getNumServices() + "\n");
		pw.print("Total Provider Fees: " + provider.getTotalFee() + "\n");
		pw.close();
	
		
		
	}
	
}