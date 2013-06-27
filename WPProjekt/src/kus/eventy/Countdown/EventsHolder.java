package kus.eventy.Countdown;

import java.util.ArrayList;
import java.util.List;

import kus.eventy.Event;

public class EventsHolder {
	DateCountdown dC;
	List<Event> eHolder = new ArrayList<>();
	public void add(Event e){
		eHolder.add(e);
		dC = new DateCountdown(e);
		//dC.run();
		eHolder.size();
	}
	
	public int size(){
		return eHolder.size();
	}
	
	public Event getByIndex(int index){
		return eHolder.get(index);
	}
	
}
