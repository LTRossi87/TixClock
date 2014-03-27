
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/*
 * Clock Face
 * [] [][][] [][] [][][]
 * [] [][][] [][] [][][]
 * [] [][][] [][] [][][]
 */
/**
 *
 * @author BrandonRossi
 */
public class ClockDisplay
{
    final int titlePadding = 20;
    //Colors for the clock
    int squareWidth;
    int squareHeight;
    int startX;
    int startY;
    int space;
    int spaceBetSlot;

    final Color background = Color.DARK_GRAY;
    Color cSlot1 = Color.RED;
    Color cSlot2 = Color.GREEN;
    Color cSlot3 = Color.RED;
    Color cSlot4 = Color.GREEN;
    final int sizeSlot1 = 3;
    final int sizeSlot2 = 10;
    final int sizeSlot3 = 6;
    final int sizeSlot4 = sizeSlot2;

    /* Slot 1 demensions
     * []   IN ARRAY FORM IT LOOKS LIKE [][][]
     * []
     * []
     */
    Color[] slot1;

    /* Slot 2 demensions
     * [][][]
     * [][][]
     * [][][]
     */
    Color[][] slot2;

    /* Slot 3 demensions
     * [][]
     * [][]
     * [][]
     */
    Color[][] slot3;

    /* Slot 4 demensions
     * [][][]
     * [][][]
     * [][][]
     */
    Color[][] slot4;

    public ClockDisplay(int width, int height)
    {
        slot1 = new Color[3];
        slot2 = new Color[3][3];
        slot3 = new Color[2][3];
        slot4 = new Color[3][3];

        squareWidth = ((height-20)-titlePadding)/5;
        squareHeight = squareWidth;
        startX = squareWidth + 1;
        startY = startX;
        space = (squareWidth/5);
        spaceBetSlot = squareWidth + space;
        fillClocksInit(background);

        slot2[0][0] = cSlot2;
        slot2[1][0] = cSlot2;
        slot2[2][0] = cSlot2;
        slot2[1][1] = cSlot2;
        slot2[1][2] = cSlot2;

        slot3[0][0] = cSlot3;
        slot3[0][1] = cSlot3;
        slot3[0][2] = cSlot3;

        slot4[0][0] = cSlot4;
        slot4[1][1] = cSlot4;
        slot4[2][2] = cSlot4;
        slot4[0][2] = cSlot4;
        slot4[2][0] = cSlot4;


    }

    public void updateColor()
    {

        if(cSlot1 == Color.RED && cSlot2 == Color.GREEN && cSlot3 == Color.RED && cSlot4 == Color.GREEN)
        {
            cSlot1 = Color.ORANGE;
             cSlot2 = Color.MAGENTA;
            cSlot3 = Color.ORANGE;
            cSlot4 = Color.MAGENTA;
        }
        else if(cSlot1 == Color.GREEN && cSlot2 == Color.RED && cSlot3 == Color.GREEN && cSlot4 == Color.RED)
        {
            cSlot1 = Color.MAGENTA;
            cSlot2 = Color.ORANGE;
            cSlot3 = Color.MAGENTA;
            cSlot4 = Color.ORANGE;
        }
        else if(cSlot1 == Color.ORANGE && cSlot2 == Color.MAGENTA && cSlot3 == Color.ORANGE && cSlot4 == Color.MAGENTA)
        {
            cSlot1 = Color.GREEN;
            cSlot2 = Color.RED;
            cSlot3 = Color.GREEN;
            cSlot4 = Color.RED;
        }
        else
        {
            cSlot1 = Color.RED;
            cSlot2 = Color.GREEN;
            cSlot3 = Color.RED;
            cSlot4 = Color.GREEN;
        }


    }

    public void draw(Graphics2D g2)
    {

        //int spacingX = (squareWidth + space);
        //int spacingY = (squareHeight + space);
        //Slot1
        for (int i = 0; i < 3; i++)
        {
            g2.setColor(slot1[i]);
            //x, y, width, height
            g2.fillRect(startX, startY + (i * (space + squareHeight)), squareWidth, squareHeight);
            //g2.fillOval(startX, startY + (i * (space + squareHeight)), squareWidth, squareHeight);
        }

        //Slot2
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                g2.setColor(slot2[i][j]);
                //x, y, width, height
                g2.fillRect(startX + squareWidth + spaceBetSlot + ((squareWidth+ space) * i), startY + (j * (space + squareHeight)), squareWidth, squareHeight);
                //g2.fillOval(startX + squareWidth + spaceBetSlot + ((squareWidth+ space) * i), startY + (j * (space + squareHeight)), squareWidth, squareHeight);
            }
        }

        //Slot3
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                g2.setColor(slot3[i][j]);
                //x, y, width, height

                g2.fillRect(startX  + (squareWidth * 4) + (spaceBetSlot * 2) + (space * 2) + ((squareWidth+ space) * i), startY + (j * (space + squareHeight)), squareWidth, squareHeight);
                //g2.fillOval(startX  + (squareWidth * 4) + (spaceBetSlot * 2) + (space * 2) + ((squareWidth+ space) * i), startY + (j * (space + squareHeight)), squareWidth, squareHeight);
            }
        }

        //Slot4
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                g2.setColor(slot4[i][j]);
                //x, y, width, height
                g2.fillRect(startX + (squareWidth * 6) + (spaceBetSlot * 3) + (space * 3) + ((squareWidth+ space) * i), startY + (j * (space + squareHeight)), squareWidth, squareHeight);
                //g2.fillOval(startX + (squareWidth * 6) + (spaceBetSlot * 3) + (space * 3) + ((squareWidth+ space) * i), startY + (j * (space + squareHeight)), squareWidth, squareHeight);
            }
        }
    }

    public void fillClocks(Clock clock)
    {
        fillClocksInit(background);
        int hour1 = clock.getHour1();
        int hour2 = clock.getHour2();
        int minute1 = clock.getMinute1();
        int minute2 = clock.getMinute2();

        Random rand = new Random();

        //Fills slot1 with the colors
        for (int i = 0; i < hour1; i++)
        {
            int temp = rand.nextInt(sizeSlot1);
            while (slot1[temp] != background)
            {
                temp = rand.nextInt(sizeSlot1);
            }
            slot1[temp] = cSlot1;

        }

        //Fills slot2 with the colors
        for (int i = 0; i < hour2; i++)
        {

            int temp = rand.nextInt(sizeSlot2);
            int tempX = 0;
            int tempY = 0;
            switch (temp)
            {
                case 0:
                    tempX = 0;
                    tempY = 0;
                    break;
                case 1:
                    tempX = 0;
                    tempY = 1;
                    break;
                case 2:
                    tempX = 0;
                    tempY = 2;
                    break;
                case 3:
                    tempX = 1;
                    tempY = 0;
                    break;
                case 4:
                    tempX = 1;
                    tempY = 1;
                    break;
                case 5:
                    tempX = 1;
                    tempY = 2;
                    break;
                case 6:
                    tempX = 2;
                    tempY = 0;
                    break;
                case 7:
                    tempX = 2;
                    tempY = 1;
                    break;
                case 8:
                    tempX = 2;
                    tempY = 2;
                    break;
            }
            while (slot2[tempX][tempY] != background)
            {
                temp = rand.nextInt(sizeSlot2);
                switch (temp)
                {
                    case 0:
                        tempX = 0;
                        tempY = 0;
                        break;
                    case 1:
                        tempX = 0;
                        tempY = 1;
                        break;
                    case 2:
                        tempX = 0;
                        tempY = 2;
                        break;
                    case 3:
                        tempX = 1;
                        tempY = 0;
                        break;
                    case 4:
                        tempX = 1;
                        tempY = 1;
                        break;
                    case 5:
                        tempX = 1;
                        tempY = 2;
                        break;
                    case 6:
                        tempX = 2;
                        tempY = 0;
                        break;
                    case 7:
                        tempX = 2;
                        tempY = 1;
                        break;
                    case 8:
                        tempX = 2;
                        tempY = 2;
                        break;
                }
            }
            slot2[tempX][tempY] = cSlot2;
        }

        //Fills slot3 with the colors
        for (int i = 0; i < minute1; i++)
        {
            int temp = rand.nextInt(sizeSlot3);
            int tempX = 0;
            int tempY = 0;
            switch (temp)
            {
                case 0:
                    tempX = 0;
                    tempY = 0;
                    break;
                case 1:
                    tempX = 0;
                    tempY = 1;
                    break;
                case 2:
                    tempX = 0;
                    tempY = 2;
                    break;
                case 3:
                    tempX = 1;
                    tempY = 0;
                    break;
                case 4:
                    tempX = 1;
                    tempY = 1;
                    break;
                case 5:
                    tempX = 1;
                    tempY = 2;
                    break;
            }
            while (slot3[tempX][tempY] != background)
            {
                temp = rand.nextInt(sizeSlot3);
                switch (temp)
                {
                    case 0:
                        tempX = 0;
                        tempY = 0;
                        break;
                    case 1:
                        tempX = 0;
                        tempY = 1;
                        break;
                    case 2:
                        tempX = 0;
                        tempY = 2;
                        break;
                    case 3:
                        tempX = 1;
                        tempY = 0;
                        break;
                    case 4:
                        tempX = 1;
                        tempY = 1;
                        break;
                    case 5:
                        tempX = 1;
                        tempY = 2;
                        break;
                }
            }
            slot3[tempX][tempY] = cSlot3;

        }

        //Fills slot4 with the colors
        for (int i = 0; i < minute2; i++)
        {
            int temp = rand.nextInt(sizeSlot4);
            int tempX = 0;
            int tempY = 0;
            switch (temp)
            {
                case 0:
                    tempX = 0;
                    tempY = 0;
                    break;
                case 1:
                    tempX = 0;
                    tempY = 1;
                    break;
                case 2:
                    tempX = 0;
                    tempY = 2;
                    break;
                case 3:
                    tempX = 1;
                    tempY = 0;
                    break;
                case 4:
                    tempX = 1;
                    tempY = 1;
                    break;
                case 5:
                    tempX = 1;
                    tempY = 2;
                    break;
                case 6:
                    tempX = 2;
                    tempY = 0;
                    break;
                case 7:
                    tempX = 2;
                    tempY = 1;
                    break;
                case 8:
                    tempX = 2;
                    tempY = 2;
                    break;
            }
            while (slot4[tempX][tempY] != background)
            {
                temp = rand.nextInt(sizeSlot4);
                switch (temp)
                {
                    case 0:
                        tempX = 0;
                        tempY = 0;
                        break;
                    case 1:
                        tempX = 0;
                        tempY = 1;
                        break;
                    case 2:
                        tempX = 0;
                        tempY = 2;
                        break;
                    case 3:
                        tempX = 1;
                        tempY = 0;
                        break;
                    case 4:
                        tempX = 1;
                        tempY = 1;
                        break;
                    case 5:
                        tempX = 1;
                        tempY = 2;
                        break;
                    case 6:
                        tempX = 2;
                        tempY = 0;
                        break;
                    case 7:
                        tempX = 2;
                        tempY = 1;
                        break;
                    case 8:
                        tempX = 2;
                        tempY = 2;
                        break;
                }
            }
            slot4[tempX][tempY] = cSlot4;

        }
    }

    private void fillClocksInit(Color color)
    {
        //i should be going along the x-axis
        for (int i = 0; i < 3; i++)
        {
            slot1[i] = color;
            //j should be going along the y-axix
            for (int j = 0; j < 3; j++)
            {
                slot2[i][j] = color;
                slot4[i][j] = color;
                if (i < 2)
                {
                    slot3[i][j] = color;
                }
            }
        }
    }

    public Color[] getSlot1()
    {
        return slot1;
    }

    public Color[][] getSlot2()
    {
        return slot2;
    }

    public Color[][] getSlot3()
    {
        return slot3;
    }

    public Color[][] getSlot4()
    {
        return slot4;
    }
}
