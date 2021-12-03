// Trent Boughner
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
	
	// method written by Trent
	@Test // Checking Provider's Address - implemented this method
	public void testGetAddressForSuccess() {
		assertEquals("777 Atlantis Ave.", newProv.getAddress());
	}
	
	// method written by Trent
	@Test // Checking Provider's City - implemented this method
	public void testGetCityForFailure() {
		assertNotEquals("Tuscaloosa", newProv.getCity());
	}
	
	// method written by Riley
	@Test // Checking Provider's ZIP Code - did not implement this method
	public void testGetZipForSuccess() {
		assertEquals("35242", newProv.getZip());
	}
	

}
