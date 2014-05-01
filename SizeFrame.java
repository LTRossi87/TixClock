
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
 /**
  * This class has not been implemented yet, This will be used to set the
  * size of the frame. When the user starts the program they will be prompted
  * with the size they want the clock to be when they select the size the clock
  * will open with that size.
  */

/**
 *
 * @author BrandonRossi
 */
public class SizeFrame extends JFrame
{
    //the size of the frame on the screen
    private static final int SMALL = 50;
    private static final int MEDIUM = 100;
    private static final int LARGE = 150;
    private int size;
    private final JFrame sizeFrame;
    private final JButton size1;
    private final JButton size2;
    private final JButton size3;
    private boolean selected;

    public SizeFrame()
    {
        this.selected = false;
        sizeFrame = new JFrame();
        size1 = new JButton("Small");
        size2 = new JButton("Medium");
        size3 = new JButton("Large");

        size1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                JButton temp = (JButton)e.getSource();
                String name = temp.getText();
                setSize(SMALL);
                selected = true;
                sizeFrame.dispose();

            }
        });

        size2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                JButton temp = (JButton)e.getSource();
                String name = temp.getText();
                setSize(MEDIUM);
                selected = true;
                sizeFrame.dispose();


            }
        });

        size3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                JButton temp = (JButton)e.getSource();
                String name = temp.getText();
                setSize(LARGE);
                selected = true;
                sizeFrame.dispose();

            }
        });

        sizeFrame.setTitle("How Big");
        sizeFrame.setLayout(new GridLayout(1, 3));
        sizeFrame.add(size1);
        sizeFrame.add(size2);
        sizeFrame.add(size3);
        sizeFrame.pack();
        sizeFrame.setVisible(true);
        sizeFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public boolean getSelected()
    {
        return selected;
    }
    public void setSize(int size)
    {
        this.size = size;
    }

    public int getSiz()
    {
        return this.size;
    }
}
