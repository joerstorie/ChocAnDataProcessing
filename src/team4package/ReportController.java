package team4package;
import team4package.EFTDataLog;
import team4package.MemberReport;
import team4package.ProviderReport;
import team4package.SummaryReport;

class ReportController{
	
	ReportController(){}
	
	public void createReports() {
		createEFTDataLog();
	}
	
	private void createEFTDataLog() {
		EFTDataLog eft = new EFTDataLog();
		eft.saveLog();
	}
	
	private void createMemberReport() {
		MemberReport mr = new MemberReport();
		mr.saveReport();
		
	}
	
	private void createProviderReport() {
		ProviderReport pr = new ProviderReport();
		pr.saveReport();
	}
	
	private void createSummaryReport() {
		SummaryReport sr = new SummaryReport();
		sr.saveReport();
	}
	
}