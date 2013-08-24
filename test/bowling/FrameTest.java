package bowling;

import junit.framework.TestCase;

public class FrameTest extends TestCase {
	public void testStrike() throws Exception {
		Frame frame = new Frame();
		frame.hit(10);
		assertEquals(10, frame.getScore());
		System.out.println(frame.getSymbol());
		assertEquals("X", frame.getSymbol());
	}
	
	public void testSpare() throws Exception {
		Frame frame = new Frame();
		frame.hit(5);
		frame.hit(5);
		assertEquals(10, frame.getScore());
		assertEquals("5|/", frame.getSymbol());
	}
	
	public void testGutter() throws Exception {
		Frame frame = new Frame();
		frame.hit(0);
		frame.hit(0);
		assertEquals(0, frame.getScore());
		assertEquals("-|-", frame.getSymbol());
	}
	
	public void testScore() throws Exception {
		Frame frame = new Frame();
		frame.hit(1);
		frame.hit(2);
		assertEquals(3, frame.getScore());
		assertEquals("1|2", frame.getSymbol());
	}
	
	public void testNotHitted() throws Exception {
		Frame frame = new Frame();
		assertEquals(0, frame.getScore());
		assertEquals(".", frame.getSymbol());
	}
}
