
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

// ����ó ���� --> ����ó Ŭ���� : ��������óŬ����, ���ο���óŬ����
// ��������ó : ����ó��ȣ(����), �̸�(���ڿ�), ��ȭ��ȣ(���ڿ�), �̸���(���ڿ�), ȸ��(���ڿ�), ����(���ڿ�)
// ���ο���ó : ����ó��ȣ(����), �̸�(���ڿ�), ��ȭ��ȣ(���ڿ�), �̸���(���ڿ�), ����(���ڿ�), ����(���ڿ�)

// 1. Ŭ���� �����
//    ����óŬ����(Contact), ��������óŬ����(BizContact), ���ο���óŬ����(PersonalContact)
//    ��������óŬ������ ���ο���óŬ������ ����óŬ���� ���

//���Ͽ� ���� �Ǵ� ���Ϸκ��� �д� Ŭ������ Serializable �������̽��� �����ؾ� �մϴ�.
class Contact implements Serializable{
	private int no;
	private String name;
	private String phone;
	private String email;
	
	public Contact() {}

	public Contact(int no, String name, String phone, String email) {
		// super(); : �θ� Ŭ������ ������ �޼��� ȣ��
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String info() {
		return String.format("[%3d][%s][%s][%s]", no, name, phone, email );	
	}
}

// ���Ͽ� ���� �Ǵ� ���Ϸκ��� �д� Ŭ������ Serializable �������̽��� �����ؾ� �մϴ�.
class BizContact extends Contact implements Serializable{
	private String company;
	private String title;
	
	public BizContact() {}
	public BizContact(int no, String name, String phone, String email,
			String company, String title) {
		super(no, name, phone, email);
		this.company = company;
		this.title = title;
		
	}


	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	 public String info() {
		 String info = super.info(); // super �θ�Ŭ������ ����� ��������� ǥ���� �� ���
		 return String.format("%s[%s][%s]", info, company, title);
	 }
}

//���Ͽ� ���� �Ǵ� ���Ϸκ��� �д� Ŭ������ Serializable �������̽��� �����ؾ� �մϴ�.
class PersonalContact extends Contact implements Serializable{
	private String relation;
	private String birth;
	
	public PersonalContact() {}
	public PersonalContact(int no, String name, String phone, String email,
			String relation, String birth) {
		super(no, name, phone, email); // �θ� Ŭ������ ������ �޼��� ȣ��
		this.relation = relation;
		this.birth = birth;
		
		
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public String info() {
		String info = super.info();
		return String.format("%s[%s][%s]", info, relation, birth);
	}
}


class ContactManager  {
	
	java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	// ��ϵ� ����ó ������ ������ �迭 �����
	// �迭�� ���� �ڷ����� ������ �� �ִµ� PersonalContact�� BizContact�� ��� �����Ϸ��� ?
	// -> �θ� Ŭ������ Contact Ÿ������ ArrayList ����
	//Contact[] contacts = new Contact[1000];
	// ArryList<Contact> contacts = new ArrayList<>();
	ArrayList<Contact> contacts = null; // ������ �޼��忡�� �ʱ�ȭ �ϵ��� ����
	
	// ������ ��ϵ� ����ó�� ��ġ ( �Ǵ� ) ������ ����� ����ó�� ��ġ�� ������ ����
	// ������ ����� ����ó�� ���� ���� ��ȣ ������ ����
	int nextIdx = 1;
	
	public ContactManager() { // ������ �޼��� : �ʱ�ȭ , �ν��Ͻ��� ������� �� �ڵ�ȣ��
		
		File file = new File("contact.kj"); // ���� �Ǵ� ���� ������ �����ϴ� Ŭ����
		if(!file.exists()) { // exists() : ������ �ִ��� Ȯ���ϴ� �޼���
			contacts = new ArrayList<>();
			return; // return : �޼��� ���� ���
		}
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("contact.kj");
			ois = new ObjectInputStream(fis);
			contacts = (ArrayList<Contact>)ois.readObject();
			if(contacts.size() == 0) {
				nextIdx = 1;
			} else {
				Contact lastContact = contacts.get(contacts.size() -1); // ����� ������ ����ó 
				nextIdx = lastContact.getNo() +1;
			}
		}catch(Exception ex) {
			contacts = new ArrayList<>(); // ������ ����� �� ArrayList ���
			ex.printStackTrace();
		} finally {
			try { ois.close(); } catch(Exception ex) {}
			try { fis.close(); } catch(Exception ex) {}
		}
		
	}
	public void doManage(){
		
		while (true) { // �޴�ǥ�� - ���ÿ� ���� ���� �ݺ�
			String selection = selectMenu();
			
			System.out.println(); //  ���� ����
			if(selection.equals("7")) {
				System.out.println(">>> ���α׷��� ����˴ϴ�.");
				break;
			}else if(selection.equals("1")) { //           ���
				Contact contact = inputContact();
				contact.setNo(nextIdx); // �ڵ� ���� ��ȣ�� ����ó ��ȣ�� ����
				//contacts[nextIdx] = contact;
				contacts.add(contact);
				nextIdx++; // ������ ����� ����ó�� ���� ���� ��ȣ ���� ( �ڵ� ���� ��ȣ ����)
				System.out.println(">>> �� ����ó�� ����߽��ϴ�.");
			} else if (selection.equals("4")) {       // ��Ϻ���
				//if(nextIdx == 0 ) { // ��ϵ� ����ó�� ���ٸ�
				if(contacts.size() == 0) {
					System.out.println("��ϵ� ����ó�� �����ϴ�.");
				} else {
					showAllContacts();
				}
			} else if(selection.equals("6")) { // ����
				FileOutputStream fos =null; // ���� ��ҿ� ���� ���� : ��ũ�� �������·� ����
				ObjectOutputStream oos = null; // ������ �����Ϳ� ���� ���� : ArrayList
				
				try {
					fos = new FileOutputStream("contact.kj");
					oos = new ObjectOutputStream(fos);
					oos.writeObject(contacts);
				}catch (Exception ex) {
					ex.printStackTrace();
				}finally {
					try { oos.close(); } catch(Exception ex) {}
					try { fos.close(); } catch(Exception ex) {}
				}
				System.out.println(">> ����ó�� ���Ͽ� �����߽��ϴ�.");
			} else { 
				System.out.println(">>> �������� �ʴ� ����Դϴ�.");
			}
			System.out.println(); // ���� ����
		}
}

	private void showAllContacts() {
		System.out.println("[����ó ���]");
        for (int i =0; i < contacts.size(); i++) {
		     Contact contact = contacts.get(i);
		     System.out.println(contact.info());
}
//        for (Contact contact : contacts) {
//		     System.out.println(contact.info());
//        }
	}

	private Contact inputContact() {
		Contact contact = null; // ���� ����� ����ó�� ���� ���� ���� (�θ�Ÿ������ ����)
		//�Է�
		System.out.println("[����� ����ó ����]");
		System.out.print("���� (1-���ο���ó, 2-��������ó) : ");
		String type = scanner.nextLine();
		System.out.print("�̸� : ");
		String name = scanner.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = scanner.nextLine();
		System.out.print("�̸��� : ");
		String email = scanner.nextLine();
		if(type.equals("1")) { // ���ο���ó�� ���
			System.out.print("���� : ");
			String relation = scanner.nextLine();
			System.out.print("���� : ");
			String birth = scanner.nextLine();
			contact = new PersonalContact(0, name, phone, email, relation, birth);
			System.out.println(contact.info());
		}else { // ��������ó
			System.out.print("ȸ�� : ");
			String company = scanner.nextLine();
			System.out.print("���� : ");
			String title = scanner.nextLine();
			contact = new BizContact(0, name, phone, email, company, title);
			System.out.println(contact.info());
		}
		return contact;
	}

private  String selectMenu() {
	System.out.println("****************************");
	System.out.println("* 1. : ����ó ���    *********");
	System.out.println("* 2. : ����ó ����    *********");
	System.out.println("* 3. : ����ó ����    *********");
	System.out.println("* 4. : ����ó ���    *********");
	System.out.println("* 5. : ����ó �˻�    *********");
	System.out.println("* 6. : ����ó ����    *********");
	System.out.println("* 7. : ����         *********");
	System.out.println("****************************");
	System.out.print("�۾��� �����ϼ���.");
	String selection = scanner.nextLine();
	return selection;
}
//private void testMethod1() {
//	PersonalContact personalContact = new PersonalContact();
//	personalContact.setNo(1);
//	personalContact.setName("�嵿��");
//	personalContact.setPhone("010-9098-3345");
//	personalContact.setEmail("jdk@example.com");
//	personalContact.setRelation("Friend");
//	personalContact.setBirth("04-11");		
//	System.out.println( personalContact.info() );
//	
//	
//    PersonalContact PersonalContact2 = new PersonalContact(1, "������", "0120-0505-554", "ejklrj@nmekl.com","Friend","01-44");
//    System.out.println(PersonalContact2.info());
//    
//    BizContact bizContact = new BizContact();
//    bizContact.setNo(2);
//    bizContact.setName("������");
//    bizContact.setPhone("010-5454-56560");
//    bizContact.setEmail("rnklwejnk@nrkjebaw.com");
//    bizContact.setCompany("����");
//    bizContact.setTitle("���");
//    
//    System.out.println(bizContact.info());
//}
}




public class Ex07ContactManager {
	
	
	public static void main(String[] args) {

		ContactManager manager = new ContactManager();
		manager.doManage();
}

}

