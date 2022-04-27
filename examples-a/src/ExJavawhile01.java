
public class ExJavawhile01 {

	public static void main(String[] args) {
		double a = Math.random();
		a = a * 10 + 20;
		int c = (int)a;
		
		int b = 0;
		while (b < c ) {
			System.out.printf("%d번째 데이터\n", (b + 1));
			b += 1;
		}
			
					
		System.out.println("**************");
		
		b = 0;
		while (true) {
			System.out.printf("%d번째 데이터\n", (a+1));
			b += 1;
			if (b >= c) {
				break;
			}
		}
	}
	

}