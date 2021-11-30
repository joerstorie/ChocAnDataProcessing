// Trent Boughner
package team4package;

import java.util.List;
import java.io.IOException;

public class ProviderController {
	DatabaseManager db;
	private List<Provider> providers;
	private List<Member> members;
	private List<Member> services;
	
	ProviderController() throws IOException {
		db = DatabaseManager.getInstance();
		setProviders();
		setMembers();
	}
	
	private void setMembers() {
		members = db.getMembers();
	}
	
	private void setProviders() {
		providers = db.getProviders();
	}
	
	private void getServices() {
		services = db.getServices();
	}
	
	private void createServiceRecord() {
		serviceRecord = db.
	}
}
