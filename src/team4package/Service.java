package team4package;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;


class Service {
	private LocalDate serviceDate;
	private int providerID;
	private int memberID;
	private int serviceID;
	private String comments = "";
	private LocalDateTime inputDTime;
	
	Service(int srcID, int srcProvID, int srcMemID, LocalDate srcDate, LocalDateTime srcDTime){
		serviceDate = srcDate;
		providerID = srcProvID;
		memberID = srcMemID;
		serviceID = srcID;
		inputDTime = srcDTime;
		
	}
	
	public void addComments(String srcComments) {
		comments = srcComments;
	}
	
	public int getProviderID() {
		return providerID;
	}
	
	public int getMemberID() {
		return memberID;
	}
	
	public String getMemberName() throws IOException {
		return DatabaseManager.getInstance().fetchMemberByID(memberID).getName();
	}
	
	public LocalDate getDate() {
		return serviceDate;
	}
	
	public int getServiceID() {
		return serviceID;
	}
	
	public String getProviderName() throws IOException {
		return DatabaseManager.getInstance().fetchProviderByID(providerID).getName();
	}
	
	public String getName() throws IOException {
		return DatabaseManager.getInstance().getServiceName(serviceID);
	}
	
	public int getFee() throws IOException {
		return DatabaseManager.getInstance().getServiceFee(serviceID);
	}
}