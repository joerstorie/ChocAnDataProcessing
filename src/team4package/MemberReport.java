package team4package;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class MemberReport {
	DatabaseManager db;
	
	private Member member;
	private List<Service> serviceList;
	
	
	MemberReport(Member src) throws IOException{
		db = DatabaseManager.getInstance();
		member = src;
	}
	
	private void gatherServices() {
		List<Service> allServices = db.getServices();
		for(int i = 0; i < allServices.size(); i++) {
			if(allServices.get(i).getMemberID() == member.getID()) {
				serviceList.add(allServices.get(i));
			}
		}
		
	}
	public void saveReport() throws ExceptionIO {
		FileWriter fw = new FileWriter("EFTDataLog.txt");
		PrintWriter pw = new PrintWriter(fw);
		pw.print("Member Report\n\n");
		String name = member.getName();
		pw.print(name + "\n");
		int ID = member.getID();
		pw.print(ID + "\n");
		String address = member.getAddress();
		pw.print(address + "\n");
		String city = member.getCity();
		pw.print(city + "\n");
		String state = member.getState();
		pw.print(state + "\n");
		String zip = member.getZip();
		pw.print(zip + "\n\n");
		
		Date date = member.getDate();
		pw.print(date + "\n");
		Provider provider = member.getProviderName();
		pw.print(provider.getName() + "\n");
		pw.print(service.getName() + "\n");
	}
	pw.close();
}