package team4package;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProviderTerminalTest {

	ProviderTerminal pt;
	
	@BeforeEach
	void initialize() throws IOException{
		ProviderTerminal pt = new ProviderTerminal();
	}
	@Test
	void converterTest() {
		assertEquals("2012-07-23", pt.convertDate("07-23-2012"));
	}

}
