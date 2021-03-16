package aufgabe_1;

public class ThreadClass extends Thread {
	private Result r;
	private int i;
	private F f;
	public ThreadClass(Result result, int index, F function) {
		r = result;
		i = index;
		f = function;
	}
	public void run() {
		try {
			Thread.sleep(1000);	
			r.receiveResult(f.f(i), i);
		} catch (InterruptedException e) {

		}
	
	}
}
