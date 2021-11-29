package team4package;

import java.util.List;

class MemberReport {
	
	private String name;
	private int number;
	private String streetAddress;
	private String city;
	private String state;
	private List<Service> serviceList;
	
	private DatabaseManager db;
	
	private List<Service> gatherServices() {
		return db.services.get();
	}
	
	
	
}