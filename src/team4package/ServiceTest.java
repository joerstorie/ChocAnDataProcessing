package team4package;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServiceTest {

	Service myStitches;

	@BeforeEach
	void setUp() throws Exception {
		myStitches = new Service(1, 3, 1, 2, LocalDate.parse("2006-03-12"), LocalDateTime.parse("2017-01-13T17:09:42.411"));
		myStitches.addComments("Testing comments!");
	}
	
	@Test
	void testProviderID() {
		assertEquals(1, myStitches.getProviderID());
	}

	@Test
	void testServiceID() {
		assertEquals(1, myStitches.getServiceIDX());
	}
	
	@Test
	void testComments() {
		assertEquals("Testing comments!", myStitches.getComments());
	}

}
