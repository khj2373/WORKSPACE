package test02.test240704;

import java.util.Scanner;

public class T_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int n1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int n2 = sc.nextInt();
		
		if(n1 < n2 && n1 >= 1 && n2 >= 1) {
			for(int i = n1; i <= n2; i++) {
				System.out.print(i + " ");
			}
		} else if (n1 > n2 && n1 >= 1 && n2 >= 1) {
			for(int i = n2; i <= n1; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1이상의 숫자를 입력해주세요.");
		}

	}

}
