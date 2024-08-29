package test02.test240704;

import java.util.Scanner;

public class T_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 입력 : ");
		String str = sc.next();

		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);

		int sum = 0;
		System.out.print(str + "에 " + ch + "가 존재하는 위치 : ");
		for (int i = 0; i < str.length(); i++) {
			if (ch == str.charAt(i)) {
				System.out.print(i + " ");
				sum += 1;
			}
		}
		System.out.println();
		System.out.println(ch + "의 갯수 : " + sum);

	}

}
