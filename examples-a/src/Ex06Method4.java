
public class Ex06Method4 {

	static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		// �ζ� ��÷ ���� ��ȣ �̱�
				// 1. �⺻ ��Ģ�� ������ ��ȣ �̱� -> �迭�� ����, for ���
				//    1 ~ 45, random, �ߺ�X, 6�� 
				
				// 2. ��� �˻�
				//    ����� 20 ~ 26�� �ƴϸ� 1���� �ٽ�
				
				// 3. �迭�� ����� ���� ���� ��� -> for ���
				
				// 4. ����� ���ÿ� ���� �ݺ�
		
		while (true) { // ����� ���ÿ� ���� �ݺ��ϴ� �ݺ���
			// 1. �޴�ǥ�� + ����� ����
			
				String selection = selectMenu();
		
			System.out.println();
			// 2. ����� ���ÿ� ���� �۾� ���� ( ���ǹ� ���)
			if (selection.equals("1")) {
				int[] numbers = selectWinningNumbers();
				int mean = mean(numbers);
				
				// 2-1-3 ���� ��ȣ ���
				showNumbers(numbers,mean);
				
			} else if (selection.equals("2")) {
				System.out.println("����� ���ϴ�. ���� �Ǽ���.");
				break;
			} else {
				System.out.println("�������� �ʴ� ����Դϴ�.");
				}
				
				System.out.println();
}

}

	

	////////////////////////////////////////////
	 static void showNumbers (int[] numbers, int mean) {
		 System.out.print("SELECTED NUMBERS : ");
			for (int number : numbers) {
				System.out.printf("[%d]", number);
			}
			System.out.printf("[��� : %d]", mean); //��� ���
			System.out.println();
	 }
	 private static String selectMenu() {
			System.out.println("******************************");
			System.out.println("* 1. ��÷ ���� ��ȣ �̱�.");
			System.out.println("* 2. ����.");
			System.out.println("******************************");
			System.out.print("�۾��� �����ϼ��� : ");
			String selection = scanner.nextLine();
			
			return selection;
		}

	static int mean(int[] numbers) {
		int sum = 0;
			for(int number : numbers) {
				sum += number; // sum = sum +number
			}
			int mean = sum / numbers.length;
			return mean;
	}
	
	static int[] selectBasicNumbers2() {
		int[] numbers = new int[6];
	for (int i = 0; i < numbers.length; i++) {
		numbers[i] = (int)(Math.random() * 45) + 1;
		//�ߺ��˻縦 ���� �ݺ� (0���� ���� ���� ��ġ i �������� ��
		for(int j =0; j <i; j++) {
			if(numbers[i] == numbers[j]) {// ���� ������ȣ == �������� ��ȣ���� �ߺ��� �߻��ϴ� ���
				// i--; ���� ��ġ�� ��ȣ�� �ٽ� �̱� 
				i = -1; // ó������ �ٽ� �̱�
				break;
				
				
				
				/*static void selectBasicNumbers(int[] numbers) {
				for (int i = 0; i < numbers.length; i++) {
					numbers[i] = (int)(Math.random() * 45) + 1;
					//�ߺ��˻縦 ���� �ݺ� (0���� ���� ���� ��ġ i �������� ��
					for(int j =0; j <i; j++) {
						if(numbers[i] == numbers[j]) {// ���� ������ȣ == �������� ��ȣ���� �ߺ��� �߻��ϴ� ���
							// i--; ���� ��ġ�� ��ȣ�� �ٽ� �̱� 
							i = -1; // ó������ �ٽ� �̱�
						break; 
						*/
						
					}
				}
			}
	return numbers;
		}
	static int[] selectWinningNumbers() {
		int[] numbers = new int[6];
		int mean = 0;
		do {
			// 2-1.1 �⺻ ��ȣ �̱�
			// selectBasicNumbers(numbers);
			numbers = selectBasicNumbers2();
			
		//2-1-2. ��� ��� + �˻�
		mean = mean(numbers);
		 
		}while (mean <20 || mean >26);
		return numbers;
	}
		}
	
	 
	
			

