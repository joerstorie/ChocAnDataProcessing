// Sean Hurley
package team4package;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class DatabaseManagerTest {
	DatabaseManager db;
	Member dummy;

	@Before
	public void setUp() throws Exception {
		db = DatabaseManager.getInstance();
		db.importDatabase();
	}
	
	@Test // method written by Sean
	public void testForReadServiceTypeSuccess() { // Test to make sure it can find ID:1 "Dental Procedure", scanned from servicetypes.csv
		assertEquals("Dental Procedure",db.getServiceName(1));
	}
	
	@Test // method written by Sean
	public void testForFakeServiceTypeFailure() { // Test to make sure it can't find fake ID:-1
		assertEquals("No Service Found",db.getServiceName(-1));
	}
	
	@Test // method written by Riley
	public void testForAddMember() throws IOException{ // Test to assert added member (without exporting)
		assertFalse(db.validateMemberID(55932600));
		dummy = new Member(55932600, "Steve", "1831 Fake Rd", "Tuscaloosa", "Alabama", "80921");
		db.addMember(dummy, false); //false means it doesn't export to members.csv
		assertTrue(db.validateMemberID(55932600));
	}
}
