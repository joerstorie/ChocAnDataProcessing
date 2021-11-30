package team4package;

import java.time.LocalDate;


class Service {
	private LocalDate serviceDate;
	private int providerID;
	private int memberID;
	private String memberName;
	private int serviceID;
	
	Service(int srcID, int srcProvID, int srcMemID, String srcMemName, LocalDate srcDate){
		serviceDate = srcDate;
		providerID = srcProvID;
		memberID = srcMemID;
		memberName = srcMemName;
		serviceID = srcID;
		
	}
	
	public int getProviderID() {
		return providerID;
	}
	
	public int getMemberID() {
		return memberID;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public LocalDate getDate() {
		return serviceDate;
	}
	
	public int getServiceID() {
		return serviceID;
	}
	
	public String getName() {
		return DatabaseManager.getInstance().getServiceName(serviceID);
	}
	
	public int getFee() {
		return DatabaseManager.getInstance().getServiceFee(serviceID);
	}
}