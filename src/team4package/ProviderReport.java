package team4package;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

class ProviderReport {
	private Provider provider;
	
	ProviderReport(Provider src){
		provider = src;
	}
	
	public void saveReport() throws IOException {
		FileWriter fw = new FileWriter("EFTDataLog.txt");
		PrintWriter pw = new PrintWriter(fw);
		pw.print("Provider Report\n\n");
		String name = provider.getName();
		pw.print(name + "\n");
		int ID = provider.getID();
		pw.print(ID + "\n");
		String address = provider.getAddress();
		pw.print(address + "\n");
		String city = provider.getCity();
		pw.print(city + "\n");
		String state = provider.getState();
		pw.print(state + "\n");
		String zip = provider.getZip();
		pw.print(zip + "\n");
		
	
		
		
	}
	
}