package j.Interface.ex2;

public class Rectangle implements Shape{
	private double width, height;

	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return width * height;
	}
}
