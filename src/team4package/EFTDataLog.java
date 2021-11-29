package team4package;

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
		pw.print("Date\n");
		pw.print("Name - Charge");
		pw.close();
	}
}