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
	private int zip;
	private List<Service> serviceList;

	
	MemberReport(int srcID){
		ID = srcID;
		db = new DatabaseManager();
		serviceList = Arrays.asList();
		gatherServices();
		gatherInfo();
	}
	
	private void gatherServices() {
		List<Service> allServices = db.getServices();
		for(int i = 0; i < allServices.size(); i++) {
			if(allServices.get(i).getMemberID() == ID) {
				serviceList.add(allServices.get(i));
			}
		}
	}
	
	private void gatherInfo() {
		List<Member> allMembers = db.getMembers();
		for(int i = 0; i < allMembers.size(); i++) {
			Member temp = allMembers.get(i);
			if(temp.getID() == ID) {
				name = temp.getName();
				streetAddress = temp.getAddress();
				city = temp.getCity();
				state = temp.getState();
				zip = temp.getZip();
			}
		}
	}
}