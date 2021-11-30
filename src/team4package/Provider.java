package team4package;

import java.util.List;

class Provider{
	DatabaseManager db;
	
	private int ID;
	private String name;
	
	Provider(int srcID, int srcFee, String srcName){
		ID = srcID;
		fee = srcFee;
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
	
	public int getNumServices() {
		int num = 0;
		
		List<Service> services = db.getServices();
		for(int i = 0; i < services.size(); i++) {
			if(services.get(i).getProviderID() == ID) {
				num++;
			}
		}
		return num;
	}
	
	public List<Service> getServices(){
		return db.getServicesByID(ID, "Provider");
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return ID;
	}
}