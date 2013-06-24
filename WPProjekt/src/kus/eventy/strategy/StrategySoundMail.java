package kus.eventy.strategy;

import kus.eventy.decorator.MailAlert;
import kus.eventy.decorator.SoundAlert;
import kus.eventy.owner.Owner;

/**
 * Created with IntelliJ IDEA. User: Boloczek Date: 31.05.13 Time: 10:01 To
 * change this template use File | Settings | File Templates.
 */
public class StrategySoundMail implements StrategyAlarm {
	private SoundAlert sA;

	@Override
	public void Alert(String toWho, String topic, String text) {
		// To change body of implemented methods use File | Settings | File
		// Templates.

		sA = new SoundAlert(new MailAlert(null, text, toWho, topic));
	}

	@Override
	public kus.eventy.decorator.Alert getAlert() {
		// TODO Auto-generated method stub
		return sA;
	}
}
