package a.basic;
import java.util.Scanner;
public class Practice3 {
	/*
	 * 문자열 => 객체(기능들이 있다.)
	 * ex) 문자열 비교시 -> 문자열.equals(비교문자열)
	 * 
	 * 문자열.charAt(index) : 문자열에서 내가 원하는 index의 글자를 가져온다.
	 * index: 숫자를 지정할 때 사용하는 것
	 * 
	 * 영어 단어를 키보드로 입력받아 단어의 앞에서부터 3개를 출력하세요.
	 * ex) apple -> app
	 * 
	 * 단어를 입력하세요 : (키보드입력)
	 * 첫 번째 문자 : a
	 * 두 번째 문자 : p
	 * 세 번째 문자 : p
	 */

	public static void main(String[] args) {
//		String str1 = "Hyunjun";
//		char ch1 = str1.charAt(3);
//		System.out.println(ch1);
		
		Scanner sc = new Scanner(System.in);
		String str1;
		
		System.out.print("단어 입력 : ");
		str1 = sc.nextLine();
		
		System.out.println("첫 번째 문자 : " + str1.charAt(0));
		System.out.println("첫 번째 문자 : " + str1.charAt(1));
		System.out.println("첫 번째 문자 : " + str1.charAt(2));

	}

}
