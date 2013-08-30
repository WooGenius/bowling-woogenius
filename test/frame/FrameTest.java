package frame;

import java.util.*;

import junit.framework.TestCase;

public class FrameTest extends TestCase {
	public void testFrame() throws Exception {
		List<Integer> rolls = new ArrayList<>();
		rolls.add(10);
		Frame frame = new Frame(1, rolls);
		assertEquals("X", frame.getSymbol());
		assertTrue(frame.isFinished());
		assertTrue(frame.isValid());
	}
	
	public void testFrame2() throws Exception {
		List<Integer> rolls = new ArrayList<>();
		rolls.add(5);
		rolls.add(5);
		Frame frame = new Frame(1, rolls);
		assertEquals("5|/", frame.getSymbol());
		assertTrue(frame.isFinished());
		assertTrue(frame.isValid());
	}
	
	public void testFrame3() throws Exception {
		List<Integer> rolls = new ArrayList<>();
		rolls.add(5);
		rolls.add(5);
		rolls.add(5);
		Frame frame = new Frame(10, rolls);
		assertEquals("5|/|5", frame.getSymbol());
		assertTrue(frame.isValid());
		assertTrue(frame.isFinished());
	}
	
	public void testFrame4() throws Exception {
		List<Integer> rolls = new ArrayList<>();
		rolls.add(5);
		rolls.add(5);
		Frame frame = new Frame(10, rolls);
		assertEquals("5|/", frame.getSymbol());
		assertFalse(frame.isFinished());
		assertTrue(frame.isValid());
	}
	
	public void testFrame5() throws Exception {
		List<Integer> rolls = new ArrayList<>();
		rolls.add(10);
		rolls.add(10);
		rolls.add(10);
		Frame frame = new Frame(10, rolls);
		assertEquals("X|X|X", frame.getSymbol());
		assertTrue(frame.isFinished());
		assertTrue(frame.isValid());
	}
}
