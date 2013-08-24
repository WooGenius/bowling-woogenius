package bowling;

import junit.framework.TestCase;

public class RollTest extends TestCase {
	public void testStrike() throws Exception {
		Roll roll1st = new Roll(true, 10);
		roll1st.hit(10);
		assertEquals('X', roll1st.getSymbol());
	}
	
	public void testSpare() throws Exception {
		Roll roll2nd = new Roll(false, 5);
		roll2nd.hit(5);
		assertEquals('/', roll2nd.getSymbol());
	}
	
	public void testGutter() throws Exception {
		Roll roll3rd = new Roll(false, 5);
		roll3rd.hit(0);
		assertEquals('-', roll3rd.getSymbol());
	}
	
	public void testScore() throws Exception {
		Roll roll4th = new Roll(true, 10);
		roll4th.hit(5);
		assertEquals('5', roll4th.getSymbol());
	}
	
	public void testNotHitted() throws Exception {
		Roll roll5th = new Roll(true, 10);
		assertEquals('.', roll5th.getSymbol());
	}
}
