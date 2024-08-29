package m.api.ex1;
import java.lang.*; //직접 import하지 않아도 무조건 import됨

public class A_math {
	//java.lang.Math
	//-모든 필드 상수필드, 모든 메소드 static메소드이다.
	public void method01() {
		//상수필드
		System.out.println("파이 : " + Math.PI);
		
		//난수
		System.out.println("랜덤(0~0.99) : " + Math.random());
		
		//절대값
		int num1 = -10;
		System.out.println("절대값 : " + Math.abs(num1));
		
		//올림
		double num2 = 4.449;
		System.out.println("올림 : " + Math.ceil(num2));
		
		//반올림
		System.out.println("반올림 : " + Math.round(num2));
		
		//버림
		System.out.println("버림 : " + Math.floor(num2));
		
		//제곱
		System.out.println("2의 10제곱 : " + Math.pow(2, 10));
	}
}
