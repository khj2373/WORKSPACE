package test03.test240705;

import java.util.Scanner;

public class T_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double[][] arr = new double[3][2];

		for (int i = 0; i < arr.length; i++) {
			System.out.print((char) (i + 65) + "사원의 연봉 : ");
			arr[i][0] = sc.nextDouble();
		}

//		System.out.print("A사원의 연봉 : ");
//		arr[0][0] = sc.nextDouble();
//
//		System.out.print("B사원의 연봉 : ");
//		arr[1][0] = sc.nextDouble();
//
//		System.out.print("C사원의 연봉 : ");
//		arr[2][0] = sc.nextDouble();

		arr[0][1] = 1.4;
		arr[1][1] = 1;
		arr[2][1] = 1.15;

		double money = 0;

		for (int i = 0; i < arr.length; i++) {
			money = arr[i][0] * arr[i][1];
			System.out.println((char) (i + 65) + "사원의 연봉/연봉+a : " + (int) arr[i][0] + "/" + money);
			if (money >= 3000) {
				System.out.println("3000이상");
			} else {
				System.out.println("3000미만");
			}
		}

		sc.close();

	}

}
