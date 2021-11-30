//Jake Silvey
package team4package;

import java.io.File;



import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

class SummaryReport {
	DatabaseManager db;
	
	SummaryReport() throws IOException {
		db = DatabaseManager.getInstance();
	}
	public void saveReport() throws IOException {
		int numProviders = 0;
		int numServices = 0;
		int totNumServices = 0;
		int totalFee = 0;
		
		FileWriter fw = new FileWriter("SummaryReport.txt");
		PrintWriter pw = new PrintWriter(fw);
		pw.print("Summary Report\n\n");
		
		ArrayList<Provider> providers = db.getProviders();
		for (int i = 0; i < providers.size(); i++) {
			numProviders++;
			numServices = providers.get(i).getNumServices();
			totNumServices = totNumServices + numServices;
			int currFee = providers.get(i).getTotalFee();
			totalFee = totalFee + currFee;
			pw.print(providers.get(i).getName() + "----" + numServices + " services" + "----" + "$" + currFee);
			pw.print("\n");
			
		}
		pw.print("\n");
		pw.print("Total Number of Providers: " + numProviders + "\n");
		pw.print("Total Number of Services: " + totNumServices + "\n");
		pw.print("Total Number of Fees: " + totalFee + "\n");
		pw.close();
	}
}