
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BrandonRossi
 */
public class Clock
{

    int hour;
    int hour1;
    int hour2;
    int minute;
    int minute1;
    int minute2;

    public Clock()
    {
        hour = 0;
        hour1 = 0;
        hour2 = 0;
        minute = 0;
        minute1 = 0;
        minute2 = 0;
    }

    public void splitTime(int hour, int minute)
    {
       hour1 = hour / 10;
       hour2 = hour % 10;
       minute1 = minute / 10;
       minute2 = minute % 10;
    }

    public int getHour1()
    {
        return hour1;
    }
    public int getHour2()
    {
        return hour2;
    }
    public int getMinute1()
    {
        return minute1;
    }
    public int getMinute2()
    {
        return minute2;
    }
    public void updateTime()
    {
        Calendar currentTime = new GregorianCalendar(TimeZone.getDefault());
        splitTime(currentTime.get(Calendar.HOUR_OF_DAY), currentTime.get(Calendar.MINUTE));
    }

}
