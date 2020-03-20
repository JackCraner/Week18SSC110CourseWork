import java.util.TimerTask;
import javax.swing.JLabel;
/**
 * This is the class which is run each time the timer ticks
 */
public class TimerJob extends TimerTask
{
    private double timerCount = 0;
    JLabel lTimer;
    /**
     * when the timer ticks, run is ran
     * it add one to the counter
     * updates the label on the screen
     */
    public void run()
    {
        timerCount++;
        lTimer.setText("Time Elapsed: \n" + (timerCount / 10));
    }
    /**
     * this function adds the JLabel from board used to show the time
     * to the class so that we can adjust its text within this class
     * @param timerLabel  the label from board
     */
    public void getObjects(JLabel timerLabel)
    {
        lTimer = timerLabel;
    }
    /**
     * 
     * @return the current time
     * we divide it by 10 as we counting in 10x faster than a second to allow for one decimal poitn of accuracy
     */
    public double getTime()
    {
        return (timerCount/10);
    }

}