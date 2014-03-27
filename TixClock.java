import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * A TIXCLOCK that tells the time using the 24 hr time scale. This clock
 * Displays the time in a fun interesting way. The time is split into 6 parts or slots.
 * The first slot is the first part of the hour, and the second slot is the second part of the hour.
 * The third is the first part of the minute, and the fourth is the second part of the minute.
 * Same goes for the fifth and sixth slots which display the seconds. A color will light up in a slot and based on the
 * number of colors that are displayed you read the time off my counting the colors in each slot.
 * For example if the time is 12:30:15 in the afternoon the clock would display
 * a single color in the first slot, two colors in the second slot, three in the third, none in the fourth, one in the fifth, and five in the sixth
 * @author BrandonRossi
 * @version 1.2
 * Main Class that starts the program, and sets up all parts for the clock to run and display
 */
public class TixClock
{
    //Time of 1 second
    private static final int DELAY = 1000;
    private static final int UPDATE = 5;
    private static final int CHANGE_COLOR = 30;
    //Size of the frame 3.75 ratio
    private static final int CLOCK_WIDTH = 375; //750
    private static final int CLOCK_HEIGHT = 120; //200

    public static void main(String args[])
    {


        final Clock clock = new Clock();
        final ClockDisplay clock_Display = new ClockDisplay(CLOCK_WIDTH, CLOCK_HEIGHT);
        ClockIcon icon = new ClockIcon(clock_Display, CLOCK_WIDTH, CLOCK_HEIGHT);
        final JLabel label = new JLabel(icon);
        Display display = new Display(label, CLOCK_WIDTH, CLOCK_HEIGHT);

        /*
         *A Timmer object that deals with counting time on 1 second intervals
         *every 5 seconds the clock is redrawn in a different way
         *and every 30 seconds the color of the clock changes
         */
        Timer time = new Timer(DELAY, new ActionListener()
        {
            //Count to keep track of how often the clock is to be redrawn
            int count = 0;
            //Coint to keep track of how often the clock is to be recolored
            int change = 0;

            @Override
            public void actionPerformed(ActionEvent ae)
            {
                count++;
                change++;
                //Updates the seconds of the clock
                clock.updateSeconds(new GregorianCalendar(TimeZone.getDefault()));
                clock_Display.fillSeconds(clock);

                //Every UPDATE seconds the clock will redisplay itself in a different order
                if(count % UPDATE == 0)
                {
                    clock.updateTime();
                    clock_Display.fillClocks(clock);
                    //System.out.println(clock.getHour1() + " " + clock.getHour2() + " " + clock.getMinute1() + " " + clock.getMinute2());
                    count = 0;
                }
                //Ever CHANGE_COLOR seconds the clock will redisplay itself with different colors
                if(change == CHANGE_COLOR)
                {
                    clock_Display.updateColor();
                    change = 0;
                }
                label.repaint();
            }
        });
        time.start();
    }
}
