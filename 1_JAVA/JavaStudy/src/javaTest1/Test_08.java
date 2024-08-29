package javaTest1;

public class Test_08 {

	public static void main(String[] args) {
		int[][] arr = { { 12, 41, 36, 56 }, { 82, 10, 12, 61 }, { 14, 16, 18, 78 }, { 45, 26, 72, 23 } };
		double sum = 0;
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
				count++;
			}
		}
		System.out.println("합계 : " + sum);
		System.out.println("평균 " + sum / count);

	}

}
