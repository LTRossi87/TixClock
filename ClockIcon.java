
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BrandonRossi
 */
public class ClockIcon implements Icon
{
    private int width;
    private int height;
    ClockDisplay clock_Display;
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
