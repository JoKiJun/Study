
public class ExJavafor1 {

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("===========================");
	

	for (int y =0; y < 10; y++) {
		for (int x = 0; x < 20; x++) {
			if( x ==0 || x ==20 -1 || y ==0 || y==10 -1) {
				System.out.print("*");
			}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
}
}
