// Jake Silvey
package team4package;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProviderTest {
	Provider newProv;

	@Before
	public void setUp() throws Exception {
		newProv = new Provider(12, "Jake", "1234 Dr", "Tuscaloosa", "Alabama", "35401");
	}
	
	// method written by Jake
	@Test //Testing to see if Provider State is stored correctly to its respective provider
	public void ProviderStateTestForSuccess() {
		assertEquals("Alabama", newProv.getState());
	}
	
	// method written by Jake
	@Test //Checking Provider's Name
	public void ProviderNameTestForFailure() {
		assertNotEquals("Riley", newProv.getName());
	}
	
	// method written by Trent
	@Test //Checking Provider's ID
	public void ProviderIDTestForSuccess() {
		assertEquals(12, newProv.getID());
	}

}