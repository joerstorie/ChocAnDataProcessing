//Created by Sean Hurley
package team4package;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagerMemberTest {
	Member Jeff;

	@Before
	public void setUp() throws Exception {
		Jeff = new Member(567231, "Jeff Dunham", "1831 Fake Rd", "Tuscaloosa", "Alabama", "12345");
	}
	
	@Test
	public void testID() {
		assertEquals(567231,Jeff.getID());
	}

	@Test
	public void testName() {
		assertEquals("Jeff Dunham",Jeff.getName());
	}
	
	@Test
	public void testStreetAddress() {
		assertEquals("1831 Fake Rd",Jeff.getAddress());
	}
	
	@Test
	public void testCity() {
		assertEquals("Tuscaloosa",Jeff.getCity());
	}
	
	@Test
	public void testState() {
		assertEquals("Alabama",Jeff.getState());
	}
	
	@Test
	public void testZip() {
		assertEquals("12345",Jeff.getZip());
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
