package f.object.ex3;

public class Run {

	public static void main(String[] args) {
		//클래스명 참조변수명 = new 생성자();
		Book b1 = new Book("불안을 이기는 심리학", "자기개발", "황양밍", 120);
		
		Book b2 = new Book("자바란 무엇일까?", "전공서적", "최지원", 350);
		
		Book b3 = new Book("당신을 소모시키는 모든 것을 차단하라", "자기개발", "푸수", 130);
		
		b1.setTitle("불만을 이기는 심리학");
		
//		Book b2 = new Book();
//		b2.title = "자바란 무엇일까?";
//		b2.genre = "전공서적";
//		b2.author = "최지원";
//		b2.maxPage = 350;
//		
//		Book b3 = new Book();
//		b3.title = "당신을 소모시키는 모든 것을 차단하라";
//		b3.genre = "자기개발";
//		b3.author = "푸수";
//		b3.maxPage = 130;
		
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		System.out.println(b3.toString());
	}

}
