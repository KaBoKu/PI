package kus.eventy.decorator;

import kus.mail.FasadeMail;

/**
 * Created with IntelliJ IDEA.
 * User: Boloczek
 * Date: 30.05.13
 * Time: 23:58
 * To change this template use File | Settings | File Templates.
 */
public class MailAlert extends AlertDecorator {
   // private Alert al;
    private FasadeMail fM = new FasadeMail();
    private String text="";
    private String toWho="";
    private String topic="";
    public  MailAlert(){

    }
    public  MailAlert(Alert al){
        this.decorate(al);
    }

    public MailAlert(Alert al,String text,String toWho,String topic){
        this.decorate(al);
        this.text = text;
        this.topic = topic;
        this.toWho = toWho;
    }
    @Override
    public void decorate(Alert al) {
        //To change body of implemented methods use File | Settings | File Templates.
        super.al=al;
    }

    @Override
    public void alert() {
        //To change body of implemented methods use File | Settings | File Templates.
        System.out.println("ala");
        fM.sendMail(text,topic,toWho);
        if(al!=null)al.alert();
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
