// Trent Boughner
package team4package;

public class ProviderController {
	DatabaseManager db;
	private List<Provider> providers;
	private List<Member> members;
	
	ProviderController() {
		db = new DatabaseManager();
		setProviders();
		setMembers();
	}
	
	private void setMembers() {
		members = db.getProviders();
	}
	
	private void setProviders() {
		providers = db.getProviders();
	}
	
}
