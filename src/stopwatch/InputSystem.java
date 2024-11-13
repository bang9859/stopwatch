package stopwatch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputSystem implements Runnable {
	private boolean isRun = true;
	private boolean timeStop = false;
	private boolean timeHold = false;
	private boolean timeRerun = false;

	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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
				String input = reader.readLine();

				String stop = "q";

				if (input.equals(stop)) {
					timeStop = true;
				}
				if (input.equals("h")) {
					timeHold = true;
					timeRerun = false;
				}
				if (input.equals("a")) {
					timeHold = false;
					timeRerun = true;
				}
				if (timeStop)
					if (timeStop) {
						isRun = false;
					}
			} catch (Exception e) {
			}
		}
		closeReader();
	}

	public void closeReader() {
		try {
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
