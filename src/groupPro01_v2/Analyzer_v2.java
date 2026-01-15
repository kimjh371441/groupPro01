package groupPro01_v2;

import java.util.Arrays;

public class Analyzer_v2 {
	// 필드

	// 메소드

	// 날짜 출력 및 총 지출 건수 출력
	// 입력 : 날짜, 총 지출건수
	// 출력 : 첫 줄: 일자 : < 날짜 > 소비분석

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
		System.out.println("소비항목 중 가장 많은 금액을 지출한 항목은 "+bestCat+"이고, 전체 지출의 약"
		+(int)((double)max[3]/this.totalSending(entry,spendings)*100)+"%를 차지합니다");
		System.out.println();
	}

	// 전체소비내역 출력
	// 입력 : 총 지출내역 수, 지출 내역 2차원 배열
	// 출력 : 각 지출내역 (카테고리 : 금액)

}
