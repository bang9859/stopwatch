package stopwatch;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeSystem implements Runnable {
	private boolean isRun = true;
	private int sec = 1;
	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.S");
	
	public int getSec() {
		return this.sec;
	}
	
	public void TimerSystem(int sec) {
		this.sec = sec;
	}
	
	@Override
	public void run() {
		while (isRun) {
			Calendar cal = Calendar.getInstance();
			String msg = sdf.format(cal.getTime());
			System.out.printf(msg +"[%d sec]",sec++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				isRun = false;
			}
		}
	}

}
