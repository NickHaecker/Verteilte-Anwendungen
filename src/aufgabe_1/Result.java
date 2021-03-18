package aufgabe_1;

public class Result {
	private int[] result;
	//private int counter = 0;
	public Result(int l) {
		result = new int[l];
		//counter++;
		
	}
	public synchronized void receiveResult(int res, int index) {
		result[index] = res;
		//if(counter == result.length) {
			notify();
		//}
	}
	public synchronized int[] getResult() throws InterruptedException   {
		wait();
		return result;
	}
}
