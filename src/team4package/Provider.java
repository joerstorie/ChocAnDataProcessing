package team4package;

import java.io.IOException;
import java.util.List;

class Provider{
	DatabaseManager db;
	
	private int ID;
	private String name;
	private String streetAddress;
	private String city;	
	private String state;
	private String zip;
	
	
	Provider(int srcID, String srcName, String srcStreetAddress, String srcCity, String srcState, String srcZip) throws IOException {
		db = DatabaseManager.getInstance();
		ID = srcID;
		streetAddress = srcStreetAddress;
		city = srcCity;
		state = srcState;
		zip = srcZip;
		name = srcName;
	}
	
	public int getTotalFee() throws IOException {
		int total = 0;
		
		List<Service> services = db.getServices();
		for(int i = 0; i < services.size(); i++) {
			if(services.get(i).getProviderID() == ID) {
				total += services.get(i).getFee();
			}
		}
		return total;
	}
	
	public int getNumServices() {
		int num = 0;
		
		List<Service> services = db.getServices();
		for(int i = 0; i < services.size(); i++) {
			if(services.get(i).getProviderID() == ID) {
				num++;
			}
		}
		return num;
	}
	
	public List<Service> getServices(){
		return db.getServicesByID(ID, "Provider");
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getAddress() {
		return streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zip;
	}
}