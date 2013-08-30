package frame;

import junit.framework.TestCase;

public class FrameTest extends TestCase {
	public void testHit() throws Exception {
		Frame frame = new Frame(1);
		frame.hit(10);
		assertEquals("X", frame.getSymbol());
		assertTrue(frame.isFinished());
		assertTrue(frame.isValid());
	}
	
	public void testHit2() throws Exception {
		Frame frame = new Frame(1);
		frame.hit(5);
		frame.hit(5);
		assertEquals("5|/", frame.getSymbol());
		assertTrue(frame.isFinished());
		assertTrue(frame.isValid());
	}
	
	public void testHit3() throws Exception {
		Frame frame = new Frame(10);
		frame.hit(5);
		frame.hit(5);
		frame.hit(5);
		assertEquals("5|/|5", frame.getSymbol());
		assertTrue(frame.isValid());
		assertTrue(frame.isFinished());
	}
	
	public void testHit4() throws Exception {
		Frame frame = new Frame(10);
		frame.hit(5);
		frame.hit(5);
		assertEquals("5|/", frame.getSymbol());
		assertFalse(frame.isFinished());
		assertTrue(frame.isValid());
	}
	
	public void testHit5() throws Exception {
		Frame frame = new Frame(10);
		frame.hit(10);
		frame.hit(10);
		frame.hit(10);
		assertEquals("X|X|X", frame.getSymbol());
		assertTrue(frame.isFinished());
		assertTrue(frame.isValid());
	}
}
