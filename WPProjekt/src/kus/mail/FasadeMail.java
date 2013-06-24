package kus.mail;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * Created with IntelliJ IDEA.
 * User: Boloczek
 * Date: 30.05.13
 * Time: 23:31
 * To change this template use File | Settings | File Templates.
 */
public class FasadeMail {
    private Mail m = new Mail();

    public void sendMail(String tresc, String temat, String doKogo ){
        try {
            m.send(tresc,  temat,  "Terminarz", doKogo);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
