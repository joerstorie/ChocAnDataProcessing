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
	public void test() {
		mr.saveReport();
	}
	
	@After
	public void tearDown() throws Exception {
		
	}

}
