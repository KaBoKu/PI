package kus.eventy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Boloczek
 * Date: 31.05.13
 * Time: 14:06
 * To change this template use File | Settings | File Templates.
 */
public class EventHolder {
    public List<Event> eventList = new ArrayList<Event>();
    public void add(Event e){
        eventList.add(e);
    }
    public Event getEvent(int id){
    	for(Event e : eventList){
    		if(e.id == id) return e;
    	}
    	return null;
    }
}
