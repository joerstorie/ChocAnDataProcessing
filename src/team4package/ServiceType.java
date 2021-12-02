//Rodney Wade
package team4package;

class ServiceType {
	
	private int typeID;
	private int serviceFee;
	private String serviceName;
	
	// constructor for serviceType; 
	ServiceType(int srcID, String srcName, int srcFee){
		typeID = srcID;
		serviceFee = srcFee;
		serviceName = srcName;
	}
	
	// gets the ID for the Service
	public int getID() {
		return typeID;
	}
	
	// gets the fee for the Service
	public int getFee() {
		return serviceFee;
	}
	
	// gets the name for the Service
	public String getName() {
		return serviceName;
	}
}