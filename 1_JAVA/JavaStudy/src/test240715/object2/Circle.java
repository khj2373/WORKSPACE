package test240715.object2;

public class Circle extends Point {
	private int raidus;

	public Circle() {
		super();
	}

	public Circle(int x, int y, int raidus) {
		super(x, y);
		this.raidus = raidus;
	}

	public int getRaidus() {
		return raidus;
	}

	public void setRaidus(int raidus) {
		this.raidus = raidus;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + this.raidus;
	}

	
}
