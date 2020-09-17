import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTest {

	@Test
	public void test() {
		CSVReaderTest test = new CSVReaderTest();
		int output = test.add(3,4);
		assertEquals(7, output);
		
	}

}
