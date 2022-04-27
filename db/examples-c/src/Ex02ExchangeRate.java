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
			System.out.println("* 1. 환율계산.        ********");
			System.out.println("* 2. 종료           *********");
			System.out.println("****************************");
			System.out.print("작업을 선택하세요.");
			String selection = scanner.next();
			if (selection.equals("1")) {
				System.out.print("화폐선택(1:달러, 2:유로, 3:위안) : ");
				String currency = scanner.next();
				System.out.print("환전금액(단위 : 원) : ");
				double won = scanner.nextDouble();
				double result = calculator.calculate(currency, won);
				System.out.printf("환전결과 :  %.2f\n", result);
				System.out.println();
			}else if (selection.endsWith("2")){
				System.out.println("프로그램을 종료합니다.");
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
				
		}

	}
	

	}


