package javaTest2.object2;

public class Run {

	public static void main(String[] args) {
		Book[] bArry = new Book[3];
		bArry[0] = new Book("자바의 정석", "남궁성", 30000, "도우출판", 0.1);
		bArry[1] = new Book("열혈강의 자바", "구정은", 29000, "프리렉", 0.1);
		bArry[2] = new Book("객체지향 JAVA8 ", "금영욱", 30000, "북스홈", 0.1);
		
		for(int i = 0; i < bArry.length; i++) {
			String title = bArry[i].getTitle();
			String author = bArry[i].getAuthor();
			System.out.printf("%s, %s %d원, %s", bArry[i].getTitle(), bArry[i].getAuthor(), bArry[i].getPrice(), bArry[i].getPublisher());
			System.out.println("");
			System.out.println("할인된 가격 : " + (int)(bArry[i].getPrice()*(1 - bArry[i].getDiscountRate())));
		}

	}

}
