import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;


public class Ex08IO {

	public static void main(String[] args) throws Exception {
		
//		//1. char[] <-> byte[] ���� ó�� (�ؽ�Ʈ ������ IO)
//		FileOutputStream fos1 = new FileOutputStream("test1.txt");//����� ���� �����
//		String str = "���Ͽ� ���� ������ 1\r\n"; //���ڿ� : char[]
//		byte[] bstr = str.getBytes(); //String.getBytes() : char[] -> byte[] �޼���
//		fos1.write(bstr);
//		fos1.write("���Ͽ� ���� ������ 2\r\n".getBytes());
//		fos1.write("���Ͽ� ���� ������ 3\r\n".getBytes());
//		
//		fos1.close();//���� �ݱ�
//		
//		System.out.println("���Ͽ� �����͸� ����ϴ�.");
		
//		FileInputStream fis1 = new FileInputStream("test1.txt");//�б� ��Ʈ��
//		byte[] buffer1 = new byte[256];//�� ���� ���� �����͸� ������ ����
//		while (true) {
//			int count =						//read ������� ���� ���� ������ �� (return ��) 
//				fis1.read(buffer1,			//��Ʈ������ ���� �����͸� ������ byte[]  ����
//						  0, 				//���� �����͸� buffer1�� ������ �������� ����
//						  buffer1.length);	//�б� ���ϴ� �� ( ���⼭�� 256byte )
//			
//			if (count == -1) break; //EOF (End of File)
//			
//			//byte[] -> char[] ���� ��ȯ (String �����ڸ� ���)
//			String str2 = new String(buffer1, 0, count);//buffer1�� 0��°���� count������ �����͸� ���ڿ��� ��ȯ
//			System.out.println(str2);
//		}
//		fis1.close();//���� �ݱ�
		
		//////////////////////////////////////////////////////////////////////

//		2. char[] <-> byte[] �ڵ� ��ȯ (Text Data �����)
//		FileOutputStream ostream2 = new FileOutputStream("test2.txt");//���� ���
//		OutputStreamWriter writer2 = new OutputStreamWriter(ostream2);//��ȯ ���
//		writer2.write("���Ͽ� ����ϴ�\t\t ������ 1\r\n");
//		writer2.write("���Ͽ� ����ϴ�\t\t ������ 2\r\n");
//		writer2.write("���Ͽ� ����ϴ�\t\t ������ 3\r\n");
//		writer2.close();
//		ostream2.close();
//		System.out.println("���Ͽ� �����͸� ����ϴ�.");
//		
//		FileInputStream istream2 = new FileInputStream("test2.txt"); // �б� ���
//		InputStreamReader reader2 = new InputStreamReader(istream2); // byte[] -> char[]��ȯ ���
//		BufferedReader breader2 = new BufferedReader(reader2);		 // �� ���� �б� ���
//		while (true) {
//			String line = breader2.readLine();//readLine : �� �� �б�
//			if (line == null)//EOF (End Of File)
//				break;
//			System.out.println(line);
//		}
//		breader2.close();
//		reader2.close();
//		istream2.close();
		
		//3. primitive type <-> byte[]		
//		FileOutputStream ostream3 = new FileOutputStream("test3.dat");//���Ͽ� ����
//		DataOutputStream dostream3 = new DataOutputStream(ostream3); //primitive type -> byte[]
//		
//		FileOutputStream ostream3_1 = 	new FileOutputStream("test3.txt");//���Ͽ� ����
//		OutputStreamWriter writer3 = new OutputStreamWriter(ostream3_1); //text -> byte[]
//		
//		for (int i = 0; i < 10000; i++) { // 10000�� �����͸� ���Ͽ� ���
//			dostream3.writeInt(Integer.MAX_VALUE); //binary write
//			writer3.write( String.valueOf(Integer.MAX_VALUE) ); //text write			
//		}
//		dostream3.close();
//		ostream3.close();
//		writer3.close();
//		ostream3_1.close();
//		
//		System.out.println("���Ͽ� �����͸� ����ϴ�.");
//		
//		FileInputStream istream3 = new FileInputStream("test3.dat");//���Ͽ��� �б�
//		DataInputStream distream3 = new DataInputStream(istream3);//byte[] -> binary
//		int data = distream3.readInt();
//		int data2 = distream3.readInt();
//		System.out.printf("%d-%d", data, data2);
//		
//		distream3.close(); istream3.close();
		
		//4. Object <-> byte[]
//		Item item = new Item();
//		item.setNo(10); // item.no = 10;
//		item.setName("�׽�Ʈ ������");
//		System.out.println(item.toString());
//		
//		FileOutputStream ostream4 = new FileOutputStream("test4.dat"); // byte[] ����
//		ObjectOutputStream oostream4 = new ObjectOutputStream(ostream4); // Object -> byte[]		
//		oostream4.writeObject(item);//��ü�� byte[]�� ��ȯ�ؼ� ���Ͽ� binary �������� ���� 		
//		oostream4.close(); ostream4.close();
//		
//		System.out.println("���Ͽ� �����͸� ����ϴ�.");
//		
//		FileInputStream istream4 = new FileInputStream("test4.dat"); //byte[] �б�
//		ObjectInputStream oistream4 = new ObjectInputStream(istream4); // byte[] -> Object
//		Item item2 = (Item)oistream4.readObject();//���Ͽ��� byte[] �����͸� �а� ��ü�� ����
//
//		System.out.println(item2);
//				
//		oistream4.close();
//		istream4.close();
		
		//5.		
//		ArrayList<Item> items = new ArrayList<Item>();
//		for (int i = 0; i < 10; i++) {
//			Item item = new Item();
//			item.setNo(i+1); 
//			item.setName("test " + (i + 1));
//			items.add(item);
//		}
//				
//		FileOutputStream ostream5 = new FileOutputStream("test5.dat");
//		ObjectOutputStream oostream5 = new ObjectOutputStream(ostream5);
//		
//		//�������� ������ �����ϴ� ���
////		for (Item item : items) {
////			oostream5.writeObject(item);
////		}
//			
//		//�������� �ѹ��� �����ϴ� ��� (ArrayList�� ����) -> ArrayList�� ��� ��ҵ� ����
//		oostream5.writeObject(items);  
//
//		oostream5.close();
//		ostream5.close();
//		
//		System.out.println("���Ͽ� �����͸� ����ϴ�.");
//		
//		FileInputStream istream5 = new FileInputStream("test5.dat");
//		ObjectInputStream oistream5 = new ObjectInputStream(istream5);
//		ArrayList<Item> items2 = (ArrayList<Item>)oistream5.readObject();
//		
//		for (Item item : items2) {
//			//System.out.println(item);
//			System.out.println(item.toString());
//		}
//		oistream5.close();istream5.close();
		
		//6 - 1.
//		InputStream is = System.in;
//		//System.out.println(is.getClass());
//		InputStreamReader isr6 = new InputStreamReader(is); //System.in : ǥ�� �Է� ��Ʈ�� (Ű����)
//		BufferedReader br6 = new BufferedReader(isr6);//enter ������ �б� ����
//		
//		System.out.print("�̸� : ");
//		String name = br6.readLine();
//		System.out.println("Your Name is " + name); //System.out : ǥ�� ��� ��ġ (�����)
		
		//6 - 2. 
		Scanner scanner = new Scanner(System.in); //ǥ�� �Է� ��Ʈ�� (Ű����)
		System.out.print("�̸��� : ");
		String email = scanner.nextLine();
		System.out.println("Your Email is " + email);
		scanner.close();
			
	}

}