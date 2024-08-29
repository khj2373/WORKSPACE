package test240715.object1;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.print("입력 : ");
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();
//		int num3 = sc.nextInt();
//		
//		if(num1 % 2 == 0) {
//			System.out.print("짝 ");
//		} else {
//			System.out.print("홀 ");
//		}
//		
//		if(num2 % 2 == 0) {
//			System.out.print("짝 ");
//		} else {
//			System.out.print("홀 ");
//		}
//		
//		if(num3 % 2 == 0) {
//			System.out.print("짝 ");
//		} else {
//			System.out.print("홀 ");
//		}
		
		
//		System.out.print("입력 : ");
//		int num = sc.nextInt();
//		
//		for(int i = 0; i <= num; i++) {
//			System.out.print(i + " ");
//		}
		
		
//		int[] num = new int[20];
//		System.out.print("입력 : ");
//		for(int i = 0; i < num.length; i++) {
//			num[i] = sc.nextInt();
//		}
//		System.out.print("입력횟수 : ");
//		int count = 0;
//		for(int i = 1; i <= num.length; i++) {
//			for(int j = 0; j < num.length; j++) {
//				if(num[j] == i) {
//					count++;
//				}
//			}
//			System.out.print(count + " ");
//			count = 0;
//		}
		
		Student[] s = {
				new Student("학생1", 1, 0, 0, 0),
				new Student("학생2", 2, 0, 0, 0),
				new Student("학생3", 3, 0, 0, 0),
				new Student("학생4", 4, 0, 0, 0),
				new Student("학생5", 5, 0, 0, 0),
		};
		
		for(int i = 0; i < s.length; i++) {
			s[i].reTest();
			System.out.print(s[i].toString() + " ");
			if(s[i].isPassd()) {
				System.out.println("합격");
			} else {
				System.out.println("탈락");
			}
		}
		

	}

}
