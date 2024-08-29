package test240715.object2;

public class CircleController {
	private Circle c;
	
	public CircleController() {
		this.c = new Circle();
	}

	public String calcArea(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRaidus(radius);
		double area = Math.PI * c.getRaidus() * c.getRaidus();
		return c.toString() + " / 원 넓이 : " + area;
	}
	
	public String calcCircum(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRaidus(radius);
		double circum = Math.PI * c.getRaidus() * 2;
		return c.toString() + " / 원 둘레 : " + circum;
	}

}
