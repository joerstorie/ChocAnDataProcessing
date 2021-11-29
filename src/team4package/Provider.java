package team4package;

import java.util.List;

class Provider{
	DatabaseManager db;
	
	Provider(){
		db = new DatabaseManager();
	}
	
	public int getTotalFee(int ID) {
		int total = 0;
		
		List<Service> services = db.getServices();
		for(int i = 0; i < services.size(); i++) {
			if(services.get(i).getProviderID(); == ID) {
				total += services.get(i).getFee();
			}
		}
		return total;
	}
}