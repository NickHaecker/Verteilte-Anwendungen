package aufgabe_1;

public class Result {
	private int[] result = new int[11];
	public synchronized void receiveResult(int res, int index) {
		result[index] = res;
		notify();
	}
	public synchronized int[] getResult() throws InterruptedException   {
		wait();
		return result;
	}
}
