package aufgabe_1;

public class Clock extends Thread {
	int s;
	String t;
	public Clock(int seconds, String text) {
		s = seconds;
		t = text;
	}
	public void run() {
		int secondsLeft = s;
		while (secondsLeft > 0) {
		try {
			Thread.sleep(1000 * secondsLeft);
			secondsLeft -= 1;
			if(secondsLeft != 0) {
				System.out.println("verbleibende sekunden: " + secondsLeft);
			}
		
		}catch(InterruptedException t) {
			System.out.println(t);
		}	
		}
		System.out.print(t);
	}
	public static void main(int seconds, String message) {
		Clock clock = new Clock(seconds,message);
		clock.start();
	}
}
