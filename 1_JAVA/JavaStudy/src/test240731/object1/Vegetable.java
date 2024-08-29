package test240731.object1;

public class Vegetable extends Farm{
	
	private String name;

	public Vegetable() {
		super();
	}

	public Vegetable(String kind, String name) {
		super(kind);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.getKind() + " : " + this.name;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (super.getKind() + this.name).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Vegetable) {
			Vegetable other = (Vegetable)obj;
			if(super.getKind().equals(other.getKind()) && this.name.equals(other.name)) {
				return true;
			}
		}
		return false;
	}
	
	

}
