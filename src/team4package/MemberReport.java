package team4package;

import java.util.Arrays;
import java.util.List;

class MemberReport {
	DatabaseManager db;
	
	private String name;
	private int ID;
	private String streetAddress;
	private String city;
	private String state;
	private List<Service> serviceList;

	
	MemberReport(){
		db = new DatabaseManager();
		serviceList = Arrays.asList();
		gatherServices();
	}
	
	private void gatherServices() {
		List<Service> allServices = db.getServices();
		for(int i = 0; i < allServices.size(); i++) {
			if(allServices.get(i).getMemberID() == ID) {
				serviceList.add(allServices.get(i));
			}
		}
	}
	
}