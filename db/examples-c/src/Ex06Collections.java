import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class Ex06Collections {

	public static void main(String[] args) throws Exception {


//		//1. ArrayList : List �������̽� ����, ���� �迭 (ũ�Ⱑ �ڵ����� ����Ǵ� �迭)
//		//ArrayList al = new ArrayList();//Non Generic ��� (��� �ڷ����� ������ ����)
//	ArrayList<String> al = new ArrayList<>();//Generic ��� (������ �ڷ��� ������ ����)
//	         // al.add(100); //Generic �÷����� ��� ����
//		al.add("ù ��° ������.");//����� �������� �߰�
//		al.add("�� ��° ������.");
//		al.add("�� ��° ������.");
//		al.add("�� ��° ������.");
//		al.add("�� ��° ������."); // �ߺ� ����� Ȯ���ϱ� ���� �׽�Ʈ
//		al.add(1, "���Ե� ������.");//1��° ��ġ�� ����		
//		for (int i = 0; i < al.size(); i++) {	//�÷���.size() : ����� ����
//			System.out.println(al.get(i));		//List�÷���.get(��ġ) : ������ ��ġ�� ������ ��ȯ
//		}
//		al.remove(2);//��ġ�� 2��° ������ ����
//		//String strToRemove = (String)al.get(0); // Non-Generic ����� ����ȯ �ʿ� 
//		String strToRemove = al.get(0); // Generic ����� ����ȯ �ʿ� ����.
//		al.remove(strToRemove);//strToRemove�� ���� ��ü�� ���� (���⼭�� 0��° ������)		
//		System.out.println();
//		for (int i = 0; i < al.size(); i++) {//�÷���.size() : ����� ����
//			System.out.println(al.get(i));//List�÷���.get(��ġ) : ������ ��ġ�� ������ ��ȯ
//		}
		
		/////////////////////////////////////////////////////////////////////////////
		
		// 2. Vector
//		Vector<String> al = new Vector<>();//
//		al.add("ù ��° ������.");//����� �������� �߰�
//		al.add("�� ��° ������.");
//		al.add("�� ��° ������.");
//		al.add("�� ��° ������.");
//		al.add(1, "���Ե� ������.");//1��° ��ġ�� ����
//		
//		for (int i = 0; i < al.size(); i++) {//�÷���.size() : ����� ����
//			System.out.println(al.get(i));//List�÷���.get(��ġ) : ������ ��ġ�� ������ ��ȯ
//		}
//		
//		al.remove(2);//��ġ�� 2��° ������ ����
//		String strToRemove = al.get(0);
//		al.remove(strToRemove);//strToRemove�� ���� ��ü�� ���� (���⼭�� 0��° ������)
//		
//		System.out.println();
//		for (int i = 0; i < al.size(); i++) {//�÷���.size() : ����� ����
//			System.out.println(al.get(i));//List�÷���.get(��ġ) : ������ ��ġ�� ������ ��ȯ
//		}
//		
		/////////////////////////////////////////////////////////
		
		//3. LinkedList : ���԰� ������ ����� ��쿡 ������ Ŭ����
//		LinkedList<String> al = new LinkedList<>();//
//		al.add("ù ��° ������.");//����� �������� �߰�
//		al.add("�� ��° ������.");
//		al.add("�� ��° ������.");
//		al.add("�� ��° ������.");
//		al.add(1, "���Ե� ������.");//1��° ��ġ�� ����
//		
//		for (int i = 0; i < al.size(); i++) {//�÷���.size() : ����� ����
//			System.out.println(al.get(i));//List�÷���.get(��ġ) : ������ ��ġ�� ������ ��ȯ
//		}
//		
//		al.remove(2);//��ġ�� 2��° ������ ����
//		String strToRemove = al.get(0);
//		al.remove(strToRemove);//strToRemove�� ���� ��ü�� ���� (���⼭�� 0��° ������)
//		
//		System.out.println();
//		for (int i = 0; i < al.size(); i++) {//�÷���.size() : ����� ����
//			System.out.println(al.get(i));//List�÷���.get(��ġ) : ������ ��ġ�� ������ ��ȯ
//		}
		
		/////////////////////////////////////////////////////////////////
		
		//4. HashSet : �ߺ� X , ��ġ ��� X ( 3��° ������ �б� X )
//		HashSet<String> al = new HashSet<>();//
//		al.add("ù ��° ������.");
//		al.add("�� ��° ������.");
//		al.add("�� ��° ������.");
//		al.add("�� ��° ������.");
//		al.add("�� ��° ������.");//���� ������ ����� (�ߺ�������)
//		
//		// al.get(2); // ��ġ�� �����ؼ� �����Ϳ� ������ �� �����ϴ�.
////		for (int i = 0; i < al.size(); i++) {
////			al.get(i);//Set �迭�� ������ ����� ��ġ ���� ��� X
////		}
//		for (String str : al) { //��Ͽ��� ���� �����Ͱ� ������ �����͸� �о str ����
//			System.out.println(str);
//		}
//		
//		System.out.println();
//		
//		//al.remove(2);//���� : ��ġ ��ȣ ��� �Ұ���
//		String strToRemove = "�� ��° ������.";
//		al.remove(strToRemove);//strToRemove�� ���� ��ü�� ����
//		
//		for (String str : al) {//��Ͽ��� ���� �����Ͱ� ������ �����͸� �о str ����
//			System.out.println(str);
//		}
//		
//		System.out.println();
		
		///////////////////////////////////////////////////////////////
		
		//4-1. HashSet2
//		HashSet<String> al = new HashSet<>();//
//		al.add("ù ��° ������.");
//		al.add("�� ��° ������.");
//		al.add("�� ��° ������.");
//		al.add("�� ��° ������.");
//		al.add("�� ��° ������.");//���� ������ ����� (�ߺ�������)
//
////		for (String str : al) { //��Ͽ��� ���� �����Ͱ� ������ �����͸� �о str ����
////			System.out.println(str);
////		}
//		
//		//enhanced for�� ���� ����
//		Iterator<String> iter = al.iterator(); //Iterator : java�� ��ȸ�� ���� ǥ��
//		while (iter.hasNext()) { // hasNext : ���� �׸��� ������ true ������ false
//			String data = iter.next(); //next : ���� �׸� ��������
//			System.out.println(data);
//		}
//		
//		System.out.println();
//		
//		//al.remove(2);//���� : ��ġ ��ȣ ��� �Ұ���
//		String strToRemove = "�� ��° ������.";
//		al.remove(strToRemove);//strToRemove�� ���� ��ü�� ����
//		
//		for (String str : al) {//��Ͽ��� ���� �����Ͱ� ������ �����͸� �о str ����
//			System.out.println(str);
//		}
//		
//		System.out.println();	
		
		////////////////////////////////////////////////////////
		
		//5. HashMap (Hashtable)
//		HashMap<String, String> al = new HashMap<>();//
//		//Hashtable<String, String> al = new Hashtable<>();//
//		al.put("1", "ù ��° ������."); // put : ������ �߰�
//		al.put("2", "�� ��° ������.");
//		al.put("3", "�� ��° ������.");
//		al.put("a", "Ű�� �ٸ� ������.");
//		al.put("4", "�� ��° ������.");
//		al.put("5", "�� ��° ������.");	//���� ����
//		al.put("5", "�ټ� ��° ������.");	//���� ���� (overwrite)
//		
//		System.out.println("TEST : " + al.get("a")); // Map.get(Key) : ������ �б�
//		
//		Set<String> keys = al.keySet();//keySet : Ű ��� ��ȯ (Set ��������), 
//		                               // ���⼭�� "1", "2", "3","a", "4", "5"
//		for (String key : keys) { //��Ͽ��� ���� �����Ͱ� ������ �����͸� �о key ����
//			String value = al.get(key); //get: ��Ͽ��� key�� �˻��� ������ ��ȯ
//			System.out.println( value );
//		}
//		
//		String keyToRemove = "3";
//		al.remove(keyToRemove);		
//		System.out.println();		
//		for (String key : al.keySet()) {
//			System.out.println(al.get(key));
//		}
		
		//////////////////////////////////////////////
		
		 //6. Properties 
		 //   (Ű : ���ڿ�, �� : ���ڿ��� Map / ���Ͽ� �����ϰ� �д� ��� ���� / �ַ� �������� ���������� ���)
//		 Properties al = new Properties();//
//		 al.put("1", "First Data.");
//		 al.put("3", "Second Data.");
//		 al.put("4", "Third Data.");
//		 al.put("2", "Fourth Data.");
//		 al.put("5", "Fourth Data.");//���� ����
//		 al.put("5", "Fifth Data.");//���� ����
//		
//		 //store: ���Ͽ� �����͸� �����ϴ� ���
//		 //FileOutputStream : ���Ͽ� ���� �������� �����ϴ� Ŭ����
//		 al.store(new FileOutputStream("test.properties"), "test properties file");
//		
//		 Properties props = new Properties();
//		 //load : ���Ͽ��� �����͸� �а� Properties�� �������� �޼���
//		 //FileInputStream : ���Ͽ� �б� �������� �����ϴ� Ŭ����
//		 props.load(new FileInputStream("test.properties"));//���Ͽ��� ������ �д� ���
//		
//		 Set keys = props.keySet();//Ű ��� ��ȯ
//		 for (Object key : keys) {//��Ͽ��� ���� �����Ͱ� ������ �����͸� �о str ����
//		 	String value = (String)props.get(key);//��Ͽ��� key�� �˻��� ������ ��ȯ
//		 	System.out.println( value );
//		}
		
		//7. Stack (���Լ��� - Last In First Out)
//		Stack<String> stack = new Stack<>();
//		stack.push("a;dklja;sldkjfa;sdfjl"); // push : ������ �߰� (����)
//		stack.push("13243654321321");
//		stack.push("��;���Ƥä�;�Ϥ���");
//		
//		while (stack.size() > 0) {
//			System.out.println(stack.pop());	//pop : ������ �����͸� �а� ��Ͽ��� ����
//			//System.out.println(stack.peek());	//�а� ��Ͽ� ����
//		}	
		
		//8. Queue (���Լ��� - First In First Out)
//		Queue<String> queue = new LinkedList<>();
//		queue.offer("1.a;dklja;sldkjfa;sdfjl");	//offer : ������ �߰� (����)
//		queue.offer("2.13243654321321");
//		queue.offer("3.��;���Ƥä�;�Ϥ���");
//		
//		while (queue.size() > 0) {
//			System.out.println(queue.poll());	//poll : ù��° �����͸� �а� ��Ͽ��� ����
//			//System.out.println(queue.peek());	//�а� ��Ͽ� ����
//		}

	}

}