package test240719.object2;

public class Secretary extends Employee implements Bonus{
	public Secretary() {
		super();
	}

	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	@Override
	public void incenive(int pay) {
		int s = (int)(super.getSalary() + (pay/10) * 8);
		super.setSalary(s);
	}

	@Override
	public double tax() {
		double t = ((double)super.getSalary()) / 10;
		return t;
	}

}
