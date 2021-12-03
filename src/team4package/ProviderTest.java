//Jake Silvey -- Test Case 1
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
	//Testing to see if Provider State is stored correctly to its respective provider
	@Test
	public void ProviderStateTestForSuccess() {
		assertEquals("Alabama", newProv.getState());
	}
	//Checking Provider's Name
	@Test
	public void ProviderNameTestForFailure() {
		assertNotEquals("Riley", newProv.getName());
	}
	//Checking Provider's ID
	@Test
	public void ProviderIDTestForSuccess() {
		assertEquals(12, newProv.getID());
	}

}