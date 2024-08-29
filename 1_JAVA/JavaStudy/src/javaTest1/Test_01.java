package javaTest1;

import java.util.Scanner;

public class Test_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("1~100사이 정수 입력 : ");
		int n = sc.nextInt();

		if (n < 1 || n > 100) {
			System.out.println("1~100사이 정수만 입력해주세요.");
		} else if (n % 2 == 0) {
			System.out.println("2의 배수입니다.");
		} else {
			System.out.println("2의 배수가 아닙니다.");
		}

		sc.close();

	}

}
