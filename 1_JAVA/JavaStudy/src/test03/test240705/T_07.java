package test03.test240705;

import java.util.Scanner;

public class T_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("첫 번째 숫자 : ");
		int n1 = sc.nextInt();

		System.out.print("두 번째 숫자 : ");
		int n2 = sc.nextInt();

		if (n1 < 1 || n2 < 1) {
			System.out.println("1이상의 숫자를 입력해주세요");

			System.out.print("첫 번째 숫자 : ");
			n1 = sc.nextInt();

			System.out.print("두 번째 숫자 : ");
			n2 = sc.nextInt();
		}

		int max = n1 > n2 ? n1 : n2;
		int min = n1 < n2 ? n1 : n2;

		for (int i = min; i <= max; i++) {
			System.out.print(i + " ");
		}

		sc.close();

	}

}
