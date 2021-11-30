package team4package;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

class ProviderReport {
	DatabaseManager db;
	private Provider provider;
	
	ProviderReport(Provider src) throws IOException{
		db = DatabaseManager.getInstance();
		provider = src;
	}
	
	public void saveReport() throws IOException {
		String name = provider.getName();
		FileWriter fw = new FileWriter("./outputs/" + name.replace(" ", "") + ".txt");
		PrintWriter pw = new PrintWriter(fw);
		pw.print("Provider Report\n\n");
		pw.print(name + "\n");
		int ID = provider.getID();
		pw.print(ID + "\n");
		String address = provider.getAddress();
		pw.print(address + "\n");
		String city = provider.getCity();
		pw.print(city + "\n");
		String state = provider.getState();
		pw.print(state + "\n");
		String zip = provider.getZip();
		pw.print(zip + "\n\n");
		LocalDateTime atm = LocalDateTime.now();
		
		List<Service> services = provider.getServices();
		for (int i = 0; i < services.size(); i++) {
			Service curService = services.get(i);
			LocalDate date = curService.getDate();
			pw.print(date + "\n");
			pw.print(atm + "\n");
			Member curMember = db.fetchMemberByID(curService.getMemberID());
			pw.print(curMember.getName() + "\n");
			pw.print(curMember.getID() + "\n");
			pw.print(curService.getServiceID() + "\n");
			pw.print(curService.getFee() + "\n");
			pw.print(provider.getNumServices() + "\n");
			pw.print(provider.getTotalFee() + "\n");
		}
		pw.close();
	
		
		
	}
	
}