// Sean Hurley
package team4package;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DatabaseManagerTest {
	DatabaseManager db;

	@Before
	public void setUp() throws Exception {
		db = DatabaseManager.getInstance();
		db.importDatabase();
		
	}

	@Test
	public void testForReadServiceTypeSuccess() {
		assertEquals("Dental Procedure",db.getServiceName(1));
	}
	
	public void testForFakeServiceFailure() {
		assertEquals("No Service Found",db.getServiceName(-1));
	}

}
