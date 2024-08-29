package test03.test240705;

import java.util.Scanner;


public class T_12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] gameArr = { "가위", "바위", "보" };
		System.out.print("당신의 이름을 입력해주세요. : ");
		String name = sc.next();
		int win = 0, draw = 0, lose = 0;

		while (true) {
			System.out.print("가위바위보 : ");
			String user = sc.next();
			if (user.equals("exit")) {
				System.out.printf("%d전 %d승 %d무 %d패", (win + draw + lose), win, draw, lose);
				break;
			}

			String com = gameArr[(int) (Math.random() * 3)];

			System.out.println(name + " : " + user);
			System.out.println("com" + " : " + com);
			if (user.equals(com)) {
				System.out.println("비겼습니다.");
				draw++;
			} else if (user.equals("가위") && com.equals("보") || user.equals("바위") && com.equals("가위")
					|| user.equals("보") && com.equals("바위")) {
				System.out.println("이겼습니다");
				win++;
			} else {
				System.out.println("졌습니다");
				lose++;
			}
		}
		sc.close();
	}

}
