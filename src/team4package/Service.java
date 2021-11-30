package team4package;

import java.util.Date;


class Service {
	private Date serviceDate;
	private int providerID;
	private int memberID;
	private String serviceName;
	private int fee;
	
	public int getProviderID() {
		return providerID;
	}
	
	public int getMemberID() {
		return memberID;
	}
	
	public String getName() {
		return serviceName;
	}
	
	public int getFee() {
		return fee;
	}
}