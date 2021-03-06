import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDao {

	// 회원정보 데이터를 받아서 데이터베이스에 저장하고 영향받은 행의 갯수를 반환 
	public int insertMember(MemberDto member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0; // SQL 실행에 영향을 받은 행의 갯수 저장 변수
		
		try {
		// 1. JDBC 드라이버 로딩
	
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 데이터베이스 연결  ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // db server url
					"scott", "TIGER"); //계정 정보
	
			// 3-2. SQL 작성 2 (SQL과 데이터를 분리)
			String sql = "insert into member (memberid, passwd, email) " +
			              "values ( ?, ?, ?)";
			pstmt  = conn.prepareStatement(sql); // 명령객체 만들기
			pstmt.setString(1, member.getMemberId()); // SQL의 1번째 ?에 사용될 데이터
			pstmt.setString(2, member.getPasswd()); // SQL의 2번째 ?에 사용될 데이터
			pstmt.setString(3, member.getEmail()); // SQL의 3번째 ?에 사용될 데이터
			
			//4. 명령 실행 ( DML인 경우 영향 받은 행의 갯수 반환)
		count =  pstmt.executeUpdate(); // executeQuery : select, executeUpdate : select 이외의 sql
			
		//5. 결과가 있으면 (select 명령인 경우 ) 결과 처리 
		
		
		}catch(Exception ex) {
			ex.printStackTrace(); // 오류 메세지를 화면에 출력
		}finally {
			// 6. 연결 종료해주는 작업
			try {conn.close();} catch(Exception ex) {}
			try {pstmt.close();} catch(Exception ex) {}
		
	}
		
		return count;
	}
}
