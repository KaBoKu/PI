package kus.eventy.decorator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Created with IntelliJ IDEA.
 * User: Boloczek
 * Date: 31.05.13
 * Time: 08:12
 * To change this template use File | Settings | File Templates.
 */
public class SoundAlert extends AlertDecorator {

    public  SoundAlert(){

    }

    public  SoundAlert(Alert al){
        this.decorate(al);
    }
    @Override
    public void decorate(Alert al) {
        //To change body of implemented methods use File | Settings | File Templates.
        super.al=al;
    }

    @Override
    public void alert() {
        //To change body of implemented methods use File | Settings | File Templates.
        System.out.println("Sound");
        InputStream in;
    		try {
    			in = new FileInputStream(new File("D:\\Alarm\\Alarm.wav"));
    			AudioStream as = new AudioStream(in);
    			AudioPlayer.player.start(as);  
    		} catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		// Create an AudioStream object from the input stream.
     catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        if(al!=null)al.alert();
    }
}
