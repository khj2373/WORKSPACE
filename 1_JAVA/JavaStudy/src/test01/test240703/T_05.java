package test01.test240703;

import java.util.Scanner;

public class T_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 하나를 입력하세요 : ");
		int n = sc.nextInt();
		int sum = 0;

		for (int i = 1; i <= n; i++) {
			sum += i;

			if (i != n) {
				System.out.print(i + " + ");
			} else {
				System.out.print(i + " = " + sum);
			}

		}
	}

}
