import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class LottoDao {

	// 로또번호 데이터를 받아서 데이터베이스에 저장하고 영향받은 행의 갯수를 반환 
	public int insertWinningNumbers(List<WinningNumbersDto> winningNumbersList) {
		
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
			String sql = "insert into Winning_Numbers " +
			              "values ( ?, ?, ?, ?, ?, ?, ?, ?)";
     
			pstmt  = conn.prepareStatement(sql); // 명령객체 만들기
			
			for(WinningNumbersDto dto : winningNumbersList) { // 좋은 방법은 아님.
			pstmt.setInt(1, dto.getRound()); // SQL의 1번째 ?에 사용될 데이터
			pstmt.setInt(2, dto.getNo1()); // SQL의 2번째 ?에 사용될 데이터
			pstmt.setInt(3, dto.getNo2());// SQL의 3번째 ?에 사용될 데이터
			pstmt.setInt(4, dto.getNo3()); // SQL의 4번째 ?에 사용될 데이터
			pstmt.setInt(5, dto.getNo4()); // SQL의 5번째 ?에 사용될 데이터
			pstmt.setInt(6, dto.getNo5()); // SQL의 6번째 ?에 사용될 데이터
			pstmt.setInt(7, dto.getNo6()); // SQL의 7번째 ?에 사용될 데이터
			pstmt.setInt(8, dto.getBonusNo()); //SQL의 8번째 ?에 사용될 데이터
			
			//4. 명령 실행 ( DML인 경우 영향 받은 행의 갯수 반환)
		count =  pstmt.executeUpdate(); // executeQuery : select, executeUpdate : select 이외의 sql
			
		//5. 결과가 있으면 (select 명령인 경우 ) 결과 처리 
			}
		
		}catch(Exception ex) {
			ex.printStackTrace(); // 오류 메세지를 화면에 출력
		}finally {
			// 6. 연결 종료해주는 작업
			try {conn.close();} catch(Exception ex) {}
			try {pstmt.close();} catch(Exception ex) {}
		
	}
		
		return count;
		
	
				}

public void deleteAllWinningNumbers() {
	
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
		String sql = "delete from winning_numbers";
 
		pstmt  = conn.prepareStatement(sql); // 명령객체 만들기
		
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
	
			}
	
// round 번호를 받아서 해당 round의 당첨 번호를 조회하고 WinningNumbers 객체로 반환
public WinningNumbersDto selectWinningNumbersByRound(int Round) {
	
	Scanner scanner = new Scanner(System.in);
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; 
	WinningNumbersDto winningNumbers  = null;
	
	try {
	// 1. JDBC 드라이버 로딩

		Class.forName("oracle.jdbc.OracleDriver");
		
		//2. 데이터베이스 연결  ( 연결 객체 준비 )
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", // db server url
				"scott", "TIGER"); //계정 정보

		// 3-2. SQL 작성 2 (SQL과 데이터를 분리)
		String sql = "select \"round\", no1, no2, no3, no4, no5, no6, bonus_no " +
		        "from winning_numbers " +
				"where \"round\" = ? ";
		pstmt  = conn.prepareStatement(sql); // 명령객체 만들기
		pstmt.setInt(1, Round);;
		//4. 명령 실행 ( DML인 경우 영향 받은 행의 갯수 반환)
	       rs =  pstmt.executeQuery(); // executeQuery : select, executeUpdate : select 이외의 sql
		
	//5. 결과가 있으면 (select 명령인 경우 ) 결과 처리 
//	   	while(rs.next()) {
//			int round = rs.getInt("round");
//			int no1 = rs.getInt("no1");
//			int no2 = rs.getInt("no2");
//			int no3 = rs.getInt("no3");
//			int no4 = rs.getInt("no4");
//			int no5 = rs.getInt("no5");
//			int no6 = rs.getInt("no6");
//			int bonusNo = rs.getInt("bonusNo");
//			System.out.printf("[%d][%s][%s][%s][%s][%s][%s][%s]", 
//					round, no1, no2, no3, no4, no5, no6, bonusNo);
//		}
	       
	       if(rs.next()) { // primary key로 조회한 경우에는 if 사용 가능
	    	   winningNumbers = new WinningNumbersDto();
	    	   winningNumbers.setRound(rs.getInt(1));
	    	   winningNumbers.setNo1(rs.getInt(2));
	    	   winningNumbers.setNo2(rs.getInt(3));
	    	   winningNumbers.setNo3(rs.getInt(4));
	    	   winningNumbers.setNo4(rs.getInt(5));
	    	   winningNumbers.setNo5(rs.getInt(6));
	    	   winningNumbers.setNo6(rs.getInt(7));
	    	   winningNumbers.setBonusNo(rs.getInt(8));
	    	   
	       }
	}catch(Exception ex) {
		ex.printStackTrace(); // 오류 메세지를 화면에 출력
	}finally {
		// 6. 연결 종료해주는 작업
		try {conn.close();} catch(Exception ex) {}
		try {pstmt.close();} catch(Exception ex) {}
	
}
	return winningNumbers;
	
}


// 1~45 번호를 받아서 해당 번호의 출현 횟수를 조회하고 반환
public int selectCountByNumber(int number) {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int count = 0;
			
	
	try {
	// 1. JDBC 드라이버 로딩

		Class.forName("oracle.jdbc.OracleDriver");
		
		//2. 데이터베이스 연결  ( 연결 객체 준비 )
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", // db server url
				"scott", "TIGER"); //계정 정보

		// 3-2. SQL 작성 2 (SQL과 데이터를 분리)
		String sql = "select count(*) from winning_numbers " +
		// "where " + number + " in(no1, no2, no3, no4, no5, no6, bonus_No) ";
		"where ? in(no1, no2, no3, no4, no5, no6, bonus_No) ";
 
		pstmt  = conn.prepareStatement(sql); // 명령객체 만들기
		pstmt.setInt(1, number); // sql 문의 1번째 ?에 적용할 값 지정
		
		//4. 명령 실행 ( DML인 경우 영향 받은 행의 갯수 반환)
	rs =  pstmt.executeQuery(); // executeQuery : select, executeUpdate : select 이외의 sql
		
	//5. 결과가 있으면 (select 명령인 경우 ) 결과 처리 
	if(rs.next()) { // 조회 결과가 한 건인 경우 if 사용 가능
		count = rs.getInt(1);
	}
	
	}catch(Exception ex) {
		ex.printStackTrace(); // 오류 메세지를 화면에 출력
	}finally {
		// 6. 연결 종료해주는 작업
		try {rs.close();} catch(Exception ex) {}
		try {conn.close();} catch(Exception ex) {}
		try {pstmt.close();} catch(Exception ex) {}
	
	
}
	return count;
}
}
			
