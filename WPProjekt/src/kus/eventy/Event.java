package kus.eventy;

import java.util.Date;

import kus.eventy.Countdown.DateCountdown;
import kus.eventy.owner.Owner;
import kus.eventy.strategy.StrategyAlarm;
//Klasa Event jest klasa zawierajaca dane na temat eventu
public class Event {
	private static final int MILLIS_PER_DAY = 86400000;
	private StrategyAlarm sT;
    Date start;
	Date end;
	boolean emailWaring;
	boolean soundWaring;
	private String title;
	String where;
	String about;
	boolean isGone;
    public int id;
    private DateCountdown dC;
    private EventState eS;

	public Event() {
		super();
	}

	public Event(Date start, Date end) {
		super();
		this.start = start;
		this.end = end;
		if (this.isEvent())this.seteS(new StateAfter(this));
		else this.seteS(new StateBefore(this));
        dC = new DateCountdown(start);
        dC.run();
	}

	public Event(Date start, Date end, boolean emailWaring,
			boolean soundWaring, String where, String about, boolean isGone) {
		super();
		this.start = start;
		this.end = end;
		this.emailWaring = emailWaring;
		this.soundWaring = soundWaring;
		this.where = where;
		this.about = about;
		this.isGone = isGone;
        dC = new DateCountdown(start);
        dC.run();

	}
	
	public void makeAlarm(){
		Owner owner = Owner.INSTANCE;
		//sT.Alert(owner.getEmail(), this.title, this.about);
		eS.sendAlarm();
	}
	
	public boolean isEvent() {
		if (isGone)
			return false;
		if (start.after(new Date())){
			System.out.println("1");return false;}
		if(start.before(new Date()))return true;
		if (start.before(new Date()) 
				&& end.after(new Date()))
			return true;
		return true;
	}

	public int diff() {
		int daysDiff = (int) ((start.getTime() - new Date().getTime()));// / MILLIS_PER_DAY);
		return daysDiff;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
		if (this.isEvent())
			this.seteS(new StateAfter(this));
		else this.seteS(new StateBefore(this));
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public boolean isEmailWaring() {
		return emailWaring;
	}

	public void setEmailWaring(boolean emailWaring) {
		this.emailWaring = emailWaring;
	}

	public boolean isSoundWaring() {
		return soundWaring;
	}

	public void setSoundWaring(boolean soundWaring) {
		this.soundWaring = soundWaring;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public boolean isGone() {
		return isGone;
	}

	public void setGone(boolean isGone) {
		this.isGone = isGone;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public StrategyAlarm getsT() {
		return sT;
	}

	public void setsT(StrategyAlarm sT) {
		this.sT = sT;
	}

	public EventState geteS() {
		return eS;
	}

	public void seteS(EventState eS) {
		this.eS = eS;
	}

}
