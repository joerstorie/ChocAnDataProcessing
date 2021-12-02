//Jake Silvey -- Test Case 1
package team4package;

import static org.junit.Assert.*;

import org.junit.After;
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
	public void ProviderStateTest() {
		assertEquals("Alabama", newProv.getState());
	}
	//Checking Provider's Name
	@Test
	public void ProviderNameTest() {
		assertEquals("Jake", newProv.getName());
	}
	//Checking Provider's ID
	@Test
	public void ProviderIDTest() {
		assertEquals(12, newProv.getID());
	}
	
	@After
	public void tearDown() throws Exception {
	}
}