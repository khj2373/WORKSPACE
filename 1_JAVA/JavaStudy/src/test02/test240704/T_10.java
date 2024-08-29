package test02.test240704;

public class T_10 {

	public static void main(String[] args) {
		int[][] n = new int[4][4];
		int num = 1;

		for (int i = (n.length - 1); i >= 0; i--) {

			for (int j = (n[i].length - 1); j >= 0; j--) {

				n[i][j] = num++;

			}

		}
		for (int h = 0; h < n.length; h++) {

			for (int k = 0; k < n[h].length; k++) {
				if (n[h][k] < 10) {

					System.out.print(" ");

				}

				System.out.print(n[h][k] + " ");

			}

			System.out.println();

		}

	}

}
