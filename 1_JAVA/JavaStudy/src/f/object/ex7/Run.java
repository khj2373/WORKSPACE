package f.object.ex7;

public class Run {

	public static void main(String[] args) {
		Book b1 = new Book("책1", "출판사1", "저자1", 76002, 20);
		Book b2 = new Book("책2", "출판사2", "저자2");
		Book b3 = new Book();
		
		b1.inform();
		System.out.println();
		b2.inform();
		System.out.println();
		b3.inform();

	}

}
