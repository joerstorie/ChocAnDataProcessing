package team4package;

import java.util.ArrayList;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class DatabaseManager {
	
	private ArrayList<Member> members = new ArrayList<>();
	private ArrayList<Provider> providers = new ArrayList<>();
	private ArrayList<Service> services = new ArrayList<>();
	private ArrayList<ServiceType> serviceTypes = new ArrayList<>();
	private static final DatabaseManager instance = new DatabaseManager();
	
	public static DatabaseManager getInstance() throws IOException {
		return instance;
	}
	
	private DatabaseManager() {
	}
	
	public void importDatabase() throws IOException {
		// Read information from csv(s)
		BufferedReader membersReader = new BufferedReader(new FileReader("./data/members.csv"));
		BufferedReader providersReader = new BufferedReader(new FileReader("./data/providers.csv"));
		BufferedReader servicesReader = new BufferedReader(new FileReader("./data/services.csv"));
		BufferedReader serviceTypesReader = new BufferedReader(new FileReader("./data/servicetypes.csv"));
		
		
		// Reading and creating members
		String row;
		while ((row = membersReader.readLine()) != null) {
			String[] data = row.split(",");
			Member newMember = new Member(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]);
			members.add(newMember);
		}
		
		//Reading and creating providers
		while ((row = providersReader.readLine()) != null){
			String[] data = row.split(",");
			Provider newProvider = new Provider(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]);
			providers.add(newProvider);
		}
		
		int i = 1;
		while((row = servicesReader.readLine()) != null) {
			String[] data = row.split(",");
			Service newService = new Service(i, Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), LocalDate.parse(data[3]), LocalDateTime.parse(data[4]));
			services.add(newService);
			i++;
		}
		
		while((row = serviceTypesReader.readLine()) != null) {
			String[] data = row.split(",");
			ServiceType newType = new ServiceType(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]));
			serviceTypes.add(newType);
		}
		sortServiceTypes();
		
		membersReader.close();
		providersReader.close();
		servicesReader.close();
		serviceTypesReader.close();
	}
	
	private void exportMembersCSV() throws IOException {
		FileWriter fw = new FileWriter("./data/membersTEST.csv");
		PrintWriter pw = new PrintWriter(fw);
		for(int i=0; i < members.size(); i++) {
			pw.print(members.get(i).getID() + "," + members.get(i).getName() + "," + members.get(i).getAddress() + "," + members.get(i).getCity() + "," + members.get(i).getState() + "," + members.get(i).getZip() + "\n");
		}
		pw.close();
	}
	
	private void exportProvidersCSV() throws IOException {
		FileWriter fw = new FileWriter("./data/providersTEST.csv");
		PrintWriter pw = new PrintWriter(fw);
		for(int i=0; i < providers.size(); i++) {
			pw.print(providers.get(i).getID() + "," + providers.get(i).getName() + "," + providers.get(i).getAddress() + "," + providers.get(i).getCity() + "," + providers.get(i).getState() + "," + providers.get(i).getZip() + "\n");
		}
		pw.close();
	}
	
	private void exportServicesCSV() throws IOException {
		FileWriter fw = new FileWriter("./data/servicesTEST.csv");
		PrintWriter pw = new PrintWriter(fw);
		for(int i=0; i < services.size(); i++) {
			//still writing, needed to push
			//pw.print(services.get(i).getDate() + "," + services.get(i).getProviderID() + "," + services.get(i).getMemberID() + "," + services.get(i).get() + "," + services.get(i).getState() + "," + services.get(i).getZip() + "\n");
		} //int srcID, int srcProvID, int srcMemID, LocalDate srcDate, LocalDateTime srcDTime
		pw.close();
	}
	
	private void exportServiceTypesCSV() throws IOException {
		FileWriter fw = new FileWriter("./data/providersTEST.csv");
		PrintWriter pw = new PrintWriter(fw);
		for(int i=0; i < providers.size(); i++) {
			pw.print(providers.get(i).getID() + "," + providers.get(i).getName() + "," + providers.get(i).getAddress() + "," + providers.get(i).getCity() + "," + providers.get(i).getState() + "," + providers.get(i).getZip() + "\n");
		}
		pw.close();
	}
	
	public void exportDatabase() throws IOException { // updates the csv files with the current lists
		exportMembersCSV();
		exportProvidersCSV();
		exportServicesCSV();
	}
	
	public void exportProviderDirectory() throws IOException { // exports Provider Directory to txt file (instead of email)
		displayServiceTypes();
	}
	

	public ArrayList<Provider> getProviders(){
		return providers;
	}
	
	public ArrayList<Service> getServices(){
		return services;
	}
	
	public ArrayList<Service> getServicesByID(int ID, String type){
		ArrayList<Service> temp = new ArrayList<>();
		
		switch(type) {
		
		case "Provider":
			for(int i = 0; i < services.size(); i++) {
				if(services.get(i).getProviderID() == ID) {
					temp.add(services.get(i));
				}
			}
			break;
		
		case "Member":
			for(int i = 0; i < services.size(); i++) {
				if(services.get(i).getMemberID() == ID) {
					temp.add(services.get(i));
				}
			}
			break;
		}
		return temp;
	}
	
	public ArrayList<Member> getMembers(){
		return members;
	}
	
	public boolean validateMemberID(int ID) { // returns true if member exists, based on ID
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getID() == ID) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validateProviderID(int ID) { // returns true if provider exists, based on ID
		for(int i = 0; i < providers.size(); i++) {
			if(providers.get(i).getID() == ID) {
				return true;
			}
		}
		return false;
	}
	
	public Member fetchMemberByID(int ID) {
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getID() == ID) {
				return members.get(i);
			}
		}
		return members.get(0);
	}
	
	public Provider fetchProviderByID(int ID) {
		for(int i = 0; i < providers.size(); i++) {
			if(providers.get(i).getID() == ID) {
				return providers.get(i);
			}
		}
		return providers.get(0);
	}
	
	public void addMember(Member addMe) throws IOException { // adds 'addMe' to the local members list
		members.add(addMe);
		exportDatabase();
	}
	
	public void addProvider(Provider addMe) throws IOException { // adds 'addMe' to the local providers list
		providers.add(addMe);
		exportDatabase();
	}
	
	public void deleteMember(int ID) throws IOException { // deletes member based on ID from the local members list
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getID() == ID) {
				members.remove(i);
				break;
			}
		}
		exportDatabase();
	}
	
	public void deleteProvider(int ID) throws IOException { // deletes provider based on ID from the local providers list
		for(int i = 0; i < providers.size(); i++) {
			if(providers.get(i).getID() == ID) {
				providers.remove(i);
				break;
			}
		}
		exportDatabase();
	}
	
	public void displayMembers() {
		for(int i = 0; i < members.size(); i++) {
			System.out.println("Member Name: " + members.get(i).getName() + " Member ID: " + members.get(i).getID());
		}
	}
	
	public void displayProviders() {
		for(int i = 0; i < providers.size(); i++) {
			System.out.println("Provider Name: " + providers.get(i).getName() + " Provider ID: " + providers.get(i).getID());
		}
	}
	
	public void displayServices() throws IOException {
		for(int i = 0; i < services.size(); i++) {
			System.out.println("Service Name: " + services.get(i).getName() + " Member Name: " + services.get(i).getMemberName());
		}
	}
	
	public void displayServiceTypes() throws IOException {
		for(int i = 0; i < serviceTypes.size(); i++) {
			System.out.println("Service Name: " + serviceTypes.get(i).getName() + " -- Service Code: " + serviceTypes.get(i).getID() + " -- Fee: $" + serviceTypes.get(i).getFee());
		}
	}

	public String getServiceName(int ID) {
		for(int i = 0; i < serviceTypes.size(); i++) {
			if(serviceTypes.get(i).getID() == ID) {
				return serviceTypes.get(i).getName();
			}
		}
		return "No Service Found";
	}
	
	public Service getService(int ID) {
		for(int i = 0; i < services.size(); i++) {
			if(services.get(i).getServiceIDX() == ID) {
				return services.get(i);
			}
		}
		return (Service) null;
	}
	
	public int getServiceFee(int ID) {
		for(int i = 0; i < serviceTypes.size(); i++) {
			if(serviceTypes.get(i).getID() == ID) {
				return serviceTypes.get(i).getFee();
			}
		}
		return 0;
	}
	
	public void addService(Service src) throws IOException {
		services.add(src);
		exportDatabase();
	}
	
	private void sortServiceTypes() {
		serviceTypes.sort((o1, o2)
	                      -> o1.getName().compareTo(
	                          o2.getName()));
	}
}
	
	
	
	
