package javaTest1;

public class Test_03 {

	public static void main(String[] args) {
		int n = 1;
		int sum = 0;
		while (n <= 100) {
			sum += n;
			n++;
		}
		System.out.println(sum);
		System.out.println(sum / 100.0);

	}

}
