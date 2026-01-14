package groupPro01;

import java.util.Scanner;
import java.util.Arrays;

public class Analyzer {
	public static void main(String[] args) {
//		B. 용돈관리 & 소비 패턴 분석      : 1팀, 3팀
//		   사용자가 일정기간동안의 지출을 입력하면 지출 내역을 배열에 저장하고 종료 시 소비 패턴을 분석하는 프로그램
//
//		- 기능 요구사항
//		   지출입력 : 날짜 또는 순서 입력, 지출 항목 입력(식비/교통/쇼핑/기타), 지출 금액 입력
//		   지출할 때마다 배열에 저장 : 날짜 또는 순서 입력, 항목, 금액
//		   [분석 조건]
//		   아래 조건 중 최소 2개 이상 구현
//		  ** - 총 지출 금액
//		  ** - 항목별 지출 합계
//		  ** - 특정 항목이 전체의 일정 비율 이상일 경우 경고메시지
//		     - 지출 금액이 연속으로 증가하는 패턴 감지
//		  ** - 예산 초과 여부 판단
//
//		   종료 후 결과 출력 : 총 지출, 가장 많이 사용한 항목, 소비 습관 판단 메시지
//
//		- 공통 필수 규칙
//		   배열 최소 2개 이상 사용
//		   팀원 전원 코드 작성 필수
//		   각 코드 영역에 담당자 이름, 기능 주석 필수
//		   본인 영역 외에 수정 하면 안됨
//		   실행되지 않으면 안됨
		
//		1. 전체 입력 기능  - 민진
//		2. 카테고리별 총 금액 및 출력(항목별 지출 합계) - 철민
//		3. 총 지출비용 계산 및 출력(+예산 초과 여부 판단) - 진경
//		4. 소비패턴 분석1 : 횟수의 따른 분석 및 출력 - 성인
//		5. 소비패턴 분석2 : 금액의 따른 분석 및 출력 - 재형
		
		// 송민진 시작
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
			switch(option) { // 1번: 입력, 2번: 입력 종료
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
//		송민진 수정 끝
	
//		윤철민 시작
		
		// 날짜, 카테고리, 금액 배열 선언
		int[] catArray = new int[MAX_ENTRY]; 	//카테고리 배열
		int[] priceArray = new int[MAX_ENTRY];	//금액 배열
		for (int i = 0; i < MAX_ENTRY; i++) {
			catArray[i] = spendings[i][0];		//전체 지출목록에서 카테고리 저장
			priceArray[i] = spendings[i][1];		//전체 지출목록에서 전체금액 저장
		}
		
		// 총 지출금액 연산
		int totalSpending = 0;					//전체 지출금액을 합할 값이 들어갈 변수
		for (int price : priceArray) {
			totalSpending += price;
		}
		
		// 카테고리별 총 금액 연산
		int cat1Spending = 0;	//카테고리1의 총 지출
		int cat2Spending = 0;	//카테고리2의 총 지출
		int cat3Spending = 0;	//카테고리3의 총 지출
		int cat4Spending = 0;	//카테고리4의 총 지출
		
		//성인수정
		int[] numCount = new int[4]; 	//입력하는 숫자 받을 배열
		int highindex = 0; 				//인덱스 번호 받을 배열
		int bcount = numCount[0]; 		// 입력 많은 높은숫자 받을 변수
		//성인수정
		for (int[] spending : spendings) {
			switch(spending[0]) {
			case 1:
				cat1Spending += spending[1];
				numCount[0]++;//성인추가
				break;
			case 2:
				cat2Spending += spending[1];
				numCount[1]++;//성인추가
				break;
			case 3:
				cat3Spending += spending[1];
				numCount[2]++;//성인추가
				break;
			case 4:
				cat4Spending += spending[1];
				numCount[3]++;//성인추가
				break;
			default:
				break;
			}
		}

		// 받은 배열에서 받은 숫자중 높은 숫자 입력 받은 배열 
		// 입력 받은 숫자 -성인추가
		for(int i=0; i < numCount.length; i++) {
			if (numCount[i] > bcount) {
				bcount = numCount[i];
				highindex=i+1;
			}
		}
		//가장 자주 지출한 항목 구하기
		String cat = "";		//가장 자주 지줄한 항목 저장 변수
		switch(highindex) {
		case 1 -> cat = "식비";
		case 2 -> cat = "교통";
		case 3 -> cat = "쇼핑";
		case 4 -> cat = "기타";
		default -> cat = "";
		}
		//=======결과 출력=======
		System.out.println("\n일자 : <"+date+"> 소비분석");
		
		// 총 지출금액 출력
		System.out.println("총 지출 "+entryCount+"건, 총 지출금액 : " + totalSpending);
		System.out.println();
		
		// 카테고리별 총 지출금액
		System.out.println("식비 지출금액 : " + cat1Spending);
		System.out.println("교통 지출금액 : " + cat2Spending);
		System.out.println("쇼핑 지출금액 : " + cat3Spending);
		System.out.println("기타 지출금액 : " + cat4Spending);
		System.out.println();
		
		//소비횟수와 소비한 카테고리 숫자 -성인추가 
		System.out.println("자주 소비하는곳은 " + cat + "입니다. 총"+ bcount +"번 소비 하였습니다");
		//소비항목 중 가장 많은 금액인 항목과 금액 출력
		int[] max = {cat1Spending, cat2Spending, cat3Spending, cat4Spending};
		//작은 금액부터 큰 금액으로 정렬
		Arrays.sort(max);
		//가장 많은 금액을 사용한 소비항목을 담을 변수
		String bestCat = "";
		if(max[3]==cat1Spending) {
			bestCat = "식비";
		}else if(max[3]==cat2Spending) {
			bestCat = "교통";
		}else if(max[3]==cat3Spending) {
			bestCat = "쇼핑";
		}else if(max[3]==cat4Spending) {
			bestCat = "기타";
		}
		//가장 많은 금액을 사용한 소비항목 출력
		System.out.println("소비항목 중 가장 많은 금액을 지출한 항목은 "+bestCat+"이고, 전체 지출의 약"+(int)((double)max[3]/totalSpending*100)+"%를 차지합니다");
		System.out.println();
		
		String spendMsg = (budget < totalSpending) ? (int) (totalSpending - budget) + "원 초과하셨습니다" : (int) (budget - totalSpending) + "원 절약하셨습니다";
		System.out.print("[예산금액 : " + budget + "원, 총 지출금액 : " + totalSpending + "원]\n");
		System.out.print("→ 예상금액에서 "+spendMsg);
		System.out.println();
		
		// 저장된 지출 내역 출력
//		System.out.println("지출내역\n" + Arrays.deepToString(spendings));
		System.out.println();
		System.out.println("=====전체 지출 내역=====");
		for (int i = 0; i < entryCount; i++) {
			String categoryName = "";
			switch(spendings[i][0]) {
			case 1:
				categoryName = "식비";
				break;
			case 2:
				categoryName = "교통";
				break;
			case 3:
				categoryName = "쇼핑";
				break;
			case 4:
				categoryName = "기타";
				break;
			default: 
				categoryName = "기타";
				break;
			}
			System.out.printf("%d.%s : %d\n", i + 1, categoryName, spendings[i][1]);
		}
		sc.close();
	}
}