package kus.eventy.Countdown;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import kus.eventy.CalendarSet;
import kus.eventy.Event;
import kus.eventy.owner.Owner;
import kus.eventy.strategy.StrategyMail;
import kus.eventy.strategy.StrategySound;

/**
 * Created with IntelliJ IDEA. User: Boloczek Date: 31.05.13 Time: 18:00 To
 * change this template use File | Settings | File Templates.
 */
public class DateCountdown {
	Date today1 = new Date();
	Date start = new Date();
	Date today = new Date();
	Date endCount;
	Timer timer;
	Event eV;

	public DateCountdown() {
		this.today1 = new Date();
		this.start = new Date();
		this.start.setTime(today.getTime() + 30000);
		timer = new Timer();
		timer.schedule(new DCountdownTask(), 0, 1 * 1000);
	}

	public DateCountdown(Event eV) {
		this.today1 = new Date();
		this.start = eV.getStart();
		// this.start.setTime(today.getTime()+30000);
		this.eV = eV;
		timer = new Timer();
		timer.schedule(new DCountdownTask(), 0, 1 * 1000);
	}

	public DateCountdown(Date dt) {
		this.today1 = new Date();
		this.start = dt;

	}

	public void run() {
		timer = new Timer();
		timer.schedule(new DCountdownTask(), 0, 1 * 1000);
	}

	// TODO Auto-generated method stub

	class DCountdownTask extends TimerTask {
		public void run() {
			today1 = new Date();
			long date = start.getTime() - 
					today1.getTime();
			System.out.println(start.getTime());
			System.out.println(today1.getTime());
			
			System.out.println();
			if (date <= 0) {
				System.out.println("Countdown FINISHED!!!!");
				//super.eV.makeAlarm();
				eV.makeAlarm();
				timer.cancel();
			} else {
				long day = date / (24 * 3600 * 1000);
				long hour = (date % (24 * 3600 * 1000)) / (3600 * 1000);
				long minutes = ((date % (24 * 3600 * 1000)) % (3600 * 1000) / (60 * 1000));
				long sec = ((date % (24 * 3600 * 1000)) % (3600 * 1000) % (60 * 1000)) / (1000);
				System.out.println("Days: " + day + " Hours: " + hour
						+ " Minutes: " + minutes + " Seconds: " + sec
						+ " => REMAINING");
			}
		}

	}

	public static void main(String... args) {
		// DateCountdown dC = new DateCountdown();
		Owner owner = Owner.INSTANCE;
		owner.setEmail("kk.up.krk@gmail.com");
		DateCountdown dC;// = new DateCountdown(new Date()); //dC.run();
		Event e = new Event();
		Calendar c = Calendar.getInstance();
		CalendarSet cS = new CalendarSet(c);
		cS.setAllHour(13, 6, 30, 0);
		Calendar c1 = cS.getC();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss (Z)");
		e.setStart(new Date(c1.getTimeInMillis()));
		System.out.println(df.format(c.getTime()));
		System.out.println(df.format(new Date()) + " " + c1.toString());
		cS.setAllHour(15, 10, 11, 0);
		System.out.println(df.format(c.getTime()));
		e.setEnd(new Date(c.getTimeInMillis()));
		
		StrategySound sS = new StrategySound();
		StrategyMail sM = new StrategyMail(sS);
		e.setsT(sM);
		e.setAbout("Bla bla bla");
		e.setTitle("Coœ a coœ");
		//e.makeAlarm();

		// e.getStart();
		// dC = new DateCountdown(e);
		// dC.run();
		 EventsHolder eH = new EventsHolder();
		 eH.add(e);
	
		 Event e1 = new Event();
			
			cS.setAllHour(13, 10, 30, 0);
			c1 = cS.getC();
			
			e1.setStart(new Date(c1.getTimeInMillis()));
			
			cS.setAllHour(15, 10, 11, 0);
			
			e1.setEnd(new Date(c.getTimeInMillis()));
			
			
			e1.setsT(sM);
			e1.setAbout("Tu jest about");
			e1.setTitle("nie ma nic");
		 eH.add(e1);
	}
}