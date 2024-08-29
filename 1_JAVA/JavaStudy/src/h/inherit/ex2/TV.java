package h.inherit.ex2;

public class TV extends Product {
	private int inch;

	public TV() {
		super();
	}

	public TV(String brand, String pCode, String pName, int price, int inch) {
		super(brand, pCode, pName, price);
		this.inch = inch;
	}

	@Override
	public String information() {
		return super.information() + " 크기 " + this.inch + "인치";
	}
	
	
}
