package stopwatch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputSystem implements Runnable {
	private boolean isRun = true;
	private boolean timeStop = false;
	private boolean timeHold = false;
	private boolean timeRerun = false;
	private final String STOP = "q";
	private final String HOLD = "h";
	private final String RERUN = "a";

	private InputSystem() {

	}

	private static InputSystem instance = new InputSystem();

	public static InputSystem getInstance() {
		return instance;
	}

	public boolean getTimeStop() {
		return timeStop;
	}

	public boolean getTimeHold() {
		return timeHold;
	}

	public boolean getTimeRerun() {
		return timeRerun;
	}

	@Override
	public void run() {
		while (isRun) {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				StringBuffer buffer = new StringBuffer();

				String input = reader.readLine();
				System.out.println(input);
				buffer.append(input);
				if (buffer.toString().equals(STOP)) {
					timeStop = true;
				}
				if (buffer.toString().equals(HOLD)) {
					timeHold = true;
					timeRerun = false;
				}
				if (buffer.toString().equals(RERUN)) {
					timeHold = false;
					timeRerun = true;
				}
				if (timeStop)
					if (timeStop) {
						isRun = false;
						try {
							reader.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
