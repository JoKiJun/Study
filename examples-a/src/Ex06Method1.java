
public class Ex06Method1 {

	public static void main(String[] args) {
		// �߰�ȣ {} : ������ �����.
		{
			int a =10;
			a= 20;
			{
				a = 30; // ������ ����� ������ ���� ���������� ��� ����
				int b = 40;
			}
			{
				//b = 50; // ����� ���� �ܺο��� ���� ��� X
			}
		}
		// a = 30; ����� ���� �ܺο��� ���� ��� X
		drawBox(); // �Լ� ȣ�� : �Լ��� �����ϰ� ����� ���

}

	// �Լ� ���� or ���� : �Լ��� ����� 
	private static void drawBox() {
		// 2. ���� ��� ( 20 x 10 )
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 20; x++) {
				if (x == 0 || x == 20 - 1 || 
					y == 0 || y == 10 - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
	}
	}
}