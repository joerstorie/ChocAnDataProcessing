package team4package;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

class SummaryReport {
	public void saveReport() {
		FileWriter fw = new FileWriter("EFTDataLog.txt");
		PrintWriter pw = new PrintWriter(fw);
		pw.print("EFT Data Log\n");
	}
}