package team4package;

class ServiceType {
	
	private int typeID;
	private int serviceFee;
	private String serviceName;
	
	ServiceType(int srcID, String srcName, int srcFee){
		typeID = srcID;
		serviceFee = srcFee;
		serviceName = srcName;
	}
	
	public int getID() {
		return typeID;
	}
	
	public int getFee() {
		return serviceFee;
	}
	
	public String getName() {
		return serviceName;
	}
}