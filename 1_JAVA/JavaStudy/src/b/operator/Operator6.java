package b.operator;

import java.util.Scanner;

public class Operator6 {
	/*
	 * 삼항연산자
	 * [표현식]
	 * 조건식 ? 조건식이 참일경우 결과값 : 조건식이 거짓일 경우 결과값
	 * 
	 * 이때, 조건식은 반드시 true 또는 false에 나오는 논리값이어야 한다
	 * 주로 비교, 논리연산자를 통해서 작성
	 */

	public static void main(String[] args) {
//		int num = (3 < 10) ? 10 : 20;
//		System.out.println(num);
		
		//입력받은 정수값이 양수인지 아닌지 판별 후 출력해라
		//정수값 입력 :
		//양수/음수
		Scanner sc = new Scanner(System.in);
		
		int num1;
		
		System.out.print("정수 하나 입력 : ");
		num1 =sc.nextInt();
		
		String str = (num1 > 0) ? "양수" : "음수";
		System.out.println(str);
		
//		if(num1 > 0) {
//			str = "양수";
//		} else if(num1 == 0){
//			str = "0";
//		} else {
//			str = "음수";
//		}

	}

}
