package groupPro01_v2;

import java.util.Arrays;

public class Analyzer_v2 {
	// 필드

	// 메소드

	// 날짜 출력 및 총 지출 건수 출력
	// 입력 : 날짜, 총 지출건수
	// 출력 : 첫 줄: 일자 : < 날짜 > 소비분석
	int[] catArray = new int[MAX_ENTRY]; 	//카테고리 배열
	int[] priceArray = new int[MAX_ENTRY];	//금액 배열
	for (int i = 0; i < MAX_ENTRY; i++) {
		catArray[i] = spendings[i][0];		//전체 지출목록에서 카테고리 저장
		priceArray[i] = spendings[i][1];		//전체 지출목록에서 전체금액 저장
	}

	// 총금액
	// 입력 : 총 건수, 2차원 배열 저장한 지출 내역
	// 리턴 값 : 총 금액
	int totalSending(int entry, int[][] spendings) {
		int[] priceArray = new int[entry];	//금액 배열
		for (int i = 0; i < entry; i++) {
			priceArray[i] = spendings[i][1];		//전체 지출목록에서 전체금액 저장
		}
		
		// 총 지출금액 연산
		int totalSpending = 0;					//전체 지출금액을 합할 값이 들어갈 변수
		for (int price : priceArray) {
			totalSpending += price;
		}
		
		return totalSpending;
	}

	// 예산초과여부 출력
	// 입력 : 지출 금액, 예산
	// 출력 : 총 지출 금액과 예산을 비교했을때 금액

	// 소비패턴분석(제일 많이 소비한 카테고리, 가장 빈번하게 지출한 카테고리)
	// 입력 : 지출 내역 2차원 배열
	// 출력 : 카테고리별 금액 출력, 제일 많이 소비한 카테고리 및 비율, 가장 빈번하게 지출한 카테고리
void consumAnalyzer(int entry, int[][] spendings) {
		
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
		
	// 전체소비내역 출력
	// 입력 : 총 지출내역 수, 지출 내역 2차원 배열
	// 출력 : 각 지출내역 (카테고리 : 금액)
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
