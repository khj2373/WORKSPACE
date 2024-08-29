package test240719.object2;

public class Sales extends Employee implements Bonus {

	public Sales() {
		super();
	}

	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	@Override
	public void incenive(int pay) {
		int s = (int)(super.getSalary() + (pay/10) * 12);
		super.setSalary(s);
		
	}

	@Override
	public double tax() {
		double t = ((double)super.getSalary() / 100) * 13;
		return t;
	}

}
