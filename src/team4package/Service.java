package team4package;

import java.util.Date;


class Service {
	private Date serviceDate;
	private int providerID;
	private int memberID;
	private String memberName;
	private String serviceName;
	private int fee;
	
	Service(int srcProvID, int srcMemID, String srcMemName, String srcName, int srcFee, Date srcDate){
		serviceDate = srcDate;
		providerID = srcProvID;
		memberID = srcMemID;
		memberName = srcMemName;
		serviceName = srcName;
		fee = srcFee;
		
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
	
	public String getName() {
		return serviceName;
	}
	
	public int getFee() {
		return fee;
	}
}