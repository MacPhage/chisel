package net.austinj.chisel.builder;

/**
 * Created by AustinJ on 12/30/2014.
 */
public class Timer
{
    private long startTime;
    private long endTime;

    public Timer()
    {
        //Do nothing
    }

    public Timer(boolean startNow)
    {
        if(startNow)
        {
            startTime = System.nanoTime();
        }
    }

    public void startTimer()
    {
        startTime =  System.nanoTime();
    }
    public void stopTimer()
    {
        endTime = System.nanoTime();
    }
    public double getTimerDuration() //Get's the duration of the timer in seconds
    {
        return (((endTime - startTime)/1000000)/1000);
    }
}
