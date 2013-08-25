package bowling;

import java.util.*;

import frame.*;

public class BowlingGame {
	private static final int NORMAL_FRAME_NUM = 9;
	List<Frame> frames = new ArrayList<Frame>();
	int frameCount = 0;
	
	public void init() {
		for (int i = 0; i < NORMAL_FRAME_NUM; i++) {
			frames.add(new NormalFrame());
		}
		frames.add(new LastFrame());
	}

	public void hit(int hittedPin) {
		Frame hittedFrame = getFrame(frameCount);
		hittedFrame.hit(hittedPin);
		if (hittedFrame.isFinished()) {
			frameCount++;
		}
	}

	public Frame getFrame(int frameCount) {
		return frames.get(frameCount);
	}

	public int getFrameScore(int frameCount) {
		int frameScore = 0;
		for (int i = 0; i <= frameCount; i++) {
			frameScore += getFrame(i).getScore();
			frameScore += getBonusScore(getFrame(i), i);
		}
		
		return frameScore;
	}

	private int getBonusScore(Frame frame, int frameCount) {
		int bonusScore = 0;
		Frame nextFrame = getFrame(frameCount+1);
		Frame afterNextFrame = getFrame(frameCount+2);
		
		if (frame.isStrike()) {
			bonusScore += nextFrame.getScore();
			if (nextFrame.isStrike()) {
				bonusScore += afterNextFrame.getFirstScore(); 
			}
		}
			
		if (frame.isSpare()) {
			bonusScore += nextFrame.getFirstScore();
		}
			
		return bonusScore;
	}
}
