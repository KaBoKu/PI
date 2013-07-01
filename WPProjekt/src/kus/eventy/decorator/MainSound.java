package kus.eventy.decorator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.audio.AudioPlayer;

public class MainSound {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainSound mS = new MainSound();
		mS.sound();
	}

	public  void sound(){
		 InputStream in;
	 		try {
	 			
	 			InputStream is= getClass().getResourceAsStream("Alarm.wav");
	 			System.out.println(is.toString());
	 			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(is);
	 			//in = new FileInputStream(new File("D:\\Alarm\\Alarm.wav"));
	 			//AudioStream as = new AudioStream(in);
	 			AudioPlayer.player.start(audioInputStream);  
	 		} catch (FileNotFoundException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 		// Create an AudioStream object from the input stream.
	  catch (IOException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
