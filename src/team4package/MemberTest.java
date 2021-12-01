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

	@Test
	public void testGetZipForSuccess() {
		assertEquals("35408", member.getZip());
	}
	
	@Test
	public void testGetZipForFailure() {
		assertNotEquals("00000", member.getZip());
	}

	@Test
	public void testGetIDForSuccess() {
		assertEquals(2, member.getID());
	}

	@Test
	public void testGetIDForFailure() {
		assertNotEquals(0, member.getID());
	}
}
