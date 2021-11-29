package team4package;

import java.util.List;

class DatabaseManager {
	
	private List<Member> members;
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
	
	
	
	
	
}