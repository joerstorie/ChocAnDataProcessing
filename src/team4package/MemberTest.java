// Joseph Storie
package team4package;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MemberTest {

	Member member;
	
	@Before 
	public void setUp() throws Exception {
		member = new Member(2, "Trent Boughner", "420 Fake Address", "Tuscaloosa", "Alabama", "35408");
	}

	@Test // method written by Joseph
	public void testGetZipForSuccess() {
		assertEquals("35408", member.getZip());
	}
	
	@Test // method written by Joseph
	public void testGetZipForFailure() {
		assertNotEquals("00000", member.getZip());
	}

	@Test // method written by Sean
	public void testGetIDForSuccess() {
		assertEquals(2, member.getID());
	}

	@Test // method written by Sean
	public void testGetIDForFailure() {
		assertNotEquals(0, member.getID());
	}
}
