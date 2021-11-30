// Trent Boughner
package team4package;

import java.util.List;
import java.io.IOException;

public class ProviderController {
	DatabaseManager db;
	private List<Provider> providers;
	private List<Member> members;
	
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
	
}
