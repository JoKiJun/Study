public class Ex05BasicClasses {

	public static void main(String[] args) {
		
		//1. ���ڿ��� ���ϼ� �� + ���ͷ� ���ڿ�
		//   ���� ���ͷ� ���ڿ��� �׻� ���� ��ü�� �����մϴ�.
		String str1 = "Hello";
		String str2 = "Hello";
		System.out.println("1." + str1.equals(str2)); //true
		System.out.println("2." + (str1 == str2) ); // ?
		
		str1 = new String("Hello");
		str2 = new String("Hello");
		System.out.println("3." + str1.equals(str2)); //true
		System.out.println("4." + (str1 == str2)); // ?
		
		//2. ���� ���ڿ�
		String str3 = new String("Original String");
		String str4 = str3;
		str4 = str4 + "Attached String";
		System.out.println(str3 == str4);
		System.out.println(str3);
		System.out.println("------------");
		
		//3. ���� ���ڿ�
		//StringBuilder sb = new StringBuilder(36);
		StringBuffer sb = new StringBuffer(36); //36���� ���� ����
		sb.append("Original String ");
		sb.append("Attached String");
		System.out.println(sb.toString());
		
		
		//4. String ���� �޼���
		String data = " 12345678901234567890 ";	//�� ���� ������ ���Ե� ���ڿ� 
		System.out.println("���� ���� : " + data.length());//���� ���� ��ȯ		
		data = data.trim(); //trim : �糡 ���� ����
		System.out.println("���� ó�� �� ���� ���� : " + data.length());//���� ���� ��ȯ
		
		System.out.println("0�� ��ġ �տ��� : " + data.indexOf("0"));//"0"�� ��ġ (�տ��� ���� �˻�)
		System.out.println("0�� ��ġ �ڿ��� : " + data.lastIndexOf("0"));//"0"�� ��ġ(�ڿ��� ���� �˻�)
		
		System.out.println("5��° ���ں��� : " + data.substring(5));//5��° ���ں��� ������ ��ȯ
		System.out.println("5��° ~ 10��° : " + data.substring(5, 10));//5��° ���� 10��° ���� ��ȯ
		
		String[] strs = "123;456;789;012;345".split(";");//���ڿ� �и� -> �迭 ��ȯ
		for (int i = 0; i < strs.length; i++) {
			System.out.print(strs[i] + "  ");
		}
		System.out.println();
		System.out.println("test string".contains("Str"));
		System.out.println("test string".endsWith("ing"));
		System.out.println("test string".startsWith("te"));
		
		//5. Wrapper Type ( Byte, short, Integer, Long, Float, Double, Boolean, Character)
		// primitive type �����͸� �����ϴ� ������
		int pi = 10; // primitive type
		Integer ri= 10; // reference type
		
		
		//6. Primitive Type <==> String
		String s4 = String.valueOf(12.34);			//12.34 -> "12.34"
		int i4a = Integer.parseInt("12345");		//"12345" -> 12345
		int i4b = Integer.valueOf("12345");			//"12345" -> 12345
		double d4a = Double.parseDouble("12.34");	//"12.34" -> 12.34
		System.out.printf("%s / %d / %d / %f\n\n", s4, i4a, i4b, d4a);

		//7. 
		Object o;
		int x = 10;
		o = x; // �����δ� : o = new Integer(x); // Auto Boxing : primitive -> reference
		//o = new Integer(x);		
		System.out.println(o);
		
		int y = (int)o; // �����δ� : int y = ((Integer)o).intValue(); // Auto Unboxing
		System.out.println(y);

	}

}
