package team4package;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagerMemberTest {
	Member Jeff;

	@BeforeEach
	void setUp() throws Exception {
		Jeff = new Member(567231, "Jeff Dunham", "1831 Fake Rd", "Tuscaloosa", "Alabama", "12345");
	}
	
	@Test
	void testID() {
		assertEquals(567231,Jeff.getID());
	}

	@Test
	void testName() {
		assertEquals("Jeff Dunham",Jeff.getName());
	}
	
	@Test
	void testStreetAddress() {
		assertEquals("1831 Fake Rd",Jeff.getAddress());
	}
	
	@Test
	void testCity() {
		assertEquals("Tuscaloosa",Jeff.getCity());
	}
	
	@Test
	void testState() {
		assertEquals("Alabama",Jeff.getState());
	}
	
	@Test
	void testZip() {
		assertEquals("12345",Jeff.getZip());
	}

}
