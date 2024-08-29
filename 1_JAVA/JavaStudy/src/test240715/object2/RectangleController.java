package test240715.object2;

public class RectangleController {
	private Rectangle r;
	
	public RectangleController() {
		this.r = new Rectangle();
	}

	public String calcArea(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		int area = r.getWidth() * r.getHeight();
		return r.toString() + " / 사각형 넓이 : " + area;
	}

	public String calcPerimeter(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		int perimeter = (r.getWidth() + r.getHeight()) * 2;
		return r.toString() + " / 사각형 둘레 : " + perimeter;
	}
}
