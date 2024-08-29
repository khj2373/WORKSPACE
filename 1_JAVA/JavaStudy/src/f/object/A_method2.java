package f.object;

public class A_method2 {

	public static void main(String[] args) {
		System.out.println(adder(123, 444));
		System.out.println(adder(90));
		System.out.println(adder(90.0));

	}
	// 반환형 메소드 이름(매개변수)
	public static int adder(int num1, int num2) {
		int result = num1 + num2;
		return result;
		
	}
	// 매개변수의 갯수 또는 타입이 다르면 메소드를 구분할 수 있다. -> 메소드 오버로딩(이름은 같지만 타입이 다름)
	public static int adder(int num) {
		return num + 10;
	}
	
	public static int adder(double num) {
		return (int)(num + 100);
	}
	//반환형이 달라도 다른 메소드가 아니다 함수 호출시 반환형으로 어떤 함수를 불렀는지 구분할 수 없기 때문(무조건 소괄호 안에 변수로 구분)
//	public static double adder(int num) {
//		return num + 10.0;
//	}

}
