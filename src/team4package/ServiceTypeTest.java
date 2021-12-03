// Rodney Wade
package team4package;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServiceTypeTest {

	ServiceType serviceType;
	
	@Before
	public void setUp() throws Exception {
		serviceType = new ServiceType(1, "name", 100);
	}

	@Test // method written by Rodney
	public void testGetIDForSuccess() {
		assertEquals(1, serviceType.getID());
	}
	
	@Test // method written by Rodney
	public void testGetIDForFailure() {
		assertNotEquals(0, serviceType.getID());
	}
	
	@Test // method written by Joseph
	public void testGetNameForSuccess() {
		assertEquals("name", serviceType.getName());
	}
	
	@Test // method written by Joseph
	public void testGetNameForFailure() {
		assertNotEquals("Trent", serviceType.getName());
	}

}

