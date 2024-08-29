package test240719.object1;

public class Run {

	public static void main(String[] args) {
		Animal[] a = {
			new Dog("개1", "견종1", 11),
			new Cat("고양이1", "묘종1", "지역1", "색상1"),
			new Dog("개2", "견종2", 12),
			new Cat("고양이2", "묘종2", "지역2", "색상2"),
			new Dog("개3", "견종3", 13)
		};
		
		for(Animal i : a) {
			i.speak();
		}

	}

}
