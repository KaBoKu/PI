/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kus.mail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.util.MailSSLSocketFactory;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author Boloczek
 */
public class Mail {

    public void send(String tresc, String temat, String odKogo, String doKogo) throws UnsupportedEncodingException, GeneralSecurityException {

        final String username = "kk.up.krk@gmail.com";
        final String password = "2004wsp2004";

        InternetAddress[] tto = null;
        try {
            tto = InternetAddress.parse(doKogo);//("kk.up.krk@gmail.com, wse_kk@interia.pl,anmiks05@gmail.com");
        } catch (AddressException ex) {
            ex.printStackTrace();
        }

        Properties props = new Properties();
        //MailSSLSocketFactory sf = new MailSSLSocketFactory();
		//  sf.setTrustAllHosts(true);
		//  props.put("mail.smtp.ssl.socketFactory", sf);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        
        
        
       /* props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");*/
        
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            Date d = new Date();
            DateFormat df = new SimpleDateFormat("MMM dd,yyyy HH:mm");
            /*try {
                d = df.parse("wrz 09,2012 20:24");
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            String[] to = {"wse_kk@interia.pl", "kk.up.krk@gmail.com"};
            InternetAddress[] addressTo = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                addressTo[i] = new InternetAddress(to[i]);
            }*/
            message.setFrom(new InternetAddress(odKogo));
            //message.setRecipients(Message.RecipientType.TO,
            //        InternetAddress.parse(doKogo));

            message.setRecipients(Message.RecipientType.TO, tto);

            message.setSubject(temat);
            message.setText(tresc);
            message.setSentDate(d);


            //Address[] addresses = new 
            //File plikXml = new File("listy.xml");

           /* if (plikXml.exists()) {
                XML.dodajXML(odKogo, doKogo, temat, tresc);
            } else {
                XML.tworzXML();
            }*/
            //Transport transport = session.getTransport("smtps");
            Transport.send(message);
            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(String tresc, String temat, String odKogo, String doKogo, String user, String pass) {

        final String username = user;
        final String password = pass;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(odKogo));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(doKogo));
            message.setSubject(temat);
            message.setText(tresc);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(String tresc, String temat, String odKogo, String doKogo, String plik, String user, String pass) {

        final String username = user;
        final String password = pass;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(odKogo));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(doKogo));
            message.setSubject(temat);
            //message.setText(tresc);

            // Create the message part 
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setText("This is message body");

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "file.txt";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);


            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    public void send(String tresc, String temat, String odKogo, String doKogo, String plik) {

        final String username = "kk.up.krk@gmail.com";
        final String password = "2004wsp2004";


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(odKogo));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(doKogo));
            message.setSubject(temat);
            //message.setText(tresc);

            // Create the message part 
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setText("This is message body");

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "E:/file.txt";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            //messageBodyPart.setFileName(filename);
            messageBodyPart.setFileName("file.txt");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            messageBodyPart = new MimeBodyPart();
            filename = "E:/linki.txt";
            source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            //messageBodyPart.setFileName(filename);
            messageBodyPart.setFileName("linki.txt");
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);


            Transport.send(message);
            File plikXml = new File("listy.xml");
            if (plikXml.exists()) {
                XML.dodajXML(odKogo, doKogo, temat, tresc);
            } else {
                XML.tworzXML();
            }


            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
*/
    public void send(String tresc, String temat, String odKogo, String doKogo, String doKogoCarbon, File[] plik) {

        final String username = "kk.up.krk@gmail.com";
        final String password = "2004wsp2004";

        int size = plik.length;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(odKogo));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(doKogo));
            message.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(doKogoCarbon));
            message.setSubject(temat);
            //message.setText(tresc);

            // Create the message part 
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setText(tresc);

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            for (int i = 0; i < size; ++i) {
                messageBodyPart = new MimeBodyPart();
                String filename = plik[i].toString();
                DataSource source = new FileDataSource(filename);
                messageBodyPart.setDataHandler(new DataHandler(source));
                //messageBodyPart.setFileName(filename);
                messageBodyPart.setFileName(filename);
                multipart.addBodyPart(messageBodyPart);
                message.setContent(multipart);
            }
            /*
            messageBodyPart = new MimeBodyPart();
            filename = "E:/linki.txt";
            source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            //messageBodyPart.setFileName(filename);
            messageBodyPart.setFileName("linki.txt");
            multipart.addBodyPart(messageBodyPart);
             */
            // Send the complete message parts
            message.setContent(multipart);


            Transport.send(message);
            //ZapisKorespondencji zk = new ZapisKorespondencji();
            //ZapisKorespondencji.zapis(tresc, temat, odKogo, doKogo, plik);
            //zk.zapis(tresc, temat, odKogo, doKogo, plik);


            File plikXml = new File("listy.xml");
           /* if (plikXml.exists()) {
                XML.dodajXML(odKogo, doKogo, temat, tresc);
            } else {
                XML.tworzXML(odKogo, doKogo, temat, tresc);
            }
             */


            System.out.println("Done pliki[]");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(String tresc, String temat, String odKogo, String doKogo, String doKogoCarbon) throws UnsupportedEncodingException {

        final String username = "kk.up.krk@gmail.com";
        final String password = "2004wsp2004";

        InternetAddress[] tto = null;
        try {
            tto = InternetAddress.parse(doKogo);//("kk.up.krk@gmail.com, wse_kk@interia.pl,anmiks05@gmail.com");
        } catch (AddressException ex) {
            ex.printStackTrace();
        }


        InternetAddress[] ttoc = null;
        try{
            ttoc = InternetAddress.parse(doKogoCarbon);
        }catch(AddressException ex){
            ex.printStackTrace();
        }

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            Date d = new Date();
            DateFormat df = new SimpleDateFormat("MMM dd,yyyy HH:mm");
            try {
                d = df.parse("wrz 09,2012 20:24");
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            String[] to = {"wse_kk@interia.pl", "kk.up.krk@gmail.com"};
            InternetAddress[] addressTo = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                addressTo[i] = new InternetAddress(to[i]);
            }
            message.setFrom(new InternetAddress("pojeb@org.pl"));
            //message.setRecipients(Message.RecipientType.TO,
            //        InternetAddress.parse(doKogo));

            message.setRecipients(Message.RecipientType.TO, tto);
            message.setRecipients(Message.RecipientType.CC,ttoc);
            message.setSubject(temat);
            message.setText(tresc);
            message.setSentDate(d);


            //Address[] addresses = new 
            File plikXml = new File("listy.xml");

           /* if (plikXml.exists()) {
                XML.dodajXML(odKogo, doKogo, temat, tresc);
            } else {
                XML.tworzXML();
            }  */
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }



    public String readMail(String user, String pass) throws Exception {

        StringBuilder sb = new StringBuilder();
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", "kk.up.krk@gmail.com", "2004wsp2004");

            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            Message[] message = folder.getMessages(folder.getMessageCount()-10, folder.getMessageCount());

            for(int i=0;i<message.length;++i){
                sb.append("Od Kogo: " + message[i].getFrom()[0] + "\n" +"Temat: "+ message[i].getSubject()+"\n" + "Data: " +message[i].getReceivedDate().toString() + "\n"
                        +message[i].getContent().toString()+"\n"
                );
            }

            folder.close(false);
            store.close();
        } /*catch (NoSuchProviderException e) {
            e.printStackTrace();
            System.exit(1);
        }*/ catch (MessagingException e) {
            e.printStackTrace();
            System.exit(2);
        }


        return sb.toString();
    }
}
/*
 *  // Create the message part 
BodyPart messageBodyPart = new MimeBodyPart();

// Fill the message
messageBodyPart.setText("This is message body");

// Create a multipar message
Multipart multipart = new MimeMultipart();

// Set text message part
multipart.addBodyPart(messageBodyPart);

// Part two is attachment
messageBodyPart = new MimeBodyPart();
String filename = "file.txt";
DataSource source = new FileDataSource(filename);
messageBodyPart.setDataHandler(new DataHandler(source));
messageBodyPart.setFileName(filename);
multipart.addBodyPart(messageBodyPart);

// Send the complete message parts
message.setContent(multipart );
 */
