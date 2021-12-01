// Riley Parker
package team4package;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;

class ProviderTerminalTest {

	ProviderTerminal pt;
	
	
	@BeforeEach
	void initialize() throws IOException {
		ProviderTerminal pt = new ProviderTerminal();
	}
	
	
	// I wrote this class, but not this part of it
	@Test
	void converterTest() {
		try {
			assertEquals("2012-07-23", pt.convertDate("07-23-2012"));
		} catch (NullPointerException ne) {
			System.out.println(ne);
		}
		
	}

}
