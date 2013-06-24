package kus.eventy;

import java.util.Calendar;
//Fasada dla javovej klasy Calendar
//Traci sens wraz z java 1.8
public class CalendarSet {
	Calendar c;

	public CalendarSet(Calendar c) {
		super();
		this.c = c;
	}
	public void setAllHour(int hour,int min,int sec, int millis){
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, min);
		c.set(Calendar.SECOND, sec);
		c.set(Calendar.MILLISECOND, millis);
	}
	
	
	public Calendar getC() {
		return c;
	}
	public void setC(Calendar c) {
		this.c = c;
	}
}
