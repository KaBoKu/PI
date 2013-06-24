package kus.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import kus.eventy.CalendarSet;
import kus.eventy.Event;
import kus.eventy.owner.Owner;
import kus.eventy.strategy.StrategyMail;
import kus.eventy.strategy.StrategySound;
import kus.jcalendar.Kalendar;
import kus.mail.FasadeMail;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Kalendar d = new Kalendar();
		//d.setPreferredSize(new Dimension(100,100));
		d.setSize(200, 200);
		d.setVisible(true);
		
		Event e = new Event();
		Calendar c = Calendar.getInstance();
		CalendarSet cS = new CalendarSet(c);
		cS.setAllHour(14, 22, 30, 0);
		Calendar c1 = cS.getC();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss (Z)");
		e.setStart(new Date(c1.getTimeInMillis()));
		System.out.println(df.format(c.getTime()));
		System.out.println(df.format(new Date())+" "+c1.toString());
		cS.setAllHour(15, 10, 11, 0);
		System.out.println(df.format(c.getTime()));
		e.setEnd(new Date(c.getTimeInMillis()));
		System.out.println("============================");
		System.out.println(df.format(e.getStart().getTime()));
		System.out.println(df.format(e.getEnd().getTime()));
		e.setGone(false);
		System.out.println(e.isEvent());
		//System.out.println(e.getStart().after(new Date()));
		
		cS.setAllHour(13,0,0,0);
		e.setStart(new Date(cS.getC().getTimeInMillis()));
		System.out.println("============");
		System.out.println(df.format(e.getStart().getTime())+" "+df.format(e.getEnd().getTime()));
		System.out.println("Jest event czy nie: "+e.isEvent());
		System.out.println(e.diff());
		FasadeMail fM = new FasadeMail();
		//fM.sendMail("asa", "nie ma", "kk.up.krk@gmail.com");
		Owner owner = Owner.INSTANCE;
		owner.setEmail("kk.up.krk@gmail.com");
		StrategySound sS = new StrategySound();
		StrategyMail sM = new StrategyMail(sS);
		e.setsT(sM);
		e.setAbout("Bla bla bla");
		e.setTitle("Coœ a coœ");
		e.makeAlarm();
		StrategyMail sMa = new StrategyMail();
		//sMa.Alert("kk.up.krk@gmail.com", "asa", "nie ma");
	}

}
