package team4package;

import java.io.File;


import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;


class SummaryReport {
	DatabaseManager db;
	
	SummaryReport() {
		db = new SummaryReport();
	}
	public void saveReport() throws IOException {
		int numProviders = 0;
		int numServices = 0;
		int totNumServices = 0;
		int totalFee = 0;
		
		FileWriter fw = new FileWriter("EFTDataLog.txt");
		PrintWriter pw = new PrintWriter(fw);
		pw.print("EFT Data Log\n");
		
		List<Provider> providers = db.getProviders();
		for (int i = 0; i < providers.size(); i++) {
			numProviders++;
			numServices = providers.get(i).getNumServices();
			totalNumServices = totNumServices + numServices;
			int currFee = providers.get(i).getTotalFee();
			totaFee = totalFee + currFee;
			pw.print(providers.get(i).getName() + "----" + numServices + "services" + "----" + "$", currFee);
			pw.print("\n");
			
		}
		pw.print("\n");
		pw.print("Total Number of Providers: " + numProviders + "\n");
		pw.print("Total Number of Services: " + totNumServices + "\n");
		pw.print("Total Number of Fees: " + totalFee + "\n");
		pw.close();
	}
}