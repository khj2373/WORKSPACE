package javaTest1;

public class Test_09 {

	public static void main(String[] args) {
		int[][] arr = { { 12, 41, 36, 56 }, { 82, 10, 12, 61 }, { 14, 16, 18, 78 }, { 45, 26, 72, 23 } };
		int max = arr[0][0], min = arr[0][0];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > max) {
					max = arr[i][j];
				} else if (arr[i][j] < min) {
					min = arr[i][j];
				}
			}
		}

		System.out.println("가장 큰 값 : " + max);
		System.out.println("가장 작은 값 : " + min);

	}

}
