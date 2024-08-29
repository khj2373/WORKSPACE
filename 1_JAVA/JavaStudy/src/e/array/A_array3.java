package e.array;

import java.util.Scanner;
import java.lang.*;

public class A_array3 {

	public static void main(String[] args) {
		//1. 크기가 10인 정수형 배열 생성 후
		
		int[] arr = new int[10];
		
		//2. 반복문을 통해서 0번 인덱스부터 마지막 인덱스까지 모든 값을 1로 초기화
		
		//3. 반복문을 통해서 0~마지막 인덱스까지 전부 출력
		
//		for(int i=0; i<arr.length; i++) {
//			arr[i] = 1;
//			System.out.println("arr["+i+"] = " + arr[i]);
//		}
		
		//4. 사용자에게 배열의 길이를 입력받아 해당 크기의 문자열 배열을 생성해라.
		//길이 입력 : x
		
		Scanner sc = new Scanner(System.in);
//		System.out.print("길이 입력 : ");
//		int size = sc.nextInt();
//		String[] strArr = new String[size];
		
		//5. 반복물을 활용해서 매번 사용자에게 과일명을 입력받아 그 값을 strArr에 대입(0~마지막 인덱스)
		//좋아하는 과일을 입력 : 바나나(반복)
		
//		for(int i=0; i < strArr.length; i++) {
//			System.out.print("좋아하는 과일을 입력 : ");
//			strArr[i] = sc.next();
//		}
//		
//		//6. 반복문을 이용해서 strArr에 있는 모든 값을 출력
//		
//		for(int i=0; i < strArr.length; i++) {
//			System.out.print(strArr[i] + " ");
//		}
		
		//사용자에게 문자열 하나 입력받은 후
		//각각의 인덱스에 있는 문자들을 char배열에 옮겨담기
		
		//1. 사용자에게 문자열 입력받은 후
		
		//2. char배열 생성하기(길이 == 문자열의 길이)
		
		//3. 반복문을 통해서 해당 문자열에서 각각 인덱스별 문자를 char배열에 각 인덱스 값에 대입
		
		//4. char배열의 모든 index 값을 전체 출력
		
//		System.out.print("문자열 입력 : ");
//		String str = sc.next();
//		char[] chArr = new char[str.length()];
//		
//		for(int i=0; i < str.length(); i++) {
//			chArr[i] = str.charAt(i);
//			System.out.println("index " + i + " = " + chArr[i]);
//		}
		
		//사용자에게 배열의 길이를 입력받아 해당 길이의 정수형 배열 arr을 생성한다
		//arr에 모든 인덱스 값에 1~100사이의 랜덤값을 할당해 주고
		//arr에 모든 값을 출력한 후
		//이 중 짝수의 값의 총 합을 구해라
		
		System.out.print("정수입력 : ");
		int[] nArr = new int[sc.nextInt()];
		for(int i=0; i<nArr.length; i++) {
			nArr[i] = (int)(Math.random() * 100) + 1;
			System.out.print(nArr[i] + " ");
		}
		int sum = 0;
		for(int i=0; i < nArr.length; i++) {
			if(nArr[i] % 2 == 0) {
				sum += nArr[i];
			}
		}
		
		System.out.println("\n짝수의 총 합 : " + sum);
		
		sc.close();

	}

}
