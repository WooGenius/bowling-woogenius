package bowling;

import junit.framework.TestCase;

public class FrameTest extends TestCase {
	public void testCreate() throws Exception {
		Frame frame1st = new Frame();
		frame1st.pitch(9);
		assertEquals(9, frame1st.getScore());
	}
}
