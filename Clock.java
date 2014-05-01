
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

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
 * Clock is the class that deals with the logic for breaking up the time into the
 * different parts.
 */
public class Clock
{
    private int hour;
    private int hour1;
    private int hour2;
    private int minute;
    private int minute1;
    private int minute2;
    private int second1;
    private int second2;

    /**
     * Constructs a new Clock object
     */
    public Clock()
    {
        hour = 0;
        hour1 = 0;
        hour2 = 0;
        minute = 0;
        minute1 = 0;
        minute2 = 0;
        second1 = 0;
        second2 = 0;
    }

    /**
     * Splits the time into four parts. Two hour parts and two minute parts
     * @param hour the current hour
     * @param minute the current minute
     */
    public void splitTime(int hour, int minute)
    {
       hour1 = hour / 10;
       hour2 = hour % 10;
       minute1 = minute / 10;
       minute2 = minute % 10;

    }
    /**
     * Splits the time into two parts. Two parts for the seconds
     * @param seconds
     */
    public void splitSeconds(int seconds)
    {
         second1 = seconds / 10;
         second2 = seconds % 10;
    }

    /**
     * Gets the first hour part
     * @return the first hour part
     */
    public int getHour1()
    {
        return hour1;
    }
    /**
     * Gets the second hour part
     * @return the second hour part
     */
    public int getHour2()
    {
        return hour2;
    }
    /**
     * Gets the first minute part
     * @return the first minute part
     */
    public int getMinute1()
    {
        return minute1;
    }
    /**
     * Gets the second minute part
     * @return the second minute part
     */
    public int getMinute2()
    {
        return minute2;
    }
    /**
     * Gets the first second part
     * @return the first second part
     */
    public int getSeconds1()
    {
        return second1;
    }
    /**
     * Gets the second second part
     * @return the second second part
     */
    public int getSeconds2()
    {
        return second2;
    }

    /**
     * UpdateTime is called every 5 seconds and displays the clock in a new order
     */
    public void updateTime()
    {
        Calendar currentTime = new GregorianCalendar(TimeZone.getDefault());
        splitTime(currentTime.get(Calendar.HOUR_OF_DAY), currentTime.get(Calendar.MINUTE));
        updateSeconds(currentTime);
    }
    /**
     * UpdateSeconds is called every second and displays the seconds in a new order
     * @param c A calendar object that holds the current time
     */
    public void updateSeconds(Calendar c)
    {
        Calendar currentTime = c;
        splitSeconds(currentTime.get(Calendar.SECOND));
    }
}
