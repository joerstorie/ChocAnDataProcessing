package team4package;

import java.util.Arrays;
import java.util.List;

class MemberReport {
	DatabaseManager db;
	
	private Member member;
	private List<Service> serviceList;
	
	
	MemberReport(Member src){
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