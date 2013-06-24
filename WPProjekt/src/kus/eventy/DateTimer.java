package kus.eventy;

/**
 * Created with IntelliJ IDEA.
 * User: Boloczek
 * Date: 31.05.13
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimer extends JFrame {

    private JFormattedTextField finishtime;
    private JLabel countLabel;

    /**
     * Launch the application
     *
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DateTimer frame = new DateTimer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame
     */
    public DateTimer() {
        super();
        setTitle("Allegro CountDown");
        getContentPane().setLayout(null);
        setBounds(100, 100, 500, 375);

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

        final JLabel finishtimeLabel = new JLabel();
        finishtimeLabel.setText("CountDown Time");
        finishtimeLabel.setBounds(10, 36, 119, 15);
        getContentPane().add(finishtimeLabel);
        finishtime = new JFormattedTextField(new DateFormatter(
                new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa", Locale.ENGLISH)));
        finishtime.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {

            }
        });

        finishtime.setValue(new Date());
        finishtime.setBounds(135, 34, 187, 19);
        getContentPane().add(finishtime);

        final JButton startButton = new JButton();
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                startCount();
            }
        });
        startButton.setText("Start!!!");
        startButton.setBounds(334, 31, 111, 25);
        getContentPane().add(startButton);

        countLabel = new JLabel();
        countLabel.setHorizontalAlignment( SwingConstants.CENTER);
        countLabel.setHorizontalTextPosition( SwingConstants.CENTER);
        countLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        countLabel.setBorder(new LineBorder(Color.black, 1, false));
        countLabel.setText("Countdown not Started");
        countLabel.setBounds(10, 162, 435, 47);
        getContentPane().add(countLabel);

        final JLabel credits = new JLabel();
        credits
                .setHorizontalAlignment( SwingConstants.RIGHT);
        credits.
                setText( "gianpiero.francesca@yahoo.it" );
        credits.setBounds(253, 328, 237, 15);
        getContentPane().add(credits);
    }

    protected void startCount() {
        Timer t = new javax.swing.Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Date today = new Date();
                Date endCount = (Date) finishtime.getValue();
// TODO Auto-generated method stub
                long date = endCount.getTime() - today.getTime();
                if (date <= 0) {

                    countLabel.setText("Countdown FINISHED!!!!");
                } else {
                    long day = date / (24 * 3600 * 1000);
                    long hour = (date % (24 * 3600 * 1000)) / (3600 * 1000);
                    long minutes = ((date % (24 * 3600 * 1000)) % (3600 * 1000) / (60 * 1000));
                    long sec = ((date % (24 * 3600 * 1000)) % (3600 * 1000) % (60 * 1000)) / (1000);
                    countLabel.setText("Days: " + day + " Hours: " + hour
                            + " Minutes: " + minutes + " Seconds: " + sec
                            + " => REMAINING");
                }

            }
        });
        t.start();
    }

}