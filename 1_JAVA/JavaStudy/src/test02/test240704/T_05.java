package test02.test240704;

public class T_05 {
	public static void main(String[] args) {
//		int[] n = new int[10];
//
//		for (int i = 0; i < n.length; i++) {
//			n[i] = i + 1;
//			System.out.print(n[i] + " ");
//		}

		int[] n = new int[10];

		for (int i = n.length; i >= 1; i--) {
			n[i - 1] = i;
			System.out.print(n[i-1] + " ");
		}
	}

}
