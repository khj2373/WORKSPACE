package test02.test240704;

import java.util.Scanner;

public class T_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 : ");
		int n = sc.nextInt();

//		System.out.println("==== " + n + "단 ====");
//		for(int i = 1; i <= 9; i++) {
//			System.out.println(n + " * " + i + " = " + (n * i));
//		}
		if (n <= 9) {
			for (int i = n; i <= 9; i++) {
				System.out.println("==== " + i + "단 ====");
				for (int j = 1; j <= 9; j++) {
					System.out.println(i + " * " + j + " = " + (i * j));
				}
			}
		} else {
			System.out.println("9이하의 숫자만 입력해주세요.");
		}

	}

}
