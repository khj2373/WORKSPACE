package o.collection.map;

public class Snack {
	private String flavor;
	private int kcal;
	
	public Snack() {
		super();
	}

	public Snack(String flavor, int kcal) {
		super();
		this.flavor = flavor;
		this.kcal = kcal;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	@Override
	public String toString() {
		return "Snack [flavor=" + flavor + ", kcal=" + kcal + "]";
	}
	
	
}
