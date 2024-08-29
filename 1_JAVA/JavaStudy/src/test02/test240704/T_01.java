package test02.test240704;

import java.util.Scanner;

public class T_01 {

	public static void main(String[] args) {
		final String ID = "myId";
		final String PWD = "myPassword12";

		Scanner sc = new Scanner(System.in);

		System.out.print("아이디 : ");
		String id = sc.next();

		System.out.print("비밀번호 : ");
		String pwd = sc.next();

		if (ID.equals(id)) {
			if (PWD.equals(pwd)) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("비밀번호가 틀렸습니다");
			}
		} else {
			System.out.println("아이디가 틀렸습니다");
		}
	}
}
