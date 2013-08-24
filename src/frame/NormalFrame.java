package frame;

public class NormalFrame extends Frame{

	@Override
	public void hit(int hittedPin) {
		if(isFirst) {
			Roll firstRoll = rolls.get(0);
			firstRoll.hit(hittedPin);
			restPin -= hittedPin;
			isFirst = false;
		} else {
			rolls.add(new Roll(isFirst, restPin));
			rolls.get(1).hit(hittedPin);
		}
	}
}
