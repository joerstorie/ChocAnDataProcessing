// Joseph Storie
package team4package;

class Member{
	private int ID;
	private String name;
	private String streetAddress;
	private String city;	
	private String state;
	private String zip;
	
	// Assigns variables to corresponding arguments
	Member(int srcID, String srcName, String srcStreetAddress, String srcCity, String srcState, String srcZip){
		ID = srcID;
		streetAddress = srcStreetAddress;
		city = srcCity;
		state = srcState;
		zip = srcZip;
		name = srcName;
	}
	
	// Methods to get and return information
	public String getZip() {
		return zip;
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
	
	public String getName() {
		return name;
	}
}