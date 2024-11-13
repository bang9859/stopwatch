package stopwatch;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeSystem implements Runnable {
	private boolean isRun = true;
	private int sec = 1;
	boolean isHold = false;
	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	InputSystem input = InputSystem.getInstance();

	private TimeSystem() {

	}

	private static TimeSystem instance = new TimeSystem();

	public static TimeSystem getInstance() {
		return instance;
	}

	public int getSec() {
		return this.sec;
	}

	public void TimerSystem(int sec) {
		this.sec = sec;
	}

	@Override
	public void run() {
		while (isRun) {

			if (input.getTimeHold())
				isHold = true;

			while (isHold) {
				if (input.getTimeRerun())
					break;
				if (input.getTimeStop()) {
					isRun = false;
					break;
				}
			}
			Calendar cal = Calendar.getInstance();
			String msg = sdf.format(cal.getTime());
			System.out.printf(msg + "[%d sec]\n", sec++);

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (input.getTimeStop()) {
				isRun = false;
			}
		}

	}

}
