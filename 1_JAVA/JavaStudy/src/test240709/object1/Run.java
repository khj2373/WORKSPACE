package test240709.object1;

public class Run {

	public static void main(String[] args) {
		//Member m1 = new Member("abc1", "a123", "김현준", 24, '남', "010-4666-2373", "abc1@abc.com");
		Member m1 = new Member();
		Member m2 = new Member("abc1", "123a", "최지원");
		
		m1.changeName("김현준");
		m1.printName();
		
		m2.printName();

	}

}
