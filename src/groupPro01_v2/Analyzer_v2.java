package groupPro01_v2;

public class Analyzer_v2 {
/*	필드 
	총금액
	입력 : 총 건수, 2차원 배열 저장한 지출 내역
	리턴 값 : 총 금액			*/
	
	// 필드, catArray, priceArray
	int[] catArray;
	int[] priceArray;
	// total 메소드 선언
	// 반환값 int
	int total(int entryCount, int[][] spendings) {
	        // 필드 배열 초기화, new로 배열 공간 생
	        catArray = new int[entryCount];
	        priceArray = new int[entryCount];
	        // 데이터 저장, 2차원 배열 spendings를 catArray, priceArray로 나눠서 저장 
	        for (int i = 0; i < entryCount; i++) {
	            catArray[i] = spendings[i][0];
	            priceArray[i] = spendings[i][1];
	        }
	        // 총 지출 금액 계산
	        // priceArray에 있는 모든 지출 금액 합산
	        // total 변수에 저장 
	        int total = 0;
	        for (int price : priceArray) {
	            total += price;
	        }
	        // 총 지출 금액 출력
	        System.out.println("총 지출 금액은 " + total + "원 입니다.");
	        // 리턴값
	        // total 
	        return total;
			}
		
		}		
	
	
	
	
	
	
	
	


			

