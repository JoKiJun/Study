import java.util.Scanner;

class ExChange{
	private void selectionMenu() {
	System.out.println("****************************");
	System.out.println("* 1. 원 >>> 미화     *********");
	System.out.println("* 2. 원 >>> 유로     *********");
	System.out.println("* 3. 원 >>> 위안     *********");
	System.out.println("* 4. : 종료         *********");
	System.out.println("****************************");
	Scanner sc = new Scanner(System.in);
	System.out.print("작업을 선택하세요.");
	int num = sc.nextInt();
	String select = new String();
	return;
	}
}
public class ExChangeRateCal {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		
		double dollarRate = 1228;
		double euroRate = 1330;
		double cnyRate = 192;
		int num = sc.nextInt();
		extracted(sc, num, dollarRate, euroRate, cnyRate);
		
	}

	private static void extracted(Scanner sc, int num, double dollarRate, double euroRate, double cnyRate) {
		if(num ==1) {
			System.out.print("원화를 입력하세요(단위 원) : ");
			int won = sc.nextInt();
			double dollar = (double)won/dollarRate;
			System.out.println(String.format(won + "원은 달러 : " + "%.2f",dollar ));
		} else if (num == 2 ) {
			System.out.print("원화를 입력하세요(단위 원) : ");
			int won = sc.nextInt();
			double euro = (double)won / euroRate;
			System.out.println(String.format(won + "원은 유로 : " + "%.2f", euro ));
		} else if (num == 3) {
			System.out.print("원화를 입력하세요(단위 원) : ");
			int won = sc.nextInt();
			double cny = (double)won / cnyRate;
			System.out.println(String.format(won + "원은 위안 : " + "%.2f", cny ));
		} else if (num == 4) {
			System.out.println("프로그램을 종료합니다.");
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

}
