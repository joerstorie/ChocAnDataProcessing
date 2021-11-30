//Jake Silvey
package team4package;


import java.io.File;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

class EFTDataLog {
	DatabaseManager db;
	
	EFTDataLog() throws IOException{
		db = DatabaseManager.getInstance();
	}

	public void saveLog() throws IOException {
		FileWriter fw = new FileWriter("EFTDataLog.txt");
		PrintWriter pw = new PrintWriter(fw);
		pw.print("EFT Data Log\n\n");
		
		ArrayList<Provider> providers = db.getProviders();
		for (int i = 0; i < providers.size(); i++) {
			int currFee = providers.get(i).getTotalFee();
			pw.print(providers.get(i).getName() + "----" + "$" + currFee);
			pw.print("\n");
		}

		pw.close();
	}
	
	
}