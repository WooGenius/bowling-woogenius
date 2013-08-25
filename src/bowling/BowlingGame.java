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
		
		if (lastFrameCount==2) {
			return;
		}
		
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

	public int getNextScore(int frameOrder, int rollOrder) {
		List<Rollable> currentFrame = bowlingGame.get(frameOrder);
		int nextScore = 0;
		if (currentFrame.size() >= rollOrder+1) {
			nextScore = currentFrame.get(rollOrder).getScore();
		} else {
			List<Rollable> nextFrame = bowlingGame.get(frameOrder+1);
			nextScore = nextFrame.get(0).getScore();
		}
		return nextScore;
	}

	public int getFrameScore(int frameOrder) {
		int frameScore = 0;
		List<Rollable> currentFrame = bowlingGame.get(frameOrder);
		for (int rollOrder = 1; rollOrder <= currentFrame.size(); rollOrder++) {
			Rollable currentRoll = currentFrame.get(rollOrder-1);
			frameScore += currentRoll.getScore();
			frameScore += getBonusScore(frameOrder, rollOrder);
		}
		return frameScore;
	}
	
	private int getBonusScore(int frameOrder, int rollOrder) {
		int bonusScore = 0;
		List<Rollable> currentFrame = bowlingGame.get(frameOrder);
		Rollable currentRoll = currentFrame.get(rollOrder-1);
		if (currentRoll.isSpare()) {
			bonusScore = getNextScore(frameOrder, rollOrder);
		} else if (currentRoll.isStrike()) {
			bonusScore = getNextScore(frameOrder, rollOrder);
			if (hasNextRoll(frameOrder, rollOrder)) {
				bonusScore = getNextScore(frameOrder, rollOrder+1);
			} else {
				bonusScore += getNextScore(frameOrder+1, 1);
			}
		}
		return bonusScore;
	}


	public boolean hasNextRoll(int frameOrder, int rollOrder) {
		List<Rollable> currentFrame = bowlingGame.get(frameOrder);
		if (currentFrame.size() >= rollOrder+1) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "BowlingGame [bowlingGame=" + bowlingGame + "]";
	}
}
