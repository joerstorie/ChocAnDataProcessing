// Trent Boughner - Test Case 2
package team4package;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProviderReportTest {
	ProviderReport pr;
	
	@Before
	public void setUp() throws Exception {
		pr = new ProviderReport();
	}
	// Tests to see if report create and written
	@Test
	public void test() {
		pr.saveReport();
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
