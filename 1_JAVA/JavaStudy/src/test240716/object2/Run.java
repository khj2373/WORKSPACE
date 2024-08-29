package test240716.object2;

public class Run {

	public static void main(String[] args) throws CloneNotSupportedException {
		User[] u = {
			new User("user01", "pass01", "김철수", 32, 'M', "010-1234-5678"),
			new User("user02", "pass02", "이영희", 25, 'F', "010-1111-2222"),
			new User("user03", "pass03", "황진이", 20, 'F', "010-3333-4444")
		};
		
		System.out.println("users list -------------------------------------------------------------------");
		for(int i = 0; i < u.length; i++) {
			System.out.println(u[i].toString());
		}

		System.out.println("copy users -------------------------------------------------------------------");
		User[] cu = new User[u.length];
		for(int i = 0; i < u.length; i++) {
			cu[i] = (User)u[i].clone();
		}
		
		for(User i : cu) {
			System.out.println(i);
		}
		System.out.println("result -------------------------------------------------------------------");
		for(int i = 0; i < cu.length; i++) {
			System.out.println(cu[i].equals(u[i]));
		}
	}

}
