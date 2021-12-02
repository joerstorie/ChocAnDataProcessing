// Trent Boughner -- Test Cases
package team4package;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProviderTest2 {

	Provider newProv;	
	
	@Before
	public void setUp() throws Exception {
		newProv = new Provider(123456789, "Trent", "777 Atlantis Ave.", "Birmingham", "Alabama", "35242");
	}
	// Checking Provider's Address
	@Test
	public void getAddress() {
		assertEquals("777 Atlantis Ave.", newProv.getAddress());
	}
	// Checking Provider's City
	@Test
	public void getCity() {
		assertEquals("Birmingham", newProv.getCity());
	}
	// Checking Provider's ZIP Code
	@Test
	public void getZip() {
		assertEquals("35242", newProv.getZip());
	}
	
	public void tearDown() throws Exception {
		
	}
}
