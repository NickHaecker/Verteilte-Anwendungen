package aufgabe_1;

public class Dispatcher {

	public static void main(String[] args) throws InterruptedException {
		int[] x =  excecute(new Function(), 10);
		for(int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
	}
	public static int[] excecute(F f, int n) throws InterruptedException {
		Result result = new Result(n);
		for(int i = 0; i < n; i++) {
			ThreadClass t = new ThreadClass(result, i,f);
			t.start();
		}
		int[] r = result.getResult();
		return r;
	}
}
