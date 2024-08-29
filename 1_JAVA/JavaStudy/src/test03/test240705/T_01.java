package test03.test240705;

import java.util.Scanner;

public class T_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("국어 : ");
		float n1 = sc.nextFloat();

		System.out.print("영어 : ");
		float n2 = sc.nextFloat();

		System.out.print("수학 : ");
		float n3 = sc.nextFloat();

		int sum = (int) (n1 + n2 + n3);
		int grade = (sum / 3);

		System.out.println();
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + grade);

		sc.close();

	}

}
