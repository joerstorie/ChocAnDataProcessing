package team4package;

import java.io.IOException;
import java.util.ArrayList;

class Provider{
	DatabaseManager db;
	
	private int ID;
	private String streetAddress;
	private String city;	
	private String state;
	private String zip;
	private String name;
	
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
		
		ArrayList<Service> services = db.getServices();
		for(int i = 0; i < services.size(); i++) {
			if(services.get(i).getProviderID() == ID) {
				total += services.get(i).getFee();
			}
		}
		return total;
	}
	
	public int getNumServices() {
		int num = 0;
		
		ArrayList<Service> services = db.getServices();
		for(int i = 0; i < services.size(); i++) {
			if(services.get(i).getProviderID() == ID) {
				num++;
			}
		}
		return num;
	}
	
	public ArrayList<Service> getServices(){
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