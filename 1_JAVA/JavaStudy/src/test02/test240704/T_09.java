package test02.test240704;

public class T_09 {

	public static void main(String[] args) {
		int[][] n = new int[4][4];
		int num = 1;

		for (int i = 0; i < n.length; i++) {
			
			for (int j = 0; j < n[i].length; j++) {
				
				n[i][j] = num++;
				
				if (n[i][j] < 10) {
					
					System.out.print(" ");
					
				}
				
				System.out.print(n[i][j] + " ");
				
			}
			
			System.out.println();
			
		}

	}

}
