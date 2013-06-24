package kus.eventy;

import kus.eventy.owner.Owner;

public class StateAfter implements EventState {
	Event eV;
	Owner own;
	public StateAfter(Event eV) {
		super();
		this.eV = eV;
	}
	@Override
	public void sendAlarm() {
		// TODO Auto-generated method stub

	}

}
