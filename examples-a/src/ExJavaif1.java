
public class ExJavaif1 {
	
	public static void main(String[] args) {
		
		//1. ���� 3�� �Է� (����)
				java.util.Scanner scanner = new java.util.Scanner(System.in);
				
				System.out.print("���� 1 : ");
				int score1 = scanner.nextInt();
				System.out.print("���� 2 : ");
				int score2 = scanner.nextInt();
				System.out.print("���� 3 : ");
				int score3 = scanner.nextInt();		
				
				//2. �Էµ� ������ �հ� ��� ����ؼ� ������ ���� (�� : ����, ��� : �Ǽ�)
				int total = score1 + score2 + score3;
				double mean = total / 3;
				
				//3. ����� ����ؼ� ������ ���� (��� ����)
				//   90 ~ 100 : A, 80 ~ 89 : B, 
				//   70 ~ 79 : C, 60 ~ 69 : D, ������ : F
				char grade = 'F';
				boolean valid = true;
				//if (90 <= mean <= 100) { //���� (90 <= mean) <= 100
				//if (90 <= mean mean <= 100) { //���� : true false
				switch((int)mean) {
				case 9:
				case 8:
				case 7:
				case 6:
				case 5:
				}
				if (90 <= mean && mean <= 100) {
					grade = 'A';
				} else if (80 <= mean && mean < 90) {
					grade = 'B';
				} else if (70 <= mean && mean < 80) {
					grade = 'C';
				} else if (60 <= mean && mean < 70) {
					grade = 'D';
				} else if (0 <= mean && mean < 60) {
					grade = 'F';
				} else {
					valid = false;
				}		
				if (valid == true) {
					//4. ��� : ���� -> [���� : 100][��� : 40��][��� : A]
					System.out.printf("[���� : %d][��� : %.2f][��� : %c]", 
									  total, mean, grade);
				} else {
					System.out.println("�Է¿� ������ �ֽ��ϴ�.");
				scanner.close();}
	}
}
