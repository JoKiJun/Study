import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactDao {

// contact_sequence.nextval : 번호를 자동으로 증가시켜주는 메서드

	// 회원정보 데이터를 받아서 데이터베이스에 저장하고 영향받은 행의 갯수를 반환 
	public void insertContact(ContactDto contact) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
		// 1. JDBC 드라이버 준비
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 데이터베이스 연결  ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // db server url
					"scott", "TIGER"); //계정 정보
	
			// 3-2. SQL 작성 2 (SQL과 데이터를 분리)
			String sql = "insert into contact (no, name, phone, email) " +
			              "values (contact_sequence.nextval, ?, ?, ?) ";
			pstmt  = conn.prepareStatement(sql); // 명령객체 만들기
	
			pstmt.setString(1, contact.getName()); // SQL의 1번째 ?에 사용될 데이터
			pstmt.setString(2, contact.getPhone()); // SQL의 2번째 ?에 사용될 데이터
			pstmt.setString(3, contact.getEmail()); // SQL의 3번째 ?에 사용될 데이터
			
			//4. 명령 실행 ( DML인 경우 영향 받은 행의 갯수 반환)
		   pstmt.executeUpdate(); // executeQuery : select, executeUpdate : select 이외의 sql
			
		//5. 결과가 있으면 (select 명령인 경우 ) 결과 처리 
		
		
		}catch(Exception ex) {
			ex.printStackTrace(); // 오류 메세지를 화면에 출력
		}finally {
			// 6. 연결 종료해주는 작업
			try {conn.close();} catch(Exception ex) {}
			try {pstmt.close();} catch(Exception ex) {}
		}
	}

		public List<ContactDto> selectAllContacts() {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			// 조회 결과를 저장할 컬렉션 객체 ( 조회 결과가 여러 개일 수 있기 때문..)
			ArrayList<ContactDto> contacts = new ArrayList<>();
			try {
			// 1. JDBC 드라이버 로딩
				// DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
				Class.forName("oracle.jdbc.OracleDriver");
				
				//2. 데이터베이스 연결  ( 연결 객체 준비 )
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe", // db server url
						"scott", "TIGER"); //계정 정보
				
				// 3. SQL 작성 1 ( SQL과 데이터를 문자열로 결합 )
//				String sql = "select employee_id, first_name, last_name, email " +
//						 "from employees " +
//						"where      lower(first_name) like '%" + key + "%'" +
//						"        or lower(last_name) like '%" + key + "%'";
//				pstmt  = conn.prepareStatement(sql); // 명령객체 만들기
				
				
				// 3-2. SQL 작성 2 (SQL과 데이터를 분리)
				String sql = "select no, name, phone, email " +
						 "from contact ";
				pstmt  = conn.prepareStatement(sql); // 명령객체 만들기
				
				//4. 명령 실행 (select인 결우 ResultSet 형식의 결과 반환)
			rs = pstmt.executeQuery(); // executeQuery : select, executeUpdate : select 이외의 sql
				
			//5. 결과가 있으면 (select 명령인 경우 ) 결과 처리 
			while(rs.next()) { // 결과 집합의 다음 행으로 이동 ( 더이상 행이 없다면 false 반환)
				ContactDto contact = new ContactDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)); // 한 행마다 Dto 객체 만들어서
				contacts.add(contact);
				 // 한 행의 데이터를 저장한 Dto객체를 목록에 추가
			}
			}catch(Exception ex) {
				ex.printStackTrace(); // 오류 메세지를 화면에 출력
			}finally {
				// 6. 연결 종료해주는 작업
				try {rs.close();} catch(Exception ex) {}
				try {conn.close();} catch(Exception ex) {}
				try {pstmt.close();} catch(Exception ex) {}
			
		}
		 return contacts; // 조회 결과를 저장한 컬렉션 객체를 호출한 곳으로 반환
}
		
		public int selectContactsByName(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int contacts = 0;
				
		
		try {
		// 1. JDBC 드라이버 로딩

			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 데이터베이스 연결  ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // db server url
					"scott", "TIGER"); //계정 정보

			// 3-2. SQL 작성 2 (SQL과 데이터를 분리)
			String sql = "select count(*) from contact " +
			// "where " + number + " in(no1, no2, no3, no4, no5, no6, bonus_No) ";
			"where ? in(contact_sequence.nextval, name, phone, email) ";
	 
			pstmt  = conn.prepareStatement(sql); // 명령객체 만들기
			pstmt.setInt(1, no); // sql 문의 1번째 ?에 적용할 값 지정
			
			//4. 명령 실행 ( DML인 경우 영향 받은 행의 갯수 반환)
		rs =  pstmt.executeQuery(); // executeQuery : select, executeUpdate : select 이외의 sql
			
		//5. 결과가 있으면 (select 명령인 경우 ) 결과 처리 
		if(rs.next()) { // 조회 결과가 한 건인 경우 if 사용 가능
			contacts = rs.getInt(no);
		}
		
		}catch(Exception ex) {
			ex.printStackTrace(); // 오류 메세지를 화면에 출력
		}finally {
			// 6. 연결 종료해주는 작업
			try {rs.close();} catch(Exception ex) {}
			try {conn.close();} catch(Exception ex) {}
			try {pstmt.close();} catch(Exception ex) {}
		
		
	}
		return contacts;
	}

	
}
