//Created by Sean Hurley
package team4package;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagerProviderTest {
	Provider Willem;

	@BeforeEach
	void setUp() throws Exception {
		Willem = new Provider(892156, "Willem Defoe", "1600 Pennsylvania Ave NW", "Washington", "Washington, DC", "20006");
	}
	
	@Test
	void testID() {
		assertEquals(892156,Willem.getID());
	}

	@Test
	void testName() {
		assertEquals("Willem Defoe",Willem.getName());
	}
	
	@Test
	void testStreetAddress() {
		assertEquals("1600 Pennsylvania Ave NW",Willem.getAddress());
	}
	
	@Test
	void testCity() {
		assertEquals("Washington",Willem.getCity());
	}
	
	@Test
	void testState() {
		assertEquals("Washington, DC",Willem.getState());
	}
	
	@Test
	void testZip() {
		assertEquals("20006",Willem.getZip());
	}

}
