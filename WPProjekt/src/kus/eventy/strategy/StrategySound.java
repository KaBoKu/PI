package kus.eventy.strategy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import kus.eventy.decorator.Alert;
import kus.eventy.decorator.SoundAlert;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Created with IntelliJ IDEA.
 * User: Boloczek
 * Date: 31.05.13
 * Time: 09:56
 * To change this template use File | Settings | File Templates.
 */
public class StrategySound implements StrategyAlarm {
    private SoundAlert sA = new SoundAlert();
    
    public StrategySound(){
    	sA = new SoundAlert();
    }
    
    public StrategySound(Alert al){
    	sA = new SoundAlert(al);
    }
    @Override
    public void Alert(String toWho, String topic, String text) {
        //To change body of implemented methods use File | Settings | File Templates.
        sA.alert();     
    }

	@Override
	public kus.eventy.decorator.Alert getAlert() {
		// TODO Auto-generated method stub
		return sA;
	}
}
