import java.util.Scanner;

class ExChange{
	private void selectionMenu() {
	System.out.println("****************************");
	System.out.println("* 1. �� >>> ��ȭ     *********");
	System.out.println("* 2. �� >>> ����     *********");
	System.out.println("* 3. �� >>> ����     *********");
	System.out.println("* 4. : ����         *********");
	System.out.println("****************************");
	Scanner sc = new Scanner(System.in);
	System.out.print("�۾��� �����ϼ���.");
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
			System.out.print("��ȭ�� �Է��ϼ���(���� ��) : ");
			int won = sc.nextInt();
			double dollar = (double)won/dollarRate;
			System.out.println(String.format(won + "���� �޷� : " + "%.2f",dollar ));
		} else if (num == 2 ) {
			System.out.print("��ȭ�� �Է��ϼ���(���� ��) : ");
			int won = sc.nextInt();
			double euro = (double)won / euroRate;
			System.out.println(String.format(won + "���� ���� : " + "%.2f", euro ));
		} else if (num == 3) {
			System.out.print("��ȭ�� �Է��ϼ���(���� ��) : ");
			int won = sc.nextInt();
			double cny = (double)won / cnyRate;
			System.out.println(String.format(won + "���� ���� : " + "%.2f", cny ));
		} else if (num == 4) {
			System.out.println("���α׷��� �����մϴ�.");
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}

}
