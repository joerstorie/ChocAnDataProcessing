//Jake Silvey -- Test Case 2
package team4package;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EFTDataLogTest {
	EFTDataLog eft;

	@Before
	public void setUp() throws Exception {
		eft = new EFTDataLog();
	}
	//Testing to see if saveLog() creates and writes EFTDataLog
	@Test
	public void EFTSaveLogTest() throws Exception{
		eft.saveLog();
	}

	@After
	public void tearDown() throws Exception {
	}
}
