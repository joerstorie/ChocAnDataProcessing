//Rodney Wade
package team4package;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Service {
	
	private LocalDate serviceDate;
	private int providerID;
	private int memberID;
	private int serviceID;
	private int serviceIDX;
	private String comments = "";
	private LocalDateTime inputDTime;
	DatabaseManager db;
	
	// Constructor for service; variables for functions in the Service
	Service(int srcIDX, int srcTypeID, int srcProvID, int srcMemID, LocalDate srcDate, LocalDateTime srcDTime) throws IOException {
		serviceDate = srcDate;
		providerID = srcProvID;
		memberID = srcMemID;
		serviceID = srcTypeID;
		inputDTime = srcDTime;
		db = DatabaseManager.getInstance();
		serviceIDX = srcIDX;
	}
	
	// adds comments to the service
	public void addComments(String srcComments) {
		comments = srcComments;
	}
	
	// returns the ID of the provider who administered the service
	public int getProviderID() {
		return providerID;
	}
	
	// returns the ID of the member who received the service
	public int getMemberID() {
		return memberID;
	}
	
	// returns the name of the member who received the service
	public String getMemberName() throws IOException {
		return db.fetchMemberByID(memberID).getName();
	}
	
	// returns the date of the service
	public LocalDate getDate() {
		return serviceDate;
	}
	
	// returns the date the service was added
	public LocalDateTime getInputDate() {
		return inputDTime;
	}
	
	// returns the ID of the service
	public int getServiceID() {
		return serviceID;
	}
	
	// returns the IDX of the service
	public int getServiceIDX() {
		return serviceIDX;
	}
	
	// returns the ID of the provider who administered the service
	public String getProviderName() throws IOException {
		return db.fetchProviderByID(providerID).getName();
	}
	
	// returns the name of the service
	public String getName() throws IOException {
		return db.getServiceName(serviceID);
	}
	
	// returns the fee associated with the service
	public int getFee() throws IOException {
		return db.getServiceFee(serviceID);
	}
	
	// logs this current service into the database
	public void logService() throws IOException {
		db.addService(this);
	}
	
	// returns the comments on this service
	public String getComments() {
		return comments;
	}
	
	// prints the details of the service
	public void print() throws IOException {
		System.out.println("Service Details");
		System.out.println("Service file Date and Time: " + inputDTime);
		System.out.println("Date the Service was Provided: " + serviceDate);
		System.out.println("Member Name: " + getMemberName());
		System.out.println("Member Number: " + memberID);
		System.out.println("Service Code: " + serviceID);
		System.out.println("Fee: $" + getFee());
		if(comments != "") {
			System.out.println("Comments: " + comments);
		}
		
	}
	
}