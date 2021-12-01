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
	DatabaseManager db;
	
	Service(int srcID, int srcProvID, int srcMemID, LocalDate srcDate, LocalDateTime srcDTime) throws IOException {
		serviceDate = srcDate;
		providerID = srcProvID;
		memberID = srcMemID;
		serviceID = srcID;
		inputDTime = srcDTime;
		db = DatabaseManager.getInstance();
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
		return db.fetchMemberByID(memberID).getName();
	}
	
	public LocalDate getDate() {
		return serviceDate;
	}
	
	public LocalDateTime getInputDate() {
		return inputDTime;
	}
	
	public int getServiceID() {
		return serviceID;
	}
	
	public String getProviderName() throws IOException {
		return db.fetchProviderByID(providerID).getName();
	}
	
	public String getName() throws IOException {
		return db.getServiceName(serviceID);
	}
	
	public int getFee() throws IOException {
		return db.getServiceFee(serviceID);
	}
	
	public void logService() throws IOException {
		db.addService(this);
	}
	
	public void print() throws IOException {
		System.out.println("Service Details");
		System.out.println("Service file Date and Time: " + inputDTime);
		System.out.println("Date the Service was Provided: " + serviceDate);
		System.out.println("Member Name: " + getMemberName());
		System.out.println("Member Number: " + memberID);
		System.out.println("Service Code: " + serviceID);
		System.out.println("Fee: $" + getFee());
		
	}
	
}