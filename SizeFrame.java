
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BrandonRossi
 */
public class SizeFrame extends JFrame
{
    private static final int SMALL = 50;
    private static final int MEDIUM = 100;
    private static final int LARGE = 150;
    private int size;
    final JFrame sizeFrame;
    JButton size1;
    JButton size2;
    JButton size3;
    boolean selected = false;
    public SizeFrame()
    {
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
