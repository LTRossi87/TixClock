
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;

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
 * Clock Icon is a class that converts the Clock Display to an object of type Icon
 * This is used to draw the clock on the screen
 */
public class ClockIcon implements Icon
{
    private int width;
    private int height;
    ClockDisplay clock_Display;
    /**
     * Constructs a new Clock Icon with a clock display a width and a height
     * @param clockDisp the clock display
     * @param width the width
     * @param height the height
     */
    public ClockIcon(ClockDisplay clockDisp, int width, int height)
    {
        clock_Display = clockDisp;
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintIcon(Component cmpnt, Graphics grphcs, int x, int y)
    {
        Graphics2D g2 = (Graphics2D) grphcs;
        clock_Display.draw(g2);
    }


    @Override
    public int getIconWidth()
    {
        return width;
    }

    @Override
    public int getIconHeight()
    {
        return height;
    }
}
