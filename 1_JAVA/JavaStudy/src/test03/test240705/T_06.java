package test03.test240705;

import java.util.Scanner;

public class T_06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간고사 점수 : ");
		double n1 = sc.nextDouble();
		
		System.out.print("기말고사 점수 : ");
		double n2 = sc.nextDouble();
		
		System.out.print("과제 점수 : ");
		double n3 = sc.nextDouble();
		
		System.out.print("출석 횟수 : ");
		double n4 = sc.nextDouble();
		
		double rs = n1*0.2 + n2*0.3 + n3*0.3 + n4;
		
		System.out.println("==============결과==============");
		
		System.out.println("중간고사 점수(20) : " + n1);
		System.out.println("기말고사 점수(30) : " + n2);
		System.out.println("과제 점수(30) : " + n3);
		System.out.println("출석 점수(20) : " + n4);
		System.out.println("총점 : " + rs);
		
		if(n4 <= 14) {
			System.out.println("Fail [출석미달]");
		} else if(rs >= 70) {
			System.out.println("pass");
		} else {
			System.out.println("Fail [점수미달]");
		}
		
		sc.close();

	}

}
