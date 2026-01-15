package groupPro01_v2;

import java.util.Scanner;

public class AnalyzerMain {
	public static void main(String[] args) {
		// 지출 내역 입력을 위한 기능

		// 최대 입력 갯수 상수로 선언 (30)
		final int MAX_ENTRY = 30;
		// 소비 내역을 저장할 2차원 정수형 배열 선언
		int[][] spendings = new int[MAX_ENTRY][2];
		// 입력 클래스 import
		Scanner sc = new Scanner(System.in);
		// 입력된 값을 추적하기 위해 변수 선언
		int entryCount = 0;
		System.out.print("날짜 입력 (YYYY-MM-DD) : ");
		String date = sc.next();
		System.out.print("예산 입력 : ");
		// 입력된 예산을 정수형 변수에 저장
		int budget = sc.nextInt();
		// 입력 완료 여부 확인을 위한 논리형 변수 선언 및 false로 초기화
		boolean isDone = false;
		while (!isDone) { // isDone 값은 지출 내역 입력이 완료되는 순간 true로 바뀌어 while문을 탈출
			if (entryCount >= MAX_ENTRY) {
				break; // 최대 지출 내역 입력 수를 넘는 순간 입력 종료
			}
			if (entryCount > 0) { // 처음 입력하는 경우가 아닌 경우
				System.out.print("추가로 입력하시겠습니까? (1: YES, 2: NO) : ");
			} else { // 처음 입력하는 경우
				System.out.print("메뉴 선택 (1:소비내역 입력, 2:프로그램 종료 및 분석) : ");
			}
			int option = sc.nextInt(); // 메뉴 선택을 위한 변수
			switch (option) { // 1번: 입력, 2번: 입력 종료
			case 1: // 1번: 입력
				System.out.print("카테고리 입력 (1:식비, 2:교통, 3:쇼핑, 4:기타) : ");
				spendings[entryCount][0] = sc.nextInt();
				System.out.print("금액 입력 : ");
				spendings[entryCount][1] = sc.nextInt();
				entryCount++;
				break;
			case 2: // 2번: 입력 종료 메시지 후 입력 종료 (isDone 값을 true로 변경한 후 while문 탈출)
				System.out.println("입력을 종료하고 분석을 시작합니다.");
				isDone = true;
				break;
			default: // 기본 옵션, 1번과 2번이 아닌 경우 오류 메시지 출력
				System.out.println("잘 못 입력하였습니다.");
			}
		}
		
        Analyzer_v2 analyzer = new Analyzer_v2(entryCount, spendings);
        int totalSpending = analyzer.plusTotalSpending();

        System.out.println("총 지출 금액 : " + totalSpending);
	}
}
