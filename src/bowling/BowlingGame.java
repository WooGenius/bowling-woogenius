package bowling;

import java.util.*;

import roll.*;

public class BowlingGame {
	private static final int TOTAL_FRAME_NUM = 10;
	Map<Integer, List<Rollable>> bowlingGame = new HashMap<Integer, List<Rollable>>();
	int frameCount = 1;
	
	public BowlingGame() {
		for (int frameOrder = 1; frameOrder <= TOTAL_FRAME_NUM; frameOrder++) {
			bowlingGame.put(frameOrder, makeRollList());
		}
	}

	private List<Rollable> makeRollList() {
		List<Rollable> rolls = new ArrayList<Rollable>();
		rolls.add(new FirstRoll());
		return rolls;
	}

	public int size() {
		return bowlingGame.size();
	}

	public void hit(int hittedPin) {
		List<Rollable> currentFrame = bowlingGame.get(frameCount);
		if (frameCount != 10) {
			hitNormalFrame(hittedPin, currentFrame);
		} else {
			hitLastFrame(hittedPin, currentFrame);
		}
	}

	private void hitNormalFrame(int hittedPin, List<Rollable> currentFrame) {
		FirstRoll firstRoll = (FirstRoll) currentFrame.get(0);
		if (!firstRoll.isHitted()) {	// if firstRoll is not hitted
			firstRoll.hit(hittedPin);
		} else if(firstRoll.isStrike()) {	// if firstRoll is strike
			frameCount++;
			hit(hittedPin);
		} else {
			int restPin = firstRoll.getRestPin();
			currentFrame.add(new SecondRoll(restPin));
			currentFrame.get(1).hit(hittedPin);
			frameCount ++;
		}
	}
	
	int lastFrameCount = 0;
	private void hitLastFrame(int hittedPin, List<Rollable> currentFrame) {
		Rollable currentRoll = currentFrame.get(lastFrameCount);
		if (!currentRoll.isHitted()) {	// if currentRoll is not hitted
			currentRoll.hit(hittedPin);
		} else if(currentRoll.isStrike()) {	// if currentRoll is strike
			currentFrame.add(new FirstRoll());
			hitNextRoll(hittedPin, currentFrame);
		} else if(currentRoll.isSpare()) {
			currentFrame.add(new FirstRoll());
			hitNextRoll(hittedPin, currentFrame);
		} else {
			int restPin = currentRoll.getRestPin();
			currentFrame.add(new SecondRoll(restPin));
			hitNextRoll(hittedPin, currentFrame);
		}
	}

	private void hitNextRoll(int hittedPin, List<Rollable> currentFrame) {
		Rollable nextRoll = currentFrame.get(++lastFrameCount);
		nextRoll.hit(hittedPin);
	}

	@Override
	public String toString() {
		return "BowlingGame [bowlingGame=" + bowlingGame + "]";
	}
}
