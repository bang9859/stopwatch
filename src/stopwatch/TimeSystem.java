package stopwatch;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeSystem implements Runnable {
	private boolean isRun = true;
	private int sec = 1;
	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	InputSystem input = InputSystem.getInstance();

	private TimeSystem() {

	}

	private static TimeSystem instance = new TimeSystem();

	public static TimeSystem getInstance() {
		return instance;
	}

	public boolean getIsRun() {
		return isRun;
	}

	public int getSec() {
		return this.sec;
	}

	@Override
	public void run() {
		boolean isHold = false;
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
			System.out.printf(msg + " [%d sec]\n", sec++);

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (input.getTimeStop()) {
				isRun = false;
				String message = String.format(">>> %d분 %d초 소요됨", sec / 60, sec % 60);
				System.out.println(message);
			}
		}

	}

}
