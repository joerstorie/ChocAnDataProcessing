package team4package;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

class ReportController{
	DatabaseManager db;
	// creates lists of providers and members
	private List<Provider> providers;
	private List<Member> members;
	
	// creates instance of report controller
	ReportController() throws IOException{
		db = DatabaseManager.getInstance();
		setProviders();
		setMembers();
	}
	
	// creates EFTDataLog, Summary Report, Member Report, and Provider Report based on user input
	public void createReports() throws IOException {
		members = db.getMembers();
		providers = db.getProviders();
		
		FileWriter fw = new FileWriter("AllReports.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		EFTDataLog eft = new EFTDataLog();
		eft.saveLogAll(fw, pw);
		
		SummaryReport sr = new SummaryReport();
		sr.saveReportAll(fw, pw);
		
		for(int i = 0; i < members.size(); i++) {
			Member mem = db.fetchMemberByID(i+1);
			MemberReport mr = new MemberReport(mem);
			mr.saveReportAll(fw, pw);
		}
		
		for(int i = 0; i < providers.size(); i++) {
			ProviderReport pr = new ProviderReport(providers.get(i));
			pr.saveReportAll(fw, pw);
		}
		
		pw.close();
	}
	
	// creates EFTDataLog
	public void createEFTDataLog() throws IOException {
		EFTDataLog eft = new EFTDataLog();
		eft.saveLog();
	}
	
	// creates Member Report
	public void createMemberReport(Member src) throws IOException {
		MemberReport mr = new MemberReport(src);
		mr.saveReport();
		
	}
	
	// validates member ID
	public boolean checkMemID(int ID) {
		return db.validateMemberID(ID);
	}
	
	// validates provider ID
	public boolean checkProvID(int ID) {
		return db.validateProviderID(ID);
	}
	
	// creates Member Report with member ID parameter
	public void createMemberReport(int ID) throws IOException {
		Member mem = db.fetchMemberByID(ID);
		createMemberReport(mem);
	}
	
	// creates Provider Report with provider source parameter
	public void createProviderReport(Provider src) throws IOException {
		ProviderReport pr = new ProviderReport(src);
		pr.saveReport();
	}
	
	// creates Provider Report with provider ID parameter
	public void createProviderReport(int ID) throws IOException {
		Provider prov = db.fetchProviderByID(ID);
		createProviderReport(prov);
	}
	
	// creates Summary Report
	public void createSummaryReport() throws IOException {
		SummaryReport sr = new SummaryReport();
		sr.saveReport();
	}
	
	// sets members
	private void setMembers() {
		members = db.getMembers();
	}
	
	// sets providers
	private void setProviders() {
		providers = db.getProviders();
	}
}