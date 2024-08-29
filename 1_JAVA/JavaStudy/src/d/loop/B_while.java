package d.loop;

import java.util.Scanner;
import java.lang.*;

public class B_while {
	/*
	 * while문
	 * 
	 * [표현법]
	 * 
	 * [초기식;]
	 * while(조건식){
	 * 		반복할 코드
	 * 		증감식;
	 * }
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		
//		for(int i=0; i < 5; i++) {
//			System.out.println("안녕하세요");
//		}
		
		//사용자가 0을 입력할 때까지 반복해서 숫자를 입력받아 그대로 출력해라
	
//		while(true) {
//			int n = sc.nextInt();
//			if(n == 0) {
//				break;
//			} else {
//				System.out.println(n);
//			}
//		}
		
		//1부터 10000사이의 홀수만을 출력
		//while문을 이용해서 하기
		
//		int i = 1;
//		while(i<=10000) {
//			System.out.print(i + " ");
//			i+=2;
//		}
		
		//1부터 랜덤값(1~100)까지의 합계를 출력
		
//		int num = (int)(Math.random() * 100) + 1;
//		int sum = 0;
//		int i = 1;
//		
//		while(i <= num) {
//			sum += i;
//			i++;
//		}
//		System.out.println("난수 :" + num);
//		System.out.println("1~난수까지의 합 : " + sum);
		
		//사용자에게 문자열을 입력받아서
		//해당 문자열의 짝수자리 글자만 출력한다

		System.out.print("문자열 입력 : ");
		String str = sc.next();
		
		int i = 1;
		while(i < str.length()) {
			System.out.print(str.charAt(i) + " ");
			i += 2;
		}
	}

}
