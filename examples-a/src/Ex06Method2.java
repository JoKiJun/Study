
public class Ex06Method2 {

	public static void main(String[] args) {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		// 1. ����ڷκ��� �Է� : �ڽ� �׸��⿡ ����� ���� 
		System.out.print("�ڽ� �׸��⿡ ����� ���� : ");
		String s = scanner.next();
		// 2. ����� �Է� : �ڽ��� �ʺ� 
		System.out.print("�ڽ��� �ʺ� : ");
		int width = scanner.nextInt();
		// 2-1 ����� �Է� : �ڽ��� ����
		System.out.print("�ڽ��� ���� : ");
		int height = scanner.nextInt();
		
		drawBox(s, width, height); // �Լ� ȣ�� : �Լ��� �����ϰ� ����� ���

}

	// �Լ� ���� or ���� : �Լ��� ����� 
	private static void drawBox(String s, int height, int width) {//��������
		// 2. ���� ��� ( 20 x 10 )
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (x == 0 || x == width - 1 || 
					y == 0 || y == height - 1) {
					System.out.print(s);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
	}
	}
} // ����å���� ��Ģ : � �ϳ��� �ڵ������ �ϳ��� ��ɿ��� ����