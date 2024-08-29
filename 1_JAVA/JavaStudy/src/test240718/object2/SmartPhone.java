package test240718.object2;

public abstract class SmartPhone implements CellPhone, TouchDisplay{
	private String maker;

	public SmartPhone() {
		super();
	}
	
	public abstract String printInformation();

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	@Override
	public String makeCall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String takeCall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String picture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String touch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String charge() {
		// TODO Auto-generated method stub
		return null;
	}

}
