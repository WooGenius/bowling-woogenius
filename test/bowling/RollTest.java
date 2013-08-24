package bowling;

import junit.framework.TestCase;

public class RollTest extends TestCase {
	public void testStrike() throws Exception {
		Roll roll1st = new Roll(true, 10);
		roll1st.hit(10);
		assertEquals('X', roll1st.getSymbol());
	}
	
}
