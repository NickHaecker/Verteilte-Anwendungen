package aufgabe_1;

public class Result {
	private int[] result;
	public Result(int l) {
		result = new int[l];

		
	}
	public synchronized void receiveResult(int res, int index) {
		result[index] = res;
		notify();
	
	}
	public synchronized int[] getResult() throws InterruptedException   {
		wait();
		return result;
	}
}
