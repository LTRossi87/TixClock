import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BrandonRossi
 */
public class TixClock
{
    private static final int DELAY = 1000;
    private static final int CLOCK_WIDTH = 300;//900;//600; //780
    private static final int CLOCK_HEIGHT = 138;//312;//208;//270;
    public static void main(String args[])
    {


        final Clock clock = new Clock();
        final ClockDisplay clock_Display = new ClockDisplay(CLOCK_WIDTH, CLOCK_HEIGHT);
        ClockIcon icon = new ClockIcon(clock_Display, CLOCK_WIDTH, CLOCK_HEIGHT);
        final JLabel label = new JLabel(icon);
        Display display = new Display(label, CLOCK_WIDTH, CLOCK_HEIGHT);


        Timer time = new Timer(DELAY, new ActionListener()
        {
            int count = 0;
            int change = 0;
            @Override
            public void actionPerformed(ActionEvent ae)
            {

                count++;
                change++;
                if(count % 5 == 0)
                {
                    clock.updateTime();
                    clock_Display.fillClocks(clock);
                    //System.out.println(clock.getHour1() + " " + clock.getHour2() + " " + clock.getMinute1() + " " + clock.getMinute2());
                    label.repaint();
                    count = 0;
                }
                if(change == 30)
                {
                    clock_Display.updateColor();
                    change = 0;
                    label.repaint();
                }
            }
        });
        time.start();
    }
}
