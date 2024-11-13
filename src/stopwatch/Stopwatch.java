package stopwatch;

public class Stopwatch {

	TimeSystem time = new TimeSystem();
	InputSystem input = new InputSystem();
	private Stopwatch() {

	}

	private static Stopwatch instance = new Stopwatch();

	public static Stopwatch getInstance() {
		return instance;
	}

	public void run() {
		showMenu();
		runStopwatch();

		showResult();
	}


	private void showMenu() {
		System.err.println("[q] STOP");
		System.err.println("[h] HOLD");
		System.err.println("[a] RERUN");
	}

	private void runStopwatch() {
		Thread timeThread = new Thread(time);
		Thread inputThread = new Thread(input);
		timeThread.start();
		inputThread.start();
		if(input.getTimeHold()) {
			timeThread.interrupt();
		}else if(input.getTimeHold()&&input.getTimeRerun()) {
			timeThread.start();
		}else if(input.getTimeStop()) {
			timeThread.interrupt();
			System.out.printf(">>> %d분 %d초 소요됨",time.getSec()/60,time.getSec()%60);
		}
		
	}

	private void showResult() {

	}
}
