// �߱�����
		// 1. ��ǻ�� ��ȣ ���� (random, 3�� , 0 ~ 9 , �ߺ� x)
		// 2. ����� �Է� ( ��ȣ 3�� , 0~9, �ߺ� x)
		// 3. ��
		//    ���� ��ġ , ������ȣ�� strike
		//    �ٸ� ��ġ, ������ȣ�� ball
		//   ���� ��ȣ�� ���ٸ� out
		// 4. �� ��� ǥ��
		// 5. �� ����� 3strike �̸� �������� ( �̰���ϴ� ǥ��) �ƴϸ� 2������ �ٽùݺ�
		// 6. 2~ 5 �� �ݺ��� 10ȸ�� �ʰ��ϸ� ���� ���� ( �����ϴ�. ǥ��)



import java.util.Scanner;

public class Ex03BasebollGame {
	 Scanner scanner = new Scanner(System.in);
	
	public  void doGame() {
		
		while (true) {
			//����� �۾� ����
		String selection = selectMenu();
		
		System.out.println();
		if(selection.equals("1")) {
			startGame();
		
		}else if(selection.equals("2")) {
			System.out.println("���α׷� ����");
			break;
		}else {
			System.out.println("�������� �ʴ� ����Դϴ�.");
		}
		System.out.println();
	}
	}
	private void startGame() {
		// ��ǻ�� ��ȣ �̱�
		int[] comNumbers = selectComNumbers();
		//System.out.println("" + comNumbers[0] + comNumbers[1] + comNumbers[2]); //test
		boolean win = false;
		for (int i =0; i < 10; i++) { // 10ȸ �ݺ�
			// ����� ��ȣ �Է�
		int[] userNumbers = selectUserNumbers();
		// ����� ��ȣ�� ��ǻ�� ��ȣ ��
		int[] result = compareDate(comNumbers, userNumbers);
		//��� ���
		System.out.printf("ROUND %2d : [Strike : %d][Ball : %d][Out : %d]\n",
		                   i+1,result[0], result[1], result[2]);
		// �¸� ���� �˻� �� ó��
		if(result[0] == 3) {
			win = true;
			break;
		  }
        }
		// ���� ���
		if(win) {
			System.out.println("�����մϴ�. �̰���ϴ�.");
		} else {
			System.out.println(" �����ϴ�... ");
		}
	}	
	 private int[] compareDate(int[] comNumbers, int[] userNumbers) {
		int strike = 0, ball = 0, out = 0;
		for(int i = 0; i <comNumbers.length; i++) {
			for (int j = 0; j <userNumbers.length; j++) {
				if(i == j && comNumbers[i] == userNumbers[j]) {
					strike++;
				} else if (i != j && comNumbers[i] == userNumbers[j]) {
					ball++;
				} 
					
				
			}
		}
		out = 3 - (strike + ball);
//		int [] ar1 = new int[3];
//		ar1[0] = 1; ar1[1] =2; ar1[2] = 3;
//		int[] ar2 = new int[] {1, 2, 3}; // �迭 �ʱ�ȭ
//		int [] ar3 = {1,2,3};           // �迭 �ʱ�ȭ
		
		return new int[] { strike, ball, out}; // [strike][ball][out] �迭 ��ȯ
}
	private int[] selectUserNumbers() {
		System.out.print("0 ~ 9 �������� ���� ���� �Է�(ex : 1 7 6) : ");
		String input = scanner.nextLine(); // nextLine() : ������ �����ؼ� �Է� (next() : ������ �� ����
		input = input.trim();// ���ڿ� ���� ������ ���� ����
		String[] sNumbers = input.split(" ");// split : �־��� ���ڸ� �������� ��ü ���ڿ��� ����
		int[] numbers = new int[3];
		for (int i = 0; i < sNumbers.length; i++) {
			numbers[i] = Integer.parseInt(sNumbers[i]); // integer.parseInt : ���ڿ� -> ����
	   }
		return numbers;
	}

	private int[] selectUserNumbers2() {
		System.out.print("0 ~ 9 �������� ���� ���� �Է�(ex : 176) : ");
		String input = scanner.nextLine(); // nextLine() : ������ �����ؼ� �Է� (next() : ������ �� ����
		input = input.trim();// ���ڿ� ���� ������ ���� ����
		int[] numbers = new int[3];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(input.charAt(i) + ""); // integer.parseInt : ���ڿ� -> ����
	   }
		return numbers;
	}
	
	private int[] selectComNumbers() {
		int[] comNumbers = new int[3];
		for(int i =0; i < comNumbers.length; i++) {
			comNumbers[i] = (int)(Math.random() *10);
			for(int j =0; j <i; j++) {
				if(comNumbers[i] == comNumbers[j]) {
					i--;
					break;
				}
			}
		}
		return comNumbers;
	}

	private String selectMenu() {
		System.out.println("------------------------");
		System.out.println("- 1. ���� ����           -");
		System.out.println("- 2. ����      ----------");
		System.out.println("------------------------");
		String selection = scanner.nextLine();
		return selection;
	}
	
	public static void main(String[] args) {
		Ex03BasebollGame game = new Ex03BasebollGame();
		game.doGame();
	}
}
