package javaTest2;

public class Test02 {

	public static void main(String[] args) {
		//주어진 String 데이터를 " , "로 나누어 5개의 실수 데이터들을 꺼내어 합과 평균을 구한다
		//단, String 문자열의 모든 실수 데이터를 배열로 만들어 계산한다
		
		//문자열.split(구분자)
		//문자열을 구분자로 나눠서 배열로 반환하는 메소드
		
		//배열에 들어있는 모든 요소를 가져와서 사용하는 경우가 매우 많다.
		//for(자료명 변수명 : 배열){
		//		변수 -> 배열에 있는 모든 요소가 한번씩 들어와서 반복
		//}
		
		String str = "1.22,4.12,5.93,8.71,9.34";
		double data[]= new double[5];
		double sum = 0;
		
		String[] st;
		
		st = new String[data.length];
		
		st = str.split(",");
		
		for(int i = 0; i < data.length; i++) {
			data[i] = Double.parseDouble(st[i]);
			//sum += data[i];
		}
		//for-each문
		for(double d : data) {
			sum += d;
		}
		
		System.out.printf("합계 : %.3f", sum);
		System.out.println();
		System.out.printf("평균 : %.3f", sum/data.length);
		
	}

}
