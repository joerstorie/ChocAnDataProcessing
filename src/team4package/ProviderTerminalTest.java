// Riley Parker
package team4package;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class ProviderTerminalTest {

	ProviderTerminal pt;
	
	
	@Before
	public void initialize() throws IOException {
		ProviderTerminal pt = new ProviderTerminal();
	}
	
	
	@Test
	public void converterTest() {
		try {
			assertEquals("2012-07-23", pt.convertDate("07-23-2012"));
		} catch (NullPointerException ne) {
			System.out.println(ne);
		}
		
	}

}
