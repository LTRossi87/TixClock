
import java.awt.Color;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BrandonRossi
 */
public class Display extends JFrame
{
    //ClockDisplay clock_Display;
    JFrame frame;
    int width;
    int height;
    JLabel clock_Label;
    public Display(JLabel label, int width, int height)
    {
        this.width = width;
        this.height = height;
        //clock_Display = clock_Display;
        clock_Label = label;
        frame = new JFrame();
        frame.setBackground(Color.BLACK);
        frame.add(label);






        frame.setTitle("Tix Clock");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
