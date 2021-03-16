package aufgabe_1;

public class Dispatcher {

	public static void main(String[] args) {
		int[] x =  excecute(new Function(), 10);
		for(int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
	}
	public static int[] excecute(F f, int n) {
		int[] i = new int[n];
		i[0]= f.f(0);
		i[1] = f.f(7);
		return i;
	}
}
