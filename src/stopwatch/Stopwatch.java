package stopwatch;

import java.util.Scanner;

public class Stopwatch {
	private Scanner sc = new Scanner(System.in);
	private Stopwatch() {

	}

	private static Stopwatch instance = new Stopwatch();

	public static Stopwatch getInstance() {
		return instance;
	}

	public void run() {
		
	}
}
