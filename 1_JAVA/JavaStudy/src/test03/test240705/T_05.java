package test03.test240705;

import java.util.Scanner;

public class T_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("키(m)를 입력해주세요 : ");
		double h = sc.nextDouble();

		System.out.print("몸무게(kg)를 입력해주세요 : ");
		double w = sc.nextDouble();

		double bmi = w / (h * h);
		System.out.println("BMI지수 : " + bmi);

		if (bmi < 18.5) {
			System.out.println("저체중");
		} else if (bmi < 23) {
			System.out.println("정상체중");
		} else if (bmi < 25) {
			System.out.println("과체중");
		} else if (bmi < 30) {
			System.out.println("비만");
		} else {
			System.out.println("고도비만");
		}

	}

}
