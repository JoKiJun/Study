import java.util.Scanner;

class CurrencyCalculator{
	private double dollar;
	private double euro;
	private double cny;
	
	public CurrencyCalculator(double dollar, double euro, double cny) {
		super();
		this.dollar = dollar;
		this.euro = euro;
		this.cny = cny;
	}
	
	public double calculate(String targetCurrency, double won) {
		switch(targetCurrency) {
		case "1" : return won / dollar; 
		case "2" : return won / euro;
		case "3" : return won / cny;
		default : return 0;
		}
		
	}
}

public class Ex02ExchangeRate {

	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		CurrencyCalculator calculator = new CurrencyCalculator(1228.5, 1328.75, 192.62);
		
		while (true) {
			System.out.println("****************************");
			System.out.println("* 1. ȯ�����.        ********");
			System.out.println("* 2. ����           *********");
			System.out.println("****************************");
			System.out.print("�۾��� �����ϼ���.");
			String selection = scanner.next();
			if (selection.equals("1")) {
				System.out.print("ȭ����(1:�޷�, 2:����, 3:����) : ");
				String currency = scanner.next();
				System.out.print("ȯ���ݾ�(���� : ��) : ");
				double won = scanner.nextDouble();
				double result = calculator.calculate(currency, won);
				System.out.printf("ȯ����� :  %.2f\n", result);
				System.out.println();
			}else if (selection.endsWith("2")){
				System.out.println("���α׷��� �����մϴ�.");
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
				
		}

	}
	

	}


