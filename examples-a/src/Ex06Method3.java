
public class Ex06Method3 {

	public static void main(String[] args) {
		
		double result = add(10, 20); // �������ڰ� 2���� add ȣ��
		System.out.println(result);
		
		result = add(10, 20, 30); // �������ڰ� 3���� add ȣ��
		System.out.println(result);
	}
	
	static double add(double n1, double n2) {
		double result = n1 + n2;
		
		return result;  // �Լ� ���� + result�� ȣ���� ������ ��ȯ
	}

	// �޼��� �����ε� :�̸��� ������ ���������� �ڷ���, ����, ���� ���� ����ؼ� �ٸ� �Լ��� �����ϴ� ���
	static double add(double n1, double n2, double n3) {
		double result = n1 + n2 + n3;
		
		return result;  // �Լ� ���� + result�� ȣ���� ������ ��ȯ
	}
}

