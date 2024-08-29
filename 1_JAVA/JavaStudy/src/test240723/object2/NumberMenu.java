package test240723.object2;

import java.util.Scanner;

public class NumberMenu {

	public void menu() {
		int num1 = 0, num2 = 0;
		NumberController nc = new NumberController();
		Scanner sc = new Scanner(System.in);

		System.out.print("정수1 : ");
		num1 = sc.nextInt();

		System.out.print("정수2 : ");
		num2 = sc.nextInt();

		
		try {
			boolean rs = nc.checkDouble(num1, num2);
			System.out.println(num1 + "은(는) " + num2 + "의 배수인가? " + rs);
		} catch (NumRangeException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}
}
