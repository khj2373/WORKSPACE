package test240711.object2;

public class Run {

	public static void main(String[] args) {
		//다음과 같은 코드를 실행했을 때 예시와 같은 결과가 출력되도록 TV클래스를 작성하세요
		
		/*
		 * TV myTV = new TV("삼성", 2020, 65, 1000000);
		 * myTV.show();
		 * 
		 * 삼성에서 만든 2020년형 65인치 TV 가격 : 1000000
		 */
		
		TV myTV1 = new TV("삼성", 2020, 65, 1000000);
		//myTV1.show();
		TV myTV2 = new TV("LG", 2024, 85, 500000);
		//myTV2.show();
		
		/*
		 * one이라는 Human객체를 생성하고 해당 객체를 이용해서 myTV를 구매 가능한지 확인하는 코드를
		 * 작성하고자 한다
		 * 
		 * Human one = new Human("홍길동", 1000000)
		 * one.buy(myTV1);
		 * 
		 * 홍길동님 구매내역
		 * 삼성에서 만든 2020년형 65인치 TV 가격 : 1000000 ->돈 차감
		 * 남은잔액 : xxx
		 * 
		 * or
		 * 
		 * 홍길동님 잔액이 부족하여 구매하실 수 없습니다
		 */

		Human one = new Human("김현준", 1000000);
		one.buy(myTV1);
		
	}

}
