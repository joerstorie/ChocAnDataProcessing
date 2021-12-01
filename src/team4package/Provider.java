// Trent Boughner
package team4package;

import java.io.IOException;
import java.util.ArrayList;

class Provider{
	DatabaseManager db;
	
	// Creating private variable for provider ID, name, and address
	private int ID;
	private String name;
	private String streetAddress;
	private String city;	
	private String state;
	private String zip;
	
	// creates an object called provider that has name, ID, and address as attributes
	Provider(int srcID, String srcName, String srcStreetAddress, String srcCity, String srcState, String srcZip) throws IOException {
		db = DatabaseManager.getInstance();
		ID = srcID;
		streetAddress = srcStreetAddress;
		city = srcCity;
		state = srcState;
		zip = srcZip;
		name = srcName;
	}
	
	// retrieves the total fee of the services the provider has performed
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
	
	// retrieves the total number of services performed
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
	
	// retrieves a list of all the services the provider has performed
	public ArrayList<Service> getServices(){
		return db.getServicesByID(ID, "Provider");
	}
	
	// retrieves name of provider
	public String getName() {
		return name;
	}
	
	// retrieves provider ID
	public int getID() {
		return ID;
	}
	
	// retrieves provider's street address
	public String getAddress() {
		return streetAddress;
	}
	
	// retrieves provider's city of residence
	public String getCity() {
		return city;
	}
	
	// retrieves provider's state of residence
	public String getState() {
		return state;
	}
	
	// retrieves provider's zip code
	public String getZip() {
		return zip;
	}
}