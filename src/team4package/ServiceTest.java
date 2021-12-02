package team4package;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.Before;

public class ServiceTest {

	Service myStitches;

	@Before
	public void setUp() throws Exception {
		myStitches = new Service(1, 3, 1, 2, LocalDate.parse("2006-03-12"), LocalDateTime.parse("2017-01-13T17:09:42.411"));
		myStitches.addComments("Testing comments!");
	}
	
	@Test
	public void testProviderID() {
		assertEquals(1, myStitches.getProviderID());
	}

	@Test
	public void testServiceID() {
		assertEquals(1, myStitches.getServiceIDX());
	}
	
	@Test
	public void testComments() {
		assertEquals("Testing comments!", myStitches.getComments());
	}

}
