
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * A TIXCLOCK that tells the time using the 24 hr time scale. This clock
 * Displays the time in a fun interesting way. The time is split into 6 parts or
 * slots. The first slot is the first part of the hour, and the second slot is
 * the second part of the hour. The third is the first part of the minute, and
 * the fourth is the second part of the minute. Same goes for the fifth and
 * sixth slots which display the seconds. A color will light up in a slot and
 * based on the number of colors that are displayed you read the time off my
 * counting the colors in each slot. For example if the time is 12:30:15 in the
 * afternoon the clock would display a single color in the first slot, two
 * colors in the second slot, three in the third, none in the fourth, one in the
 * fifth, and five in the sixth
 *
 * @author BrandonRossi
 * @version 1.2 Display is simply a JFrame that Displays the clock on the
 * screen. it sets up the frame
 */
public class Display extends JFrame
{
    //ClockDisplay clock_Display;

    JFrame frame;
    int width;
    int height;
    JLabel clock_Label;
    int widthX;
    int heightY;

    /**
     * Constructs a new Display with a label a width and a height
     *
     * @param label the label containing the clock display icon
     * @param width the width of the frame
     * @param height the height of the frame
     */
    public Display(JLabel label, int width, int height)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        widthX = (int)screenSize.getWidth();
        heightY = (int)screenSize.getHeight();
        this.width = width;
        this.height = height;

        //clock_Display = clock_Display;
        clock_Label = label;

        frame = new JFrame();
        frame.add(label);
        frame.setBackground(Color.BLACK);
        frame.setBounds(widthX - width - 5, heightY - height - 5, width, height);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);

        frame.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                widthX = e.getX();
                heightY = e.getY();
            }
        });
        frame.addMouseMotionListener(new MouseAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent evt)
            {
                //sets frame position when mouse dragged
                frame.setLocation(evt.getXOnScreen() - widthX, evt.getYOnScreen() - heightY);
            }
        });
    }
}
