// Joseph Storie
package team4package;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.FileWriter;
import java.time.LocalDate;
import java.io.PrintWriter;

class MemberReport {
	DatabaseManager db; // Accesses database
	
	private Member member;
	private ArrayList<Service> serviceList;
	
	
	MemberReport(Member src) throws IOException{
		db = DatabaseManager.getInstance();
		member = src;
		gatherServices();
	}
	
	private void gatherServices() { // Gather services of member into serviceList
		serviceList = db.getServicesByID(member.getID(), "Member");
	}
	
	public void saveReport() throws IOException { // Prints the member report to member.txt
		String name = member.getName();
		FileWriter fw = new FileWriter(name.replace(" ", "") + ".txt"); // Changes file name to member.txt
		PrintWriter pw = new PrintWriter(fw);
		pw.print("Member Report\n\n");
		pw.print(name + "\n");
		int ID = member.getID();
		pw.print("ID: " + ID + "\n");
		String address = member.getAddress();
		pw.print(address + "\n");
		String city = member.getCity();
		pw.print(city + "\n");
		String state = member.getState();
		pw.print(state + "\n");
		String zip = member.getZip();
		pw.print(zip + "\n\n");
		
		for(int i = 0; i < serviceList.size(); i++) { // Iterates through serviceList and prints each service to member.txt file
			Service curService = serviceList.get(i);
			LocalDate date = curService.getDate();
			pw.print(date + "\n");
			Provider provider = db.fetchProviderByID(curService.getProviderID());
			pw.print("Provider: " + provider.getName() + "\n");
			pw.print("Service: " + curService.getName() + "\n");
		}
		pw.close();
	}
	
	public void saveReportAll(FileWriter fw, PrintWriter pw) throws IOException { // Prints the member report to member.txt
		String name = member.getName();
		pw.print("Member Report\n\n");
		pw.print(name + "\n");
		int ID = member.getID();
		pw.print("ID: " + ID + "\n");
		String address = member.getAddress();
		pw.print(address + "\n");
		String city = member.getCity();
		pw.print(city + "\n");
		String state = member.getState();
		pw.print(state + "\n");
		String zip = member.getZip();
		pw.print(zip + "\n\n");
		
		for(int i = 0; i < serviceList.size(); i++) { // Iterates through serviceList and prints each service to member.txt file
			Service curService = serviceList.get(i);
			LocalDate date = curService.getDate();
			pw.print(date + "\n");
			Provider provider = db.fetchProviderByID(curService.getProviderID());
			pw.print("Provider: " + provider.getName() + "\n");
			pw.print("Service: " + curService.getName() + "\n");
		}
		pw.print("\n");
	}
	
}