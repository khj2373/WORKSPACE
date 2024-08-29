package test01.test240703;

import java.util.Scanner;

public class T_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] str = {"국어", "영어", "수학"};
		int[] grade = new int[3];
		float sum = 0;
		
		for(int i = 0; i < str.length; i++) {
			System.out.print(str[i]+"점수 : ");
			grade[i] = sc.nextInt();
			sum += grade[i];
			
		}
		
		for(int i = 0; i < str.length; i++) {
			System.out.println(str[i] + " : " + grade[i]);
		}
		
		System.out.println("합계 : " + (int)sum);
		System.out.println("평균 : " + sum/str.length);
		
		if(grade[0] >= 40 && grade[1] >= 40 && grade[2] >= 40 && (sum/str.length) >= 60) {
			System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.println("불학격입니다.");
		}
		
		sc.close();

	}

}
