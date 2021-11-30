package team4package;

import java.io.IOException;
import java.util.List;

class ReportController{
	DatabaseManager db;
	private List<Provider> providers;
	private List<Member> members;
	
	ReportController(){
		db = new DatabaseManager();
		setProviders();
		setMembers();
	}
	
	public void createReports() throws IOException {
		createEFTDataLog();
		createSummaryReport();
		
		for(int i = 0; i < members.size(); i++) {
			createMemberReport(members.get(i));
		}
		
		for(int i = 0; i < providers.size(); i++) {
			createProviderReport(providers.get(i));
		}
	}
	
	public void createEFTDataLog() throws IOException {
		EFTDataLog eft = new EFTDataLog();
		eft.saveLog();
	}
	
	public void createMemberReport(Member src) throws IOException {
		MemberReport mr = new MemberReport(src);
		mr.saveReport();
		
	}
	
	public void createProviderReport(Provider src) throws IOException {
		ProviderReport pr = new ProviderReport(src);
		pr.saveReport();
	}
	
	public void createSummaryReport() throws IOException {
		SummaryReport sr = new SummaryReport();
		sr.saveReport();
	}
	
	private void setMembers() {
		members = db.getMembers();
	}
	
	private void setProviders() {
		providers = db.getProviders();
	}
}