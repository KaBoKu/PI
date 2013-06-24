package kus.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Mail m = new Mail();
		try {			
			m.send("fewfew", "lol", "kk.up.krk@gmail.com", "kk.up.krk@gmail.com");
			//m.send("efe", "fefw", "fewfew.few", "kk.up.krk@gmail.com", "dw");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	             

	     // Use the static class member "player" from class AudioPlayer to play
	     // clip.
	     
	}

}
