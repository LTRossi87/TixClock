
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/*
 * Clock Face
 * h1   h2    m1    m2    s1    s2
 * [] [][][] [][] [][][] [][] [][][]
 * [] [][][] [][] [][][] [][] [][][]
 * [] [][][] [][] [][][] [][] [][][]
 */

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
 * Clock Display is the logic behind the clock. This class determines how and where colors are displayed on the screen
 * This class also handles the drawing of the clock
 */
public class ClockDisplay
{
    final int titlePadding = 20;
    //Colors for the clock
    private final int squareWidth;
    private final int squareHeight;
    private final int startX;
    private final int startY;
    private final int space;
    private final int spaceBetSlot;

    private final int width;
    private final int height;


    private final Color background;
    private Color cSlot1;
    private Color cSlot2;
    private Color cSlot3;
    private Color cSlot4;
    private final Color cSlot5;
    private final Color cSlot6;
    private final int sizeSlot1;
    private final int sizeSlot2;
    private final int sizeSlot3;
    private final int sizeSlot4;
    private final int sizeSlot5;
    private final int sizeSlot6;

    /* Slot 1 demensions
     * []   IN ARRAY FORM IT LOOKS LIKE [][][]
     * []
     * []
     */
    private final Color[] slot1;

    /* Slot 2 demensions
     * [][][]
     * [][][]
     * [][][]
     */
    private final Color[][] slot2;

    /* Slot 3 demensions
     * [][]
     * [][]
     * [][]
     */
    private final Color[][] slot3;

    /* Slot 4 demensions
     * [][][]
     * [][][]
     * [][][]
     */
    private final Color[][] slot4;

    /* Slot 5 demensions
     * [][]
     * [][]
     * [][]
     */
    private final Color[][] slot5;

    /* Slot 6 demensions
     * [][][]
     * [][][]
     * [][][]
     */
    private final Color[][] slot6;

    /**
     * Creates a new ClockDisplay with the width and height of the frame
     * @param height the height of the frame
     */
    public ClockDisplay(int height)
    {
        this.background = Color.DARK_GRAY;
        this.cSlot1 = Color.RED;
        this.cSlot2 = Color.GREEN;
        this.cSlot3 = Color.RED;
        this.cSlot4 = Color.GREEN;
        this.cSlot5 = Color.LIGHT_GRAY;
        this.cSlot6 = cSlot5;
        this.sizeSlot1 = 3;
        this.sizeSlot2 = 10;
        this.sizeSlot3 = 6;
        this.sizeSlot4 = sizeSlot2;
        this.sizeSlot5 = sizeSlot3;
        this.sizeSlot6 = sizeSlot2;

        //The 6 data structures that will hold the time
        slot1 = new Color[3];    // hour 1
        slot2 = new Color[3][3]; // hour 2
        slot3 = new Color[2][3]; // minute 1
        slot4 = new Color[3][3]; // minute 2
        slot5 = new Color[2][3]; // second 1
        slot6 = new Color[3][3]; // second 2


        this.height = height;

        //Calculates the width of the square based on the height of the frame accounting for the title bar
        squareWidth = ((height))/5;
        //Height of the square is the same as the width
        squareHeight = squareWidth;
        //Starting X position on the frame
        startX = squareWidth;
        //Starting Y position on the frame
        startY = startX;
        //Space between the squares
        space = (squareWidth/5);
        //Space between the different time slots
        spaceBetSlot = squareWidth + space;
        //Fills the all the squares in the slots to gray
        fillClocksInit(background);
        fillClockSecondsInit(background);

        this.width = (startX * 2) + (squareWidth * 14) + (spaceBetSlot * 5) + (space * 8);

        /*
         * This displays the title message of TIX
         * [ ] [*][*][*] [ ][*] [*][ ][*]
         * [ ] [ ][*][ ] [ ][*] [ ][*][ ]
         * [ ] [ ][*][ ] [ ][*] [*][ ][*]
         */
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

    public int getWidth()
    {
        return this.width;
    }

    /**
     * Draws the Rectangles on the frame
     * @param g2 the Graphics context
     */
    public void draw(Graphics2D g2)
    {
        //Set Background color to black
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, width, height);
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
                g2.fillRect(startX + squareWidth + spaceBetSlot + ((squareWidth + space) * i), startY + (j * (space + squareHeight)), squareWidth, squareHeight);
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

        //Slot5
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                g2.setColor(slot5[i][j]);
                //x, y, width, height

                g2.fillRect(startX  + (squareWidth * 9) + (spaceBetSlot * 4) + (space * 4) + ((squareWidth+ space) * i), startY + (j * (space + squareHeight)), squareWidth, squareHeight);
                //g2.fillOval(startX  + (squareWidth * 4) + (spaceBetSlot * 2) + (space * 2) + ((squareWidth+ space) * i), startY + (j * (space + squareHeight)), squareWidth, squareHeight);
            }
        }

        //Slot6
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                g2.setColor(slot6[i][j]);
                //x, y, width, height
                g2.fillRect(startX + (squareWidth * 11) + (spaceBetSlot * 5) + (space * 5) + ((squareWidth+ space) * i), startY + (j * (space + squareHeight)), squareWidth, squareHeight);
                //g2.fillOval(startX + (squareWidth * 6) + (spaceBetSlot * 3) + (space * 3) + ((squareWidth+ space) * i), startY + (j * (space + squareHeight)), squareWidth, squareHeight);
            }
        }

    }

    /**
     * Fills the Slots with the colors to tell the time in 24 hr clock
     * This method fills the hour and minute slots only
     * @param clock the Clock object used to get the time
     */
    public void fillClocks(Clock clock)
    {
        //Clears the background before redrawing
        fillClocksInit(background);
        //Gets the current time split into hour and minutes
        int hour1 = clock.getHour1();
        int hour2 = clock.getHour2();
        int minute1 = clock.getMinute1();
        int minute2 = clock.getMinute2();

        //Fills all slots
        fillColor1X3(slot1, sizeSlot1, cSlot1, hour1);
        fillColor3X3(slot2, sizeSlot2, cSlot2, hour2);
        fillColor2X3(slot3, sizeSlot3, cSlot3, minute1);
        fillColor3X3(slot4, sizeSlot4, cSlot4, minute2);
    }

    /**
     * Fills the Slots with the colors to tell the time in 24 hr clock
     * This method fills the second slots only
     * @param clock the Clock object used to get the time
     */
    public void fillSeconds(Clock clock)
    {
        fillClockSecondsInit(background);
        int second1 = clock.getSeconds1();
        int second2 = clock.getSeconds2();

        //Fills slot5 and slot6 with the colors
        fillColor2X3(slot5, sizeSlot5, cSlot5, second1);
        fillColor3X3(slot6, sizeSlot6, cSlot6, second2);
    }

    /**
     * Fills all the slots to a gray color
     * This method does hour and minutes only
     * @param color the color to fill the slots with
     */
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

    /**
     * Fills all the slots to a gray color
     * This method does seconds only
     * @param color the color to fill the slots with
     */
    private void fillClockSecondsInit(Color color)
    {
        //i should be going along the x-axis
        for (int i = 0; i < 3; i++)
        {
            //j should be going along the y-axix
            for (int j = 0; j < 3; j++)
            {
                slot6[i][j] = color;
                if (i < 2)
                {
                    slot5[i][j] = color;
                }
            }
        }
    }

    /**
     * This updates the color that is displayed on the frame, every X number of seconds
     * as defined in the main class the color will change.
     */
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

    //START OF FILL SLOTS
    /**
     * A method that fils the slots with the appropriate color
     * This does a 1X3 slot. Randomly calculates the index of the slot that is to be filled
     * @param slots the slot that is to be filled
     * @param sizeOfSlot the size of the slot
     * @param col the color to fill
     * @param length the length of time
     */
     private void fillColor1X3(Color[] slots, int sizeOfSlot, Color col, int length)
    {
        Random rand = new Random();
        //Fills slot1 with the colors
        for (int i = 0; i < length; i++)
        {
            int temp = rand.nextInt(sizeOfSlot);
            /*
             *
             * If the color of the slot is not equal to the background color then
             * then keep selecting another slot. otherwise change the color of the
             * slot
            */
            while (slots[temp] != background)
            {
                temp = rand.nextInt(sizeOfSlot);
            }
            slots[temp] = col;
        }
    }

     /**
     * A method that fils the slots with the appropriate color
     * This does a 3X3 slot. Switch cases are sued to determine what index of the
     * slot to fill with the color. This index is generated randomly based on the size of the
     * slot that is being filled
     * @param slots the slot that is to be filled
     * @param sizeOfSlot the size of the slot
     * @param col the color to fill
     * @param length the length of time
     */
    private void fillColor3X3(Color[][] slots, int sizeOfSlot, Color col, int length)
    {
        Random rand = new Random();
        for (int i = 0; i < length; i++)
        {
            int temp = rand.nextInt(sizeOfSlot);
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
            while (slots[tempX][tempY] != background)
            {
                temp = rand.nextInt(sizeOfSlot);
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
            slots[tempX][tempY] = col;
        }
    }

     /**
     * A method that fils the slots with the appropriate color
     * This does a 2X3 slot. Switch cases are sued to determine what index of the
     * slot to fill with the color. This index is generated randomly based on the size of the
     * slot that is being filled
     * @param slots the slot that is to be filled
     * @param sizeOfSlot the size of the slot
     * @param col the color to fill
     * @param length the length of time
     */
    private void fillColor2X3(Color[][] slots, int sizeOfSlot, Color col, int length)
    {
        Random rand = new Random();
        for (int i = 0; i < length; i++)
        {
            int temp = rand.nextInt(sizeOfSlot);
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
            while (slots[tempX][tempY] != background)
            {
                temp = rand.nextInt(sizeOfSlot);
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
            slots[tempX][tempY] = col;
        }
    }
    //END OF FILL SLOTS

    /**
     * Gets slot 1
     * @return returns slot 1
     */
    public Color[] getSlot1()
    {
        return slot1;
    }

    /**
     * Gets slot 2
     * @return returns slot 2
     */
    public Color[][] getSlot2()
    {
        return slot2;
    }

    /**
     * Gets slot 3
     * @return returns slot 3
     */
    public Color[][] getSlot3()
    {
        return slot3;
    }

    /**
     * Gets slot 4
     * @return returns slot 4
     */
    public Color[][] getSlot4()
    {
        return slot4;
    }

    /**
     * Gets slot 5
     * @return returns slot 5
     */
    public Color[][] getSlot5()
    {
        return slot5;
    }

    /**
     * Gets slot 6
     * @return returns slot 6
     */
    public Color[][] getSlot6()
    {
        return slot6;
    }
}