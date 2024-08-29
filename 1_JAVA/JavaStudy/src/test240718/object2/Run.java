package test240718.object2;

public class Run {

	public static void main(String[] args) {
		PhoneController pc = new PhoneController();
		
		String[] rs = pc.method();
		
		for(String r : rs) {
			System.out.println(r);
		}
				

	}

}
