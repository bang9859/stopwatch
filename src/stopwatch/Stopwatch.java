package stopwatch;

public class Stopwatch {

	TimeSystem time = TimeSystem.getInstance();
	InputSystem input = InputSystem.getInstance();

	private Stopwatch() {

	}

	private static Stopwatch instance = new Stopwatch();

	public static Stopwatch getInstance() {
		return instance;
	}

	public void run() {
		showMenu();
		runStopwatch();

	}

	private void showMenu() {
		System.out.println("[더조은 스탑워치]");
		System.err.println("[q] STOP");
		System.err.println("[h] HOLD");
		System.err.println("[a] RERUN");
	}

	private void runStopwatch() {
		Thread timeThread = new Thread(time);
		Thread inputThread = new Thread(input);
		timeThread.start();
		inputThread.start();
	}

	
}
