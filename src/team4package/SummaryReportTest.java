//Jake Silvey -- Test Case 3
package fall2021team4.src.team4package;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SummaryReportTest {
	SummaryReport sr;

	@Before
	public void setUp() throws Exception {
		sr = new SummaryReport();
	}
	//Tests to see if a report is created and written
	@Test
	public void test() throws Exception{
		sr.saveReport();
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
