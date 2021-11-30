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
	

	public List<Provider> getProviders(){
		return providers;
	}
	
	public List<Service> getServices(){
		return services;
	}
	
	public List<Member> getMembers(){
		return members;
	}
	
	public boolean validateMemberID(int ID) {
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getID() == ID) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validateProviderID(int ID) {
		for(int i = 0; i < providers.size(); i++) {
			if(providers.get(i).getID() == ID) {
				return true;
			}
		}
		return false;
	}
	
	public Member fetchMemberByID(int ID) {
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getID() == ID) {
				return members.get(i);
			}
		}
		return members.get(0);
	}
	
	public Provider fetchProviderByID(int ID) {
		for(int i = 0; i < providers.size(); i++) {
			if(providers.get(i).getID() == ID) {
				return providers.get(i);
			}
		}
		return providers.get(0);
	}

}
	
	
	
	
