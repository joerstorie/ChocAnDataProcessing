package team4package;

import java.util.List;

class DatabaseManager {
	
	private List<Member> members;
	//private List<Member> fees;
	private List<Provider> providers;
	private List<Service> services;
	
	DatabaseManager(){
		// Read information from csv(s)
	}
	
	boolean CheckID(int memberID) {
		int memberIDmatch;
		
		if (/* match found */) {
			return true;
		}
		else (/* match not found*/) {
			return false;
		}
	}
	
	/*int CheckMemberFee(int memberID) {
		int memberFee;
		
		return memberFee;
	}*/
}