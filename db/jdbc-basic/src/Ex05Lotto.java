import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex05Lotto {

	java.util.Scanner scanner = new java.util.Scanner(System.in);
	LottoDao dao = new LottoDao();
	
	public void doGame() {
		
		while (true) { // 사용자 선택에 따라 반복하는 반복문
			// 1. 메뉴표시 + 사용자 선택
			
				String selection = selectMenu();
			System.out.println();
			
			// 2. 사용자 선택에 따라 작업 수행 ( 조건문 사용)
			if (selection.equals("1")) {
				int[] numbers = selectWinningNumbers();
				int mean = mean(numbers);
				showNumbers(numbers,mean);
			} else if(selection.equals("2")) {
				//파일에서 과거 당첨 번호데이터 읽기
				
				List<WinningNumbersDto> WinningNumberslist = readWinninNumbersFromFile();
				
				// 읽은 데이터를 데이터베이스에 저장
					dao.insertWinningNumbers(WinningNumberslist);
			
			} else if (selection.equals("3")) {
				// dao 삭제 기능 호출 
					dao.deleteAllWinningNumbers();
				
			}else if (selection.equals("4")) {
				System.out.println("검색할 회차 번호 : ");
				int round = scanner.nextInt();
				scanner.nextLine(); // buffer에 남아있는 enter 제거
				WinningNumbersDto winningNumbers = dao.selectWinningNumbersByRound(round);
				System.out.println(winningNumbers);
			} else if (selection.equals("5")) { // 번호별 출현 횟수 조회
				System.out.print("검색할 번호 : ");
				int Number = scanner.nextInt();
				scanner.nextLine();
				int count = dao.selectCountByNumber(Number);
				System.out.printf("번호  [%2d]의 출현횟수 : [%3d]\n", Number, count);
			}else if (selection.equals("9")) {
				System.out.println("행운을 빕니다. 부자 되세요.");
				break;
			} else {
				System.out.println("지원하지 않는 기능입니다.");
				}
				
				System.out.println();
}

}

	private List<WinningNumbersDto> readWinninNumbersFromFile() {
		ArrayList<WinningNumbersDto> WinningNumberslist = new ArrayList<>();
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
		fis = new FileInputStream("lotto-winning-numbers.txt");
		isr = new InputStreamReader(fis); // byte[] -> char[]
		br = new BufferedReader(isr); // 한줄씩 데이터 읽기
			while(true) {
				String line = br.readLine(); // 한 줄의 문자열 데이터 읽기
				if(line == null) { // EOF(End of File)
					break;
					
				}
				String[] row = line.split(","); // "1,2,3" -> ["1","2","3"]
				WinningNumbersDto dto = new WinningNumbersDto();
				dto.setRound(Integer.parseInt(row[0]));
				dto.setNo1(Integer.parseInt(row[1]));
				dto.setNo2(Integer.parseInt(row[2]));
				dto.setNo3(Integer.parseInt(row[3]));
				dto.setNo4(Integer.parseInt(row[4]));
				dto.setNo5(Integer.parseInt(row[5]));
				dto.setNo6(Integer.parseInt(row[6]));
				dto.setBonusNo(Integer.parseInt(row[7]));
				
				WinningNumberslist.add(dto);
			}
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			try {br.close();} catch(Exception ex) {}
			try {isr.close();}catch(Exception ex) {}
			try {fis.close();}catch(Exception ex) {}
		}
		return WinningNumberslist;
	}

	

	////////////////////////////////////////////
	  void showNumbers (int[] numbers, int mean) {
		 System.out.print("SELECTED NUMBERS : ");
			for (int number : numbers) {
				System.out.printf("[%d]", number);
			}
			System.out.printf("[평균 : %d]", mean); //평균 출력
			System.out.println();
	 }
	 private  String selectMenu() {
			System.out.println("******************************");
			System.out.println("* 1. 당첨 예상 번호 뽑기.");
			System.out.println("* 2.  당첨 번호 저장"    );
			System.out.println("* 3.  당첨 번호 초기화"   );
			System.out.println("* 4. 회차별 당첨 번호 검색");
			System.out.println("* 5. 번호별 당첨 횟수 조회");
			System.out.println("* 9. 종료.");
			System.out.println("******************************");
			System.out.print("작업을 선택하세요 : ");
			String selection = scanner.nextLine();
			
			return selection;
		}

	 int mean(int[] numbers) {
		int sum = 0;
			for(int number : numbers) {
				sum += number; // sum = sum +number
			}
			int mean = sum / numbers.length;
			return mean;
	}
	
	 int[] selectBasicNumbers() {
		int[] numbers = new int[6];
	for (int i = 0; i < numbers.length; i++) {
		numbers[i] = (int)(Math.random() * 45) + 1;
		//중복검사를 위한 반복 (0부터 현재 뽑힌 위치 i 이전까지 비교
		for(int j =0; j <i; j++) {
			if(numbers[i] == numbers[j]) {// 현재 뽑힌번호 == 이전뽑힌 번호에서 중복이 발생하는 경우
				// i--; 현재 위치의 번호만 다시 뽑기 
				i = -1; // 처음부터 다시 뽑기
				break;
				
					}
				}
			}
	return numbers;
		}
	 int[] selectWinningNumbers() {
		int[] numbers = new int[6];
		int mean = 0;
		do {
			// 2-1.1 기본 번호 뽑기
			numbers = selectBasicNumbers();
			
		//2-1-2. 평균 계산 + 검사
		mean = mean(numbers);
		 
		}while (mean <20 || mean >26);
		return numbers;
	}
	 public static void main(String[] args) {
		Ex05Lotto lotto = new Ex05Lotto();
		lotto.doGame();
	}
		}
	
	 
	
			

