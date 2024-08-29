package test03.test240705;

import java.util.Scanner;

public class T_08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.print("연산자(+, -, *, /, %) : ");
			String str = sc.next();

			System.out.print("정수1 : ");
			int n1 = sc.nextInt();

			System.out.print("정수2 : ");
			int n2 = sc.nextInt();

			switch (str.charAt(0)) {
			case '+':
				System.out.println(n1 + "+" + n2 + "=" + (n1 + n2));
				break;
			case '-':
				System.out.println(n1 + "-" + n2 + "=" + (n1 - n2));
				break;
			case '*':
				System.out.println(n1 + "*" + n2 + "=" + (n1 * n2));
				break;
			case '/':
				if (n1 == 0 || n2 == 0) {
					System.out.println("0으로는 나눌 수 없습니다.");
				} else {
					System.out.println(n1 + "/" + n2 + "=" + (n1 / n2));
				}
				break;

			case '%':
				System.out.println(n1 + "%" + n2 + "=" + (n1 % n2));
				break;
			default:
				System.out.println("없는 연산자입니다. 다시 입력해주세요");
				break;
			}

		}

	}

}
