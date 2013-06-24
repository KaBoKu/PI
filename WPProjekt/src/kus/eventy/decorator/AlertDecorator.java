package kus.eventy.decorator;

/**
 * Created with IntelliJ IDEA.
 * User: Boloczek
 * Date: 30.05.13
 * Time: 23:48
 * To change this template use File | Settings | File Templates.
 */
public abstract class AlertDecorator implements  Alert{
    protected Alert al;
    public abstract void  decorate(Alert al);
}
