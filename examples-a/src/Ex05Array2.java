
public class Ex05Array2 {

	public static void main(String[] args) {
		// �ζ� ��÷ ���� ��ȣ �̱�
				// 1. �⺻ ��Ģ�� ������ ��ȣ �̱� -> �迭�� ����, for ���
				//    1 ~ 45, random, �ߺ�X, 6�� 
				
				// 2. ��� �˻�
				//    ����� 20 ~ 26�� �ƴϸ� 1���� �ٽ�
				
				// 3. �迭�� ����� ���� ���� ��� -> for ���
				
				// 4. ����� ���ÿ� ���� �ݺ�
				
				java.util.Scanner scanner = new java.util.Scanner(System.in);
				
				while (true) { // ����� ���ÿ� ���� �ݺ��ϴ� �ݺ���
					
					System.out.println("******************************");
					System.out.println("* 1. ��÷ ���� ��ȣ �̱�.");
					System.out.println("* 2. ����.");
					System.out.println("******************************");
					System.out.print("�۾��� �����ϼ��� : ");
					String selection = scanner.nextLine();
					
					System.out.println();
					
					if (selection.equals("1")) {
						int[] numbers = new int[6];
						// �⺻ ��ȣ �̱�
						int mean = 0;
						do {
						for (int i = 0; i < numbers.length; i++) {
							numbers[i] = (int)(Math.random() * 45) + 1;
							//�ߺ��˻縦 ���� �ݺ� (0���� ���� ���� ��ġ i���� ��
							for(int j =0; j <i; j++) {
								if(numbers[i] == numbers[j]) {// �ߺ��� �߻��ϴ� ���
									// i--; ���� ��ġ�� ��ȣ�� �ٽ� �̱� 
									i = -1; // ó������ �ٽ� �̱�
									break;
								}
							}
						}
						//��� ���
						int sum = 0;
						for(int number : numbers) {
							sum += number; // sum = sum +number
						}
						mean = sum / numbers.length;
						}while (mean <20 || mean >26);
						// ���� ��ȣ ���
						System.out.print("SELECTED NUMBERS : ");
						for (int number : numbers) {
							System.out.printf("[%d]", number);
						}
						System.out.printf("[��� : %d]", mean); //��� ���
						System.out.println();
								
					} else if (selection.equals("2")) {
						System.out.println("����� ���ϴ�. ���� �Ǽ���.");
						break;
					} else {
						System.out.println("�������� �ʴ� ����Դϴ�.");
					}
					
					System.out.println();
	}

}
}