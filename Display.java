
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
 * Display is simply a JFrame that Displays the clock on the screen. it sets up the frame
 */
public class Display extends JFrame
{
    //ClockDisplay clock_Display;
    JFrame frame;
    int width;
    int height;
    JLabel clock_Label;
    double widthX = 1430;
    double heightY = 990;
    /**
     * Constructs a new Display with a label a width and a height
     * @param label the label containing the clock display icon
     * @param width the width of the frame
     * @param height the height of the frame
     */
    public Display(JLabel label, int width, int height)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double widthX = screenSize.getWidth();
        double heightY = screenSize.getHeight();
        this.width = width;
        this.height = height;
        //clock_Display = clock_Display;
        clock_Label = label;

        frame = new JFrame();

        frame.add(label);
        frame.setBackground(Color.BLACK);
        frame.setBounds((int)widthX-width, (int)heightY-height, width, height);
        frame.setTitle("TixClock");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setAutoRequestFocus(true);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
    }









}
