package test03.test240705;

import java.util.Scanner;

public class T_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("주민번호를 입력하세요(- 포함) : ");
		String joomin = sc.next();

		System.out.println();

		if (joomin.charAt(7) == '1' || joomin.charAt(7) == '3') {
			System.out.println("남자");
		} else if (joomin.charAt(7) == '2' || joomin.charAt(7) == '4') {
			System.out.println("여자");
		} else {
			System.out.println("잘못입력하셨습니다.");
		}

		sc.close();

	}

}
