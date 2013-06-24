package kus.eventy.strategy;

import kus.eventy.decorator.Alert;
import kus.eventy.decorator.MailAlert;

/**
 * Created with IntelliJ IDEA.
 * User: Boloczek
 * Date: 31.05.13
 * Time: 09:54
 * To change this template use File | Settings | File Templates.
 */
public class StrategyMail implements  StrategyAlarm {
    private MailAlert mA = new MailAlert();
    
    public StrategyMail(){
    	mA = new MailAlert();
    }
    
    public StrategyMail(Alert al){
    	mA = new MailAlert(al);
    }
    public StrategyMail(StrategyAlarm al){
    	mA = new MailAlert(al.getAlert());
    }
    @Override
    public void Alert(String toWho, String topic, String text) {
        //To change body of implemented methods use File | Settings | File Templates.
        mA.setText(text);
        mA.setTopic(topic);
        mA.setToWho(toWho);
        mA.alert();
    }

	@Override
	public kus.eventy.decorator.Alert getAlert() {
		// TODO Auto-generated method stub
		return mA;
	}
}
