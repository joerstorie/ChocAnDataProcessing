package team4package;

import java.io.IOException;

class ReportController{
	
	ReportController(){}
	
	public void createReports() throws IOException {
		createEFTDataLog();
		createSummaryReport();
		
		int[] memberIDS = getMembers();
		for(int i = 0; i < memberIDS.length; i++) {
			createMemberReport(memberIDS[i]);
		}
		
		int[] providerIDS = getProviders();
		for(int i = 0; i < providerIDS.length; i++) {
			createProviderReport(providerIDS[i]);
		}
	}
	
	public void createEFTDataLog() throws IOException {
		EFTDataLog eft = new EFTDataLog();
		eft.saveLog();
	}
	
	public void createMemberReport(int ID) {
		MemberReport mr = new MemberReport(ID);
		mr.saveReport();
		
	}
	
	public void createProviderReport(int ID) {
		ProviderReport pr = new ProviderReport(ID);
		pr.saveReport();
	}
	
	public void createSummaryReport() {
		SummaryReport sr = new SummaryReport();
		sr.saveReport();
	}
	
	private int[] getMembers() {
		int[] temp = new int[]{1, 2, 3};
		return temp;
	}
	
	private int[] getProviders() {
		int[] temp = new int[]{2, 3, 4};
		return temp;
	}
}