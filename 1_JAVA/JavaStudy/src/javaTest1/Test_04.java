package javaTest1;

import java.util.Scanner;

public class Test_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("1~9까지 정수 입력1 : ");
		int n1 = sc.nextInt();

		System.out.print("1~9까지 정수 입력2 : ");
		int n2 = sc.nextInt();

		if (n1 == 0 || n2 == 0) {
			System.out.println("1~9까지 정수만 입력해주세요");
		} else {
			System.out.println("합 : " + (n1 + n2));
			System.out.println("차 : " + (n1 - n2));
			System.out.println("곱 : " + (n1 * n2));
			System.out.println("나누기 : " + (n1 / n2));
		}

		sc.close();

	}

}
