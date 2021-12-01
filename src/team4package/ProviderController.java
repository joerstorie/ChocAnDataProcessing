package team4package;

import java.io.IOException;
import java.util.List;

public class ProviderController {
	DatabaseManager db;
	private List<Provider> providers;
	private List<Member> members;
	
	ProviderController() throws IOException{
		db = DatabaseManager.getInstance();
		setProviders();
		setMembers();
	}
	// the current date and time, the date the service was provided, member name and number, 
	// service code, and fee to be paid
	public void createVerificationForm() throws IOException {
		createVerificationForm();
		
		for(int i = 0; i < members.size(); i++) {
			createVerificationForm(members.get(i));
		}
	}
	
	public boolean checkMemID(int ID) {
		return db.validateMemberID(ID);
	}
	
	private void setMembers() {
		members = db.getMembers();
	}
}
