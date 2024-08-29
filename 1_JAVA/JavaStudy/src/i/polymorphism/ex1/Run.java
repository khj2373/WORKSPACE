package i.polymorphism.ex1;

public class Run {

	public static void main(String[] args) {
		/*
		 * 클래스 참조변수 = new 클래스 생성자;
		 * (부모 클래스가 올 수 있다) / (자식클래스로 생성할 수 있다)
		 * 참조변수 : 실제로 어디까지 접근 가능 / 생성자 : 실제로 어떤 형태의 메모리가 생성이 되는가
		 */

		Cake c1 = new CheeseCake();
		//Cake까지 접근가능하며 메모리 공간은 실제 CheeseCake다
		c1.sweet();
		c1.yummy();
		
		//CheeseCake c2 = new Cake();
		//실제 메모리 공간이 Cake이므로 CheeseCake공간에 접근할 수 없다
	
	}

}
