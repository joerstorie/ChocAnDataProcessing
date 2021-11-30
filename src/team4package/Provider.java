package team4package;

import java.util.List;

class Provider{
	DatabaseManager db;
	
	private int ID;
	private String name;
	
	Provider(int srcID, String srcName){
		db = new DatabaseManager();
		ID = srcID;
		name = srcName;
	}
	
	public int getTotalFee() {
		int total = 0;
		
		List<Service> services = db.getServices();
		for(int i = 0; i < services.size(); i++) {
			if(services.get(i).getProviderID() == ID) {
				total += services.get(i).getFee();
			}
		}
		return total;
	}
	
	public String getName() {
		return name;
	}
}