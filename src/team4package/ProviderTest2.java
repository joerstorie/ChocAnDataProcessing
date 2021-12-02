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
	// Testing to 
	@Test
	public void getAddress() {
		assertEquals("777 Atlantis Ave.", newProv.getAddress());
	}
	
	@Test
	public void getCity() {
		assertEquals("Birmingham", newProv.getCity());
	}
	
	@Test
	public void getZip() {
		assertEquals("35242", newProv.getZip());
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
}
