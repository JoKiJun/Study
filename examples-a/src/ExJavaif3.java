
public class ExJavaif3 {

	public static void main(String[] args) {
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("���� : ");
		int score = scanner.nextInt();
		System.out.print("���� : ");
		int score2 = scanner.nextInt();
		System.out.print("���� : ");
		int score3 = scanner.nextInt();
		
		int total = score + score2 + score3;
		double mean = total / 3;
		
		char grade = 'F';
		boolean valid = true;
		
		if(mean >= 90 && mean <= 100) {
			grade = 'A';
		}
		else if (mean >= 80 && mean < 90) {
			grade = 'B';
		}
		else if (mean >= 70 && mean <= 80) {
			grade = 'C';
		}
		else if (mean >= 60 && mean < 70) {
			grade = 'D';
		}
		//if (a <= 30 && a < 40) {
			//System.out.println("D");
		else if (mean >=50 && mean < 60) {
			grade = 'E';
		}else if (mean <= 50) {
			grade = 'F';
		}else {
			valid = false;
		}
		if (valid == true) {
			System.out.printf("[���� : %d[��� : %.1f][��� : %c]", total, mean, grade);
		}else {
			System.out.println("�Է¿� ������ �ֽ��ϴ�.");
		}
	scanner.close();}

}
