
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

// 연락처 관리 --> 연락처 클래스 : 업무연락처클래스, 개인연락처클래스
// 업무연락처 : 연락처번호(정수), 이름(문자열), 전화번호(문자열), 이메일(문자열), 회사(문자열), 직함(문자열)
// 개인연락처 : 연락처번호(정수), 이름(문자열), 전화번호(문자열), 이메일(문자열), 관계(문자열), 생일(문자열)

// 1. 클래스 만들기
//    연락처클래스(Contact), 업무연락처클래스(BizContact), 개인연락처클래스(PersonalContact)
//    업무연락처클래스와 개인연락처클래스는 연락처클래스 상속

//파일에 저장 또는 파일로부터 읽는 클래스는 Serializable 인터페이스를 구현해야 합니다.
class Contact implements Serializable{
	private int no;
	private String name;
	private String phone;
	private String email;
	
	public Contact() {}

	public Contact(int no, String name, String phone, String email) {
		// super(); : 부모 클래스의 생성자 메서드 호출
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

// 파일에 저장 또는 파일로부터 읽는 클래스는 Serializable 인터페이스를 구현해야 합니다.
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
		 String info = super.info(); // super 부모클래스의 멤버를 명시적으로 표시할 때 사용
		 return String.format("%s[%s][%s]", info, company, title);
	 }
}

//파일에 저장 또는 파일로부터 읽는 클래스는 Serializable 인터페이스를 구현해야 합니다.
class PersonalContact extends Contact implements Serializable{
	private String relation;
	private String birth;
	
	public PersonalContact() {}
	public PersonalContact(int no, String name, String phone, String email,
			String relation, String birth) {
		super(no, name, phone, email); // 부모 클래스의 생성자 메서드 호출
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
	
	// 등록된 연락처 정보를 저장할 배열 만들기
	// 배열은 같은 자료형만 저장할 수 있는데 PersonalContact와 BizContact를 모두 저장하려면 ?
	// -> 부모 클래스인 Contact 타입으로 ArrayList 변경
	//Contact[] contacts = new Contact[1000];
	// ArryList<Contact> contacts = new ArrayList<>();
	ArrayList<Contact> contacts = null; // 생성자 메서드에서 초기화 하도록 변경
	
	// 마지막 등록된 연락처의 위치 ( 또는 ) 다음에 등록할 연락처의 위치를 저장할 변수
	// 다음에 등록할 연락처의 생성 순서 번호 저장할 변수
	int nextIdx = 1;
	
	public ContactManager() { // 생성자 메서드 : 초기화 , 인스턴스가 만들어질 때 자동호출
		
		File file = new File("contact.kj"); // 파일 또는 폴더 정보를 관리하는 클래스
		if(!file.exists()) { // exists() : 파일이 있는지 확인하는 메서드
			contacts = new ArrayList<>();
			return; // return : 메서드 종료 명령
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
				Contact lastContact = contacts.get(contacts.size() -1); // 목록의 마지막 연락처 
				nextIdx = lastContact.getNo() +1;
			}
		}catch(Exception ex) {
			contacts = new ArrayList<>(); // 문제가 생기면 빈 ArrayList 사용
			ex.printStackTrace();
		} finally {
			try { ois.close(); } catch(Exception ex) {}
			try { fis.close(); } catch(Exception ex) {}
		}
		
	}
	public void doManage(){
		
		while (true) { // 메뉴표시 - 선택에 따라 실행 반복
			String selection = selectMenu();
			
			System.out.println(); //  앞쪽 여백
			if(selection.equals("7")) {
				System.out.println(">>> 프로그램이 종료됩니다.");
				break;
			}else if(selection.equals("1")) { //           등록
				Contact contact = inputContact();
				contact.setNo(nextIdx); // 자동 증가 번호로 연락처 번호를 설정
				//contacts[nextIdx] = contact;
				contacts.add(contact);
				nextIdx++; // 다음에 등록할 연락처의 생성 순서 번호 수정 ( 자동 증가 번호 증가)
				System.out.println(">>> 새 연락처를 등록했습니다.");
			} else if (selection.equals("4")) {       // 목록보기
				//if(nextIdx == 0 ) { // 등록된 연락처가 없다면
				if(contacts.size() == 0) {
					System.out.println("등록된 연락처가 없습니다.");
				} else {
					showAllContacts();
				}
			} else if(selection.equals("6")) { // 저장
				FileOutputStream fos =null; // 저장 장소에 따라 결정 : 디스크에 파일형태로 저장
				ObjectOutputStream oos = null; // 저장할 데이터에 따라 결정 : ArrayList
				
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
				System.out.println(">> 연락처를 파일에 저장했습니다.");
			} else { 
				System.out.println(">>> 지원하지 않는 기능입니다.");
			}
			System.out.println(); // 뒤쪽 여백
		}
}

	private void showAllContacts() {
		System.out.println("[연락처 목록]");
        for (int i =0; i < contacts.size(); i++) {
		     Contact contact = contacts.get(i);
		     System.out.println(contact.info());
}
//        for (Contact contact : contacts) {
//		     System.out.println(contact.info());
//        }
	}

	private Contact inputContact() {
		Contact contact = null; // 새로 등록한 연락처에 대한 참조 변수 (부모타입으로 선언)
		//입력
		System.out.println("[등록할 연락처 정보]");
		System.out.print("종류 (1-개인역락처, 2-업무연락처) : ");
		String type = scanner.nextLine();
		System.out.print("이름 : ");
		String name = scanner.nextLine();
		System.out.print("전화번호 : ");
		String phone = scanner.nextLine();
		System.out.print("이메일 : ");
		String email = scanner.nextLine();
		if(type.equals("1")) { // 개인연락처의 경우
			System.out.print("관계 : ");
			String relation = scanner.nextLine();
			System.out.print("생일 : ");
			String birth = scanner.nextLine();
			contact = new PersonalContact(0, name, phone, email, relation, birth);
			System.out.println(contact.info());
		}else { // 업무연락처
			System.out.print("회사 : ");
			String company = scanner.nextLine();
			System.out.print("직함 : ");
			String title = scanner.nextLine();
			contact = new BizContact(0, name, phone, email, company, title);
			System.out.println(contact.info());
		}
		return contact;
	}

private  String selectMenu() {
	System.out.println("****************************");
	System.out.println("* 1. : 연락처 등록    *********");
	System.out.println("* 2. : 연락처 수정    *********");
	System.out.println("* 3. : 연락처 삭제    *********");
	System.out.println("* 4. : 연락처 목록    *********");
	System.out.println("* 5. : 연락처 검색    *********");
	System.out.println("* 6. : 연락처 저장    *********");
	System.out.println("* 7. : 종료         *********");
	System.out.println("****************************");
	System.out.print("작업을 선택하세요.");
	String selection = scanner.nextLine();
	return selection;
}
//private void testMethod1() {
//	PersonalContact personalContact = new PersonalContact();
//	personalContact.setNo(1);
//	personalContact.setName("장동건");
//	personalContact.setPhone("010-9098-3345");
//	personalContact.setEmail("jdk@example.com");
//	personalContact.setRelation("Friend");
//	personalContact.setBirth("04-11");		
//	System.out.println( personalContact.info() );
//	
//	
//    PersonalContact PersonalContact2 = new PersonalContact(1, "조기준", "0120-0505-554", "ejklrj@nmekl.com","Friend","01-44");
//    System.out.println(PersonalContact2.info());
//    
//    BizContact bizContact = new BizContact();
//    bizContact.setNo(2);
//    bizContact.setName("조기준");
//    bizContact.setPhone("010-5454-56560");
//    bizContact.setEmail("rnklwejnk@nrkjebaw.com");
//    bizContact.setCompany("이퀄");
//    bizContact.setTitle("배우");
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

