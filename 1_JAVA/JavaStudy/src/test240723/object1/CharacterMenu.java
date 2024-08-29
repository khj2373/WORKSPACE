package test240723.object1;

import java.util.Scanner;

public class CharacterMenu {
	private Scanner sc = new Scanner(System.in);
	private CharacterController cc = new CharacterController();
	
	public void menu() {
		
		
		try {
			System.out.print("문자열 : ");
			String str = sc.nextLine();
			
			int count = cc.couponAlpha(str);
			System.out.println(str + "에 포함된 영문자 개수 : " + count);
		} catch(CharCheckException e){
			System.out.println("문자열에 공백이 포함되어 있습니다");
			e.printStackTrace();
		} finally {
			sc.close();
			System.out.println("프로그램 종료.");
		}
		
	}

}
