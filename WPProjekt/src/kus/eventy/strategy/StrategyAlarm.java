package kus.eventy.strategy;

import kus.eventy.decorator.Alert;

/**
 * Created with IntelliJ IDEA.
 * User: Boloczek
 * Date: 31.05.13
 * Time: 09:34
 * To change this template use File | Settings | File Templates.
 */
public interface StrategyAlarm {
    void Alert(String toWho,String topic, String text);
    Alert getAlert();
}
