package test240729.object1;

import o.collection.set.Student;

public class Lottery {
	private String name;
	private String phone;

	public Lottery() {
		super();
	}

	public Lottery(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Lottery [name=" + name + ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (this.name + this.phone).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Lottery) {
			Lottery other = (Lottery) obj;
			if (this.name.equals(other.getName()) && this.phone.equals(other.getPhone())) {
				return true;
			}
		}
		return false;
	}

}
