package test03.test240705;

import java.util.Scanner;
import java.lang.*;

public class T_11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = (int)(Math.random()*100)+1;
		int sum = 1;
		//System.out.println(n);
		do {
			System.out.print("1~100 사이의 임의의 난수를 맞춰보세요");
			int rs = sc.nextInt();
			
			if(rs==n) {
				System.out.println("정답입니다!");
				System.out.println(sum + "회만에 맞추셨습니다.");
				n = 0;
			} else if(rs < 1 || rs > 100) {
				System.out.println("1~100사이의 수를 입력해주세요");
			} else if (rs < n){
				System.out.println("up!");
				sum+=1;
			} else {
				System.out.println("down!");
				sum+=1;
			}
		} while(n!=0);
		
		sc.close();

	}

}
