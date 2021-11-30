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
	
	public boolean checkMemID(int ID) {
		return db.validateMemberID(ID);
	}
	
	public boolean checkProvID(int ID) {
		return db.validateProviderID(ID);
	}
	
	public void createMemberReport(int ID) throws IOException {
		Member mem = db.fetchMemberByID(ID);
		createMemberReport(mem);
	}
	
	public void createProviderReport(Provider src) throws IOException {
		ProviderReport pr = new ProviderReport(src);
		pr.saveReport();
	}
	
	public void createProviderReport(int ID) throws IOException {
		Provider prov = db.fetchProviderByID(ID);
		createProviderReport(prov);
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