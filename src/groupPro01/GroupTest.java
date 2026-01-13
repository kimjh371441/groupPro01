package groupPro01;



	import java.util.Arrays;
import java.util.Scanner;

	public class GroupTest {
		public static void main(String[] args) {
//			송민진 시작
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
					System.out.print("추가로 입력하시겠습니까? (YES: 1, NO: 2) :");
				} else { // 처음 입력하는 경우
					System.out.print("메뉴 선택 (1. 소비내역 입력, 2. 프로그램 종료 및 분석) : ");
				}
				int option = sc.nextInt(); // 메뉴 선택을 위한 변수
				switch(option) { // 1번: 입력, 2번: 입력 종료
				case 1: // 1번: 입력
					System.out.print("카테고리 입력 (1.식비, 2.교통, 3.쇼핑, 4.기타) : ");
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
//			송민진 수정 끝
			
			
			// 여기선 수정
			// 날짜, 카테고리, 금액 배열 선언
			
			int[] catArray = new int[MAX_ENTRY];
			int[] priceArray = new int[MAX_ENTRY];
			for (int i = 0; i < MAX_ENTRY; i++) {
				catArray[i] = spendings[i][0];
				priceArray[i] = spendings[i][1];
			}
			// 날짜, 카테고리, 금액 배열 출력
			System.out.println("카테고리\n" + Arrays.toString(catArray));
			System.out.println("금액\n" + Arrays.toString(priceArray));
			
			// 총 지출금액 연산
			int totalSpending = 0;
			for (int price : priceArray) {
				totalSpending += price;
			}
			
			// 카테고리별 총 금액 연산
			int cat1Spending = 0;
			int cat2Spending = 0;
			int cat3Spending = 0;
			int cat4Spending = 0;
			//성인수정
			int[] numcount = new int[4]; //입력하는 숫자 받을 배열
			int highindex = 0; //인덱스 번호 받을 배열
			int bcount = numcount[0]; // 입력 많은 높은숫자 받을 변수
			//성인수정
			for (int[] spending : spendings) {
				switch(spending[0]) {
				case 1:
					cat1Spending += spending[1];
					numcount[0]++;//성인추가
					break;
				case 2:
					cat2Spending += spending[1];
					numcount[1]++;//성인추가
					break;
				case 3:
					cat3Spending += spending[1];
					numcount[2]++;//성인추가
					break;
				case 4:
					cat4Spending += spending[1];
					numcount[3]++;//성인추가
					break;
				default:
					break;
				}
			}
			
			// 받은 배열에서 받은 숫자중 높은 숫자 입력 받은 배열 
			// 입력 받은 숫자 -성인추가
			
			for(int i=0; i < numcount.length; i++) {
				if (numcount[i] > bcount) {
					bcount = numcount[i];
					highindex=i+1;
				}
			}
			
			// 총 지출금액 출력
			System.out.println("총 지출금액 : " + totalSpending);
			
			// 카테고리별 총 지출금액
			System.out.println("식비 지출금액 : " + cat1Spending);
			System.out.println("교통 지출금액 : " + cat2Spending);
			System.out.println("쇼핑 지출금액 : " + cat3Spending);
			System.out.println("기타 지출금액 : " + cat4Spending);
			
			//소비횟수와 소비한 카테고리 숫자 -성인추가 
			System.out.println("자주 소비하는곳은 " + highindex + "입니다. 총"+ bcount +"번 소비 하였습니다");

			
			// 저장된 지출 내역 출력
//			System.out.println("지출내역\n" + Arrays.deepToString(spendings));
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
				System.out.printf("%d. \t카테고리 : %s\t 금액 : %d\n", i + 1, categoryName, spendings[i][1]);
			}
			String spendMsg = (budget < totalSpending) ? (int) (totalSpending - budget) + "원 초과" : (int) (budget - totalSpending) + "원 절약";
			System.out.print("예산 : " + budget + "원, 총 지출금액 : " + totalSpending + "원\n");
			System.out.print(spendMsg);
			
			
			sc.close();
			
			
			
			
		}
	}

