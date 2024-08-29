package test240711.object1;

import java.util.Scanner;

public class T_01 {

	public static void main(String[] args) {
		// 정수 n(2~9)를 입력받아 2부터 n까지 중 짝수 구구단을 출력하는 코드를 작성하세요
		// 만약 2~9사이의 값을 입력하지 않는다면 다시 입력하세요를 반복합니다
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while (true) {
			System.out.print("2~9까지 입력 : ");
			 num = sc.nextInt();

			if (num < 2 || num > 9) {
				System.out.println("다시 입력하세요");
				continue;
			} else if (num <= 2) {
				num = 2;
				break;
			} else if (num <= 4) {
				num = 4;
				break;
			} else if (num <= 6) {
				num = 6;
				break;
			} else {
				num = 8;
				break;
			}
		}
		
		for (int i = num; i <= 9; i += 2) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			}
			System.out.println();
		}
		
		sc.close();

	}

}
