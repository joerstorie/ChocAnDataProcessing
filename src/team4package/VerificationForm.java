package team4package;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VerificationForm {

	DatabaseManager db;
	private Provider provider;
	
	VerificationForm(Provider src) throws IOException{
		db = DatabaseManager.getInstance();
		provider = src;
	}
	
	VerificationForm(Member src) throws IOException{
		db = DatabaseManager.getInstance();
		member = src;
	}
	
	public void saveForm() throws IOException {
		
		LocalDateTime atm = LocalDateTime.now();
		FileWriter fw = new FileWriter(name.replace(" ", "") + ".txt");
		PrintWriter pw = new PrintWriter(fw);
		LocalDate serviceDate = services.getDate();
		pw.print("Verification Form\n\n");
		String serviceDate = service.getDate();
		pw.print(false);
		int providerID = provider.getID();
		pw.print("Provider ID: " + providerID + "\n");
		int memberID = member.getID();
		pw.print("Member ID: " + memberID + "\n");
		int serviceCode = service.getCode();
		pw.print("Service Code: " + serviceCode + "\n");
		// enter comments up to 100 chars
		pw.close();
	}
}
