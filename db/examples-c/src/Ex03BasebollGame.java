// 야구게임
		// 1. 컴퓨터 번호 선택 (random, 3개 , 0 ~ 9 , 중복 x)
		// 2. 사용자 입력 ( 번호 3개 , 0~9, 중복 x)
		// 3. 비교
		//    같은 위치 , 같은번호면 strike
		//    다른 위치, 같은번호면 ball
		//   같은 번호가 없다면 out
		// 4. 비교 결과 표시
		// 5. 비교 결과가 3strike 이면 게임종료 ( 이겼습니다 표시) 아니면 2번부터 다시반복
		// 6. 2~ 5 의 반복이 10회를 초과하면 게임 종료 ( 졋습니다. 표시)



import java.util.Scanner;

public class Ex03BasebollGame {
	 Scanner scanner = new Scanner(System.in);
	
	public  void doGame() {
		
		while (true) {
			//사용자 작업 선택
		String selection = selectMenu();
		
		System.out.println();
		if(selection.equals("1")) {
			startGame();
		
		}else if(selection.equals("2")) {
			System.out.println("프로그램 종료");
			break;
		}else {
			System.out.println("지원하지 않는 기능입니다.");
		}
		System.out.println();
	}
	}
	private void startGame() {
		// 컴퓨터 번호 뽑기
		int[] comNumbers = selectComNumbers();
		//System.out.println("" + comNumbers[0] + comNumbers[1] + comNumbers[2]); //test
		boolean win = false;
		for (int i =0; i < 10; i++) { // 10회 반복
			// 사용자 번호 입력
		int[] userNumbers = selectUserNumbers();
		// 사용자 번호와 컴퓨터 번호 비교
		int[] result = compareDate(comNumbers, userNumbers);
		//결과 출력
		System.out.printf("ROUND %2d : [Strike : %d][Ball : %d][Out : %d]\n",
		                   i+1,result[0], result[1], result[2]);
		// 승리 조건 검사 및 처리
		if(result[0] == 3) {
			win = true;
			break;
		  }
        }
		// 승패 출력
		if(win) {
			System.out.println("축하합니다. 이겼습니다.");
		} else {
			System.out.println(" 졌습니다... ");
		}
	}	
	 private int[] compareDate(int[] comNumbers, int[] userNumbers) {
		int strike = 0, ball = 0, out = 0;
		for(int i = 0; i <comNumbers.length; i++) {
			for (int j = 0; j <userNumbers.length; j++) {
				if(i == j && comNumbers[i] == userNumbers[j]) {
					strike++;
				} else if (i != j && comNumbers[i] == userNumbers[j]) {
					ball++;
				} 
					
				
			}
		}
		out = 3 - (strike + ball);
//		int [] ar1 = new int[3];
//		ar1[0] = 1; ar1[1] =2; ar1[2] = 3;
//		int[] ar2 = new int[] {1, 2, 3}; // 배열 초기화
//		int [] ar3 = {1,2,3};           // 배열 초기화
		
		return new int[] { strike, ball, out}; // [strike][ball][out] 배열 반환
}
	private int[] selectUserNumbers() {
		System.out.print("0 ~ 9 범위에서 숫자 세개 입력(ex : 1 7 6) : ");
		String input = scanner.nextLine(); // nextLine() : 공백을 포함해서 입력 (next() : 공백을 못 읽음
		input = input.trim();// 문자열 양쪽 끝에서 공백 제거
		String[] sNumbers = input.split(" ");// split : 주어진 문자를 기준으로 전체 문자열을 분해
		int[] numbers = new int[3];
		for (int i = 0; i < sNumbers.length; i++) {
			numbers[i] = Integer.parseInt(sNumbers[i]); // integer.parseInt : 문자열 -> 숫자
	   }
		return numbers;
	}

	private int[] selectUserNumbers2() {
		System.out.print("0 ~ 9 범위에서 숫자 세개 입력(ex : 176) : ");
		String input = scanner.nextLine(); // nextLine() : 공백을 포함해서 입력 (next() : 공백을 못 읽음
		input = input.trim();// 문자열 양쪽 끝에서 공백 제거
		int[] numbers = new int[3];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(input.charAt(i) + ""); // integer.parseInt : 문자열 -> 숫자
	   }
		return numbers;
	}
	
	private int[] selectComNumbers() {
		int[] comNumbers = new int[3];
		for(int i =0; i < comNumbers.length; i++) {
			comNumbers[i] = (int)(Math.random() *10);
			for(int j =0; j <i; j++) {
				if(comNumbers[i] == comNumbers[j]) {
					i--;
					break;
				}
			}
		}
		return comNumbers;
	}

	private String selectMenu() {
		System.out.println("------------------------");
		System.out.println("- 1. 게임 시작           -");
		System.out.println("- 2. 종료      ----------");
		System.out.println("------------------------");
		String selection = scanner.nextLine();
		return selection;
	}
	
	public static void main(String[] args) {
		Ex03BasebollGame game = new Ex03BasebollGame();
		game.doGame();
	}
}
