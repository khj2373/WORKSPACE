package f.object.ex5;

public class Product {
	//객체
	private String pName, brand;
	private int price;
	
	//생성자
	public Product() {}
	
	public Product(String pName, String brand, int price) {
		this.pName = pName;
		this.brand = brand;
		this.price = price;
	}
	
	//메소드
	public void information() {
		System.out.println("상품명 : " + this.pName);
		System.out.println("제조사 : " + this.brand);
		System.out.println("가격 : " + this.price);
	}
	
	//geter seter
	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
