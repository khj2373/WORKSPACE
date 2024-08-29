package h.inherit.ex1;

public class Run {

	public static void main(String[] args) {
//		Man man1 = new Man("김현준");
//		man1.tellYourName();
		
		BusinessMan man2 = new BusinessMan("김현준", "KH", "수강생");
//		man2.tellYourName();
//		man2.tellYourInfo();
		System.out.println(man2.toString());
	}

}
