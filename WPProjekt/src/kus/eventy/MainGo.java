package kus.eventy;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Boloczek
 * Date: 31.05.13
 * Time: 00:17
 * To change this template use File | Settings | File Templates.
 */
public class MainGo {
    public static void main(String ... args){
          //            MailAlert a = new MailAlert();
           //             MailAlert aa = new MailAlert(new MailAlert(new SoundAlert()));
        //SoundAlert sA = new SoundAlert(aa);
        //sA.alert();
        Calendar c = Calendar.getInstance();
        CalendarSet cS = new CalendarSet(c);
        cS.setAllHour(20,30,0,0);
          System.out.println(c.toString());
        Event e = new Event(cS.getC().getTime(),cS.getC().getTime());
       //e.
    }
}
