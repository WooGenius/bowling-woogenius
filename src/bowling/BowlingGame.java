package bowling;

import java.util.*;

public class BowlingGame {
	final int TOTAL_FRAME_NUM = 10;
	List<Frame> frames = new ArrayList<Frame>();
	
	public void init() {
		for (int i = 0; i < TOTAL_FRAME_NUM; i++) {
		}
	}
	
	public int size() {
		return frames.size();
	}

}
