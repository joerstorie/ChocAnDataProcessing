// Trent Boughner -- Test Cases
package team4package;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProviderTerminalTest {

	Provider newProv;	
	
	@Before
	public void setUp() throws Exception {
		newProv = new Provider(123456789, "Trent", "777 Atlantis Ave.", "Birmingham", "Alabama", "35242");
	}
	// Checking Provider's Address - implemented this method
	@Test
	public void testGetAddressForSuccess() {
		assertEquals("777 Atlantis Ave.", newProv.getAddress());
	}
	// Checking Provider's City - implemented this method
	@Test
	public void testGetCityForFailure() {
		assertNotEquals("Tuscaloosa", newProv.getCity());
	}
	// Checking Provider's ZIP Code - did not implement this method
	@Test
	public void testGetZipForSuccess() {
		assertEquals("35242", newProv.getZip());
	}
	

}
