package test02.test240704;

import java.util.Scanner;

public class T_08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] day = {"일","월","화","수","목","금","토"};
		
		System.out.print("0~6 사이의 숫자 입력 : ");
		int n = sc.nextInt();
		
		for(int i=0; i < day.length; i++) {
			if(i == n && n >= 0 && n <= 6) {
				System.out.println(day[i]+"요일");
				break;
			} else if(i != n && n >= 0 && n <= 6) {
				
			} else {
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}

	}

}
