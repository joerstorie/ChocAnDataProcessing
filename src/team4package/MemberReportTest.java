// Trent Boughner - Test Case 3
package team4package;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MemberReportTest {
	MemberReport mr;
	
	@Before
	public void setUp() throws Exception {
		mr = new MemberReport();
	}

	@Test
	// Tests to see if report create and written
	public void test() {
		mr.saveReport();
	}
	
	@After
	public void tearDown() throws Exception {
		
	}

}
