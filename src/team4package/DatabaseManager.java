package team4package;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

class DatabaseManager {
	
	private ArrayList<Member> members = new ArrayList<>();
	//private List<Member> fees;
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
		
		while((row = servicesReader.readLine()) != null) {
			String[] data = row.split(",");
			Service newService = new Service(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), LocalDate.parse(data[3]));
			services.add(newService);
		}
		
		while((row = serviceTypesReader.readLine()) != null) {
			String[] data = row.split(",");
			ServiceType newType = new ServiceType(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]));
			serviceTypes.add(newType);
		}
		
		membersReader.close();
		providersReader.close();
		servicesReader.close();
		serviceTypesReader.close();
	}
	
	public void exportDatabase() throws IOException {
		// Implement this
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
	
	public boolean validateMemberID(int ID) {
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getID() == ID) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validateProviderID(int ID) {
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
		//exportDatabase();  //unsure if this is needed
	}
	
	public void addProvider(Provider addMe) throws IOException { // adds 'addMe' to the local providers list
		providers.add(addMe);
		//exportDatabase();  //unsure if this is needed
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
			System.out.println("Service Name: " + serviceTypes.get(i).getName() + " Fee: " + serviceTypes.get(i).getFee());
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
	
	public int getServiceFee(int ID) {
		for(int i = 0; i < serviceTypes.size(); i++) {
			if(serviceTypes.get(i).getID() == ID) {
				return serviceTypes.get(i).getFee();
			}
		}
		return 0;
	}
}
	
	
	
	
