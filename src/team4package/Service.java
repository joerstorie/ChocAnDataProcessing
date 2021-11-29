package team4package;

import java.util.Date;


class Service {
	private Date serviceDate;
	private int providerID;
	private int memberID;
	private String serviceName;
	
	public int getProviderID() {
		return providerID;
	}
	
	public int getMemberID() {
		return memberID;
	}
	
	public String getName() {
		return serviceName;
	}
}