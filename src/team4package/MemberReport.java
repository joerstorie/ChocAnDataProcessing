package team4package;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class MemberReport {
	DatabaseManager db;
	
	private Member member;
	private List<Service> serviceList;
	
	
	MemberReport(Member src) throws IOException{
		db = DatabaseManager.getInstance();
		member = src;
	}
	
	private void gatherServices() {
		List<Service> allServices = db.getServices();
		for(int i = 0; i < allServices.size(); i++) {
			if(allServices.get(i).getMemberID() == member.getID()) {
				serviceList.add(allServices.get(i));
			}
		}
		
	}
	
}