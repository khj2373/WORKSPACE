package javaTest1;

import java.util.Scanner;

public class Test_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("1~9까지 정수 입력 : ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		if (n1 < 1 || n1 > 9 && n2 < 1 || n2 > 9) {
			System.out.println("1~9까지 정수만 입력해주세요");
		} else if (n1 * n2 < 10) {
			System.out.println("한자리 수 입니다.");
		} else {
			System.out.println("두자리 수 입니다.");
		}

		sc.close();

	}

}
