package team4package;

class Member{
	private int ID;
	private String streetAddress;
	private String city;	
	private String state;
	private int zip;
	private String name;
	
	Member(int srcID, String srcStreetAddress, String srcCity, String srcState, int srcZip, String srcName){
		ID = srcID;
		streetAddress = srcStreetAddress;
		city = srcCity;
		state = srcState;
		zip = srcZip;
		name = srcName;
	}
	
	public int getZip() {
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