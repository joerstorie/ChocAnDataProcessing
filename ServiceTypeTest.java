// Joseph Storie
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

	@Test
	public void testGetIDForSuccess() {
		assertEquals(1, serviceType.getID());
	}
	
	@Test
	public void testGetIDForFailure() {
		assertNotEquals(0, serviceType.getID());
	}

}
