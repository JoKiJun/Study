
// Ŭ������ ���Ե� � ������ �پ��� �ڷ����� �����͸� �����ϴ� ���

class TheObject{
	int a; // a �������� ������ ������ �� �ֽ��ϴ�.
	Object o; // ��� �ڷ����� �����͸� ������ �� �ֽ��ϴ�.
}

class TheGeneric<E>{ // ���� Ȯ������ ���� E�ڷ����� ����ϴ� Ŭ���� (���� ������ �� �ڷ��� Ȯ��)
	E o;
}

class TheGeneric2<E, O>{
	E a1;
	O a2;
	
	void m(E e, O o) {}
	E m2() { return null;}
	O m3() { return null;}
}
public class Ex04Generic {

	public static void main(String[] args) {
		
		TheObject obj1 = new TheObject();
		obj1.a = 10;
		// obj.a = "Hello"; : a ������ ������ ������ �� �ִ�.
		obj1.o = 100;
		obj1.o = "Hello"; // o ������ ��� �ڷ����� �����͸� ������ �� �ֽ��ϴ�.

		int a2 = obj1.a; // �ڷ����� ������ �������� �����͸� �д� ��� ����ȯ ���ʿ� 
		String s = (String)obj1.o; // Object�� ����� ������  �д� ��� ����ȯ �ʿ� 
		// a2 = (int)obj1.o; ����ȯ�� �߸��ϸ� ���� �߻�
		System.out.printf("%d, %s\n", a2, s);
		
		//////////////////////////////////////////
		
		TheGeneric<String> g = new TheGeneric<String>(); // ���� ���鶧 �ڷ��� ����
		g.o = "Hello"; 
		String s2 = g.o; // g.o�� String �����̱� ������ ����ȯ ���ʿ�
		//g.o = 10; // �ѹ� ������ ���Ŀ��� ������ �� �����ϴ�.
		
		TheGeneric<Integer> g2 = new TheGeneric<Integer>();
		g2.o = 10;
		int a3 = g2.o; // ����ȯ ���ʿ�
		
	}

}
