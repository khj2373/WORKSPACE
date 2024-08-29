package javaTest2.object1;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("상품명 : ");
		String name = sc.nextLine();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		System.out.print("수량 : ");
		int quantity = sc.nextInt();
		
		Product p1 = new Product(name, price, quantity);
		
		System.out.println(p1.information());
		int rs = p1.getPrice() * p1.getQuantity();
		System.out.println("총 구매 가격 : " + rs + " 원");
		

	}

}
