package bowling;

import junit.framework.TestCase;

public class FrameTest extends TestCase {
	public void testStrike() throws Exception {
		NormalFrame frame = new NormalFrame();
		frame.hit(10);
		assertEquals(10, frame.getScore());
		assertEquals("X", frame.getSymbol());
	}
	
	public void testSpare() throws Exception {
		NormalFrame frame = new NormalFrame();
		frame.hit(5);
		frame.hit(5);
		assertEquals(10, frame.getScore());
		assertEquals("5|/", frame.getSymbol());
	}
	
	public void testGutter() throws Exception {
		NormalFrame frame = new NormalFrame();
		frame.hit(0);
		frame.hit(0);
		assertEquals(0, frame.getScore());
		assertEquals("-|-", frame.getSymbol());
	}
	
	public void testScore() throws Exception {
		NormalFrame frame = new NormalFrame();
		frame.hit(1);
		frame.hit(2);
		assertEquals(3, frame.getScore());
		assertEquals("1|2", frame.getSymbol());
	}
	
	public void testNotHitted() throws Exception {
		NormalFrame frame = new NormalFrame();
		assertEquals(0, frame.getScore());
		assertEquals(".", frame.getSymbol());
	}
	
	public void testIsLastFrame() throws Exception {
		LastFrame lastFrame = new LastFrame();
		lastFrame.hit(5);
		lastFrame.hit(3);
		assertEquals(8, lastFrame.getScore());
		assertEquals("5|3", lastFrame.getSymbol());
	}
}
