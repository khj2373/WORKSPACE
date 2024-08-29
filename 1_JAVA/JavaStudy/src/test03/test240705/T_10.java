package test03.test240705;

import java.util.Scanner;

public class T_10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tf = 0;
		do {
			System.out.print("문자열 입력 : ");
			String str = sc.next();

			System.out.print("문자 입력 : ");
			String ch = sc.next();
			int sum = 0;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ch.charAt(0)) {
					sum += 1;
				}
			}
			System.out.println("포함된 갯수 : " + sum);

			while (true) {
				System.out.print("더 하시겠습니까?(Y/N) : ");
				String str2 = sc.next();
				if (str2.charAt(0) == 'y' || str2.charAt(0) == 'Y') {
					tf = 1;
					break;
				} else if (str2.charAt(0) == 'n' || str2.charAt(0) == 'N') {
					tf = 0;
					break;

				} else {
					System.out.println("잘못입력했습니다.");
				}
			}
		} while (tf != 0);
		
		sc.close();
	}

}
