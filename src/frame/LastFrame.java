package frame;

public class LastFrame extends Frame {

	@Override
	public void hit(int hittedPin) {
		if(isFirst) {
			Roll firstRoll = rolls.get(0);
			firstRoll.hit(hittedPin);
			restPin -= hittedPin;
			isFirst = false;
		} else {
			rolls.add(new Roll(isFirst, restPin));
			Roll secondRoll = rolls.get(1);
			secondRoll.hit(hittedPin);
		}
	}
}
