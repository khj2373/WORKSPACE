package test240711.object2;

public class TV {
	private String product;
	private int year;
	private int inch;
	private int price;
	
	public TV() {
		
	}

	public TV(String product, int year, int inch, int price) {
		super();
		this.product = product;
		this.year = year;
		this.inch = inch;
		this.price = price;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void show() {
		System.out.println(this.product + "에서 만든 " + this.year + "년형 " + this.inch + "가격 : " + this.price);
	}

}
