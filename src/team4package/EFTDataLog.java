package team4package;
import team4package.DatabaseManager;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

class EFTDataLog {
	double provCredit = 0.00;

	public double getProvCredit(double provCredit) {
		return provCredit;
	}

	public void saveLog() throws IOException {
		FileWriter fw = new FileWriter("EFTDataLog.txt");
		PrintWriter pw = new PrintWriter(fw);
		pw.print("EFT Data Log\n");
		
		List<Provider> providers = getProviders();
		for (int i = 0; i < providers.size(); i++) {
			int currFee = providers.get(i).getTotalFee();
			pw.print(providers.get(i).name + "----" + currFee);
			pw.print("\n");
		}

		pw.close();
	}
}