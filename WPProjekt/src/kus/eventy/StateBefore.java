package kus.eventy;

import kus.eventy.owner.Owner;

public class StateBefore implements EventState {
	Event eV;
	Owner own;
	
	public StateBefore(Event eV) {
		super();
		this.eV = eV;
		
	}

	@Override
	public void sendAlarm() {
		// TODO Auto-generated method stub
		//own.getEmail();
		own = Owner.INSTANCE;
		System.out.println("nuiohuiu "+own.getEmail());
		eV.getsT().Alert(own.getEmail(), eV.getTitle(), "Ju¿ nie d³ugo!");
	}

}
