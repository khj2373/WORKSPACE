package test02.test240704;

import java.util.Scanner;

public class T_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("권한을 확인하고자 하는 등급 : ");
		String rank = sc.next();
		String access="";
		
		switch(rank) {
		case "관리자" :
			access += "회원관리, 게시글 관리, ";
		case "회원" :
			access += "게시글 작성, 댓글작성, ";
		case "비회원" :
			access += "게시글 조회";
			break;
		default :
			System.out.println("잘못입력하셨습니다.");
			return;
		}
		System.out.println(access);
	}

}
